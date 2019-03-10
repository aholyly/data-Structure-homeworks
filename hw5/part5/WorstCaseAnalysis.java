package part5;

import part3.DoubleLinkedList;
import part3.MergeSortDLL;
import part4.HeapSort;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class analyze 5 different sorting algorithms worts-case runtime for 5 different size of arrays.
 */
public class WorstCaseAnalysis {

    public static void main(String [] args) {
        Random rand = new Random();
        Integer[][] tables = new Integer[5][];
        long startTime, estimatedTime;
        ArrayList<Long>
                time_heap = new ArrayList<>(),
                time_insert = new ArrayList<>(),
                time_merge = new ArrayList<>(),
                time_mergedll = new ArrayList<>(),
                time_quick = new ArrayList<>();
        ArrayList<Integer> maxSize = new ArrayList<>();

        tables[0] = new Integer[100];
        tables[1] = new Integer[1000];
        tables[2] = new Integer[5000];
        tables[3] = new Integer[10000];
        tables[4] = new Integer[20000];
        maxSize.add(100);maxSize.add(1000);maxSize.add(5000);maxSize.add(10000);maxSize.add(20000);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < tables[i].length; j++) {
                tables[i][j] = (tables[i].length)-j;
            }
        }

        Integer[][] temp_heap = new Integer[5][];
        Integer[][] temp_insert = new Integer[5][];
        Integer[][] temp_merge = new Integer[5][];
        Integer[][] temp_quick = new Integer[5][];
        Integer[][] temp_mergedll = new Integer[5][];

        System.out.println("------------------------------------------------------");
        System.out.println("                 WORST-CASE ANALYSIS                  ");
        System.out.println("------------------------------------------------------");
        System.out.print("Size\t\t");
        for (int i = 0; i < 5; i++) {
            System.out.print(maxSize.get(i)+"\t");
            if (i == 0)
                System.out.print("\t");

        }
        System.out.println("\n------------------------------------------------------");

        for (int i = 0; i < 5; i++) {
            temp_heap[i] = new Integer[maxSize.get(i)];
            temp_insert[i] = new Integer[maxSize.get(i)];
            temp_merge[i] = new Integer[maxSize.get(i)];
            temp_quick[i] = new Integer[maxSize.get(i)];
            temp_mergedll[i] = new Integer[maxSize.get(i)];

            System.arraycopy(tables[i],0,temp_heap[i],0,maxSize.get(i));
            System.arraycopy(tables[i],0,temp_insert[i],0,maxSize.get(i));
            System.arraycopy(tables[i],0,temp_merge[i],0,maxSize.get(i));
            System.arraycopy(tables[i],0,temp_quick[i],0,maxSize.get(i));
            System.arraycopy(tables[i],0,temp_mergedll[i],0,maxSize.get(i));

            // <HEAP SORT AVERAGE TIME CALCULATION>
                startTime = System.nanoTime();
                HeapSort.sort(temp_heap[i]);
                estimatedTime = System.nanoTime() - startTime;
                time_heap.add(estimatedTime);
            // </HEAP SORT AVERAGE TIME CALCULATION>

            // <INSERTION SORT AVERAGE TIME CALCULATION>
                startTime = System.nanoTime();
                HeapSort.sort(temp_insert[i]);
                estimatedTime = System.nanoTime() - startTime;
                time_insert.add(estimatedTime);
            // </INSERTION AVERAGE TIME CALCULATION>

            // <MERGE SORT AVERAGE TIME CALCULATION>
                startTime = System.nanoTime();
                HeapSort.sort(temp_merge[i]);
                estimatedTime = System.nanoTime() - startTime;
                time_merge.add(estimatedTime);
            // </MERGE AVERAGE TIME CALCULATION>

            // <QUICK SORT AVERAGE TIME CALCULATION>
                startTime = System.nanoTime();
                HeapSort.sort(temp_quick[i]);
                estimatedTime = System.nanoTime() - startTime;
                time_quick.add(estimatedTime);
            // </QUICK SORT AVERAGE TIME CALCULATION>

            // <MERGE SORT WITH DLL AVERAGE TIME CALCULATION>
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            for (int j = 0; j < temp_mergedll[i].length; j++) {
                list.addAfter(temp_mergedll[i][j]);
            }
            startTime = System.nanoTime();
            MergeSortDLL.sort(list.getHead());
            estimatedTime = System.nanoTime() - startTime;
            time_mergedll.add(estimatedTime);
            // </MERGE SORT WITH DLL AVERAGE TIME CALCULATION>
        }


        System.out.print("HEAP:\t\t");
        for (int i = 0; i < 5; i++) {
            System.out.print(time_heap.get(i)+"\t");
        }
        System.out.println();

        System.out.print("INSERT:\t\t");
        for (int i = 0; i < 5; i++) {
            System.out.print(time_insert.get(i)+"\t");
        }
        System.out.println();

        System.out.print("MERGE:\t\t");
        for (int i = 0; i < 5; i++) {
            System.out.print(time_merge.get(i)+"\t");
        }
        System.out.println();

        System.out.print("MERGEDLL:\t");
        for (int i = 0; i < 5; i++) {
            System.out.print(time_mergedll.get(i)+"\t");
        }
        System.out.println();

        System.out.print("QUICK:\t\t");
        for (int i = 0; i < 5; i++) {
            System.out.print(time_quick.get(i)+"\t");
        }

        System.out.println("\n------------------------------------------------------");
        System.out.println("The unit of time is 'Nanoseconds'.");
    }
}
