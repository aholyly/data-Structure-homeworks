package part4;

import part3.DoubleLinkedList;
import part3.MergeSortDLL;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class analyze 5 different sorting algorithms average runtime for 10 different size of random arrays 10 times.
 */
public class AverageRuntimeAnalysis {

    public static void main(String [] args) {
        Random rand = new Random();
        Integer[][] tables = new Integer[10][];
        long startTime, estimatedTime;
        ArrayList<Long>
                time_heap = new ArrayList<>(),
                time_insert = new ArrayList<>(),
                time_merge = new ArrayList<>(),
                time_mergedll = new ArrayList<>(),
                time_quick = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int maxElement = (100)*(i+1)*(i+1);
            tables[i] = new Integer[maxElement];
            for (int j = 0; j < maxElement; j++) {
                tables[i][j] = rand.nextInt(10000) + 1;
            }
        }

        Integer[][] temp_heap = new Integer[10][];
        Integer[][] temp_insert = new Integer[10][];
        Integer[][] temp_merge = new Integer[10][];
        Integer[][] temp_quick = new Integer[10][];
        Integer[][] temp_mergedll = new Integer[10][];

        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("                               AVERAGE RUNTIME ANALYSIS                                      ");
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.print("Size\t\t");
        for (int i = 0; i < 10; i++) {
            int maxElement = (100)*(i+1)*(i+1);
            if(i == 0 || i == 1 || i == 2)
                System.out.print(maxElement+"\t\t");
            else
                System.out.print(maxElement+"\t");
        }
        System.out.println("\n---------------------------------------------------------------------------------------------");

        for (int i = 0; i < 10; i++) {
            int maxElement = (100)*(i+1)*(i+1);

            temp_heap[i] = new Integer[maxElement];
            temp_insert[i] = new Integer[maxElement];
            temp_merge[i] = new Integer[maxElement];
            temp_quick[i] = new Integer[maxElement];
            temp_mergedll[i] = new Integer[maxElement];

            System.arraycopy(tables[i],0,temp_heap[i],0,maxElement);
            System.arraycopy(tables[i],0,temp_insert[i],0,maxElement);
            System.arraycopy(tables[i],0,temp_merge[i],0,maxElement);
            System.arraycopy(tables[i],0,temp_quick[i],0,maxElement);
            System.arraycopy(tables[i],0,temp_mergedll[i],0,maxElement);

            // <HEAP SORT AVERAGE TIME CALCULATION>
            for (int j = 0; j < 10; j++) {
                startTime = System.nanoTime();
                HeapSort.sort(temp_heap[i]);
                estimatedTime = System.nanoTime() - startTime;
                time_heap.add(estimatedTime);
            }
            // </HEAP SORT AVERAGE TIME CALCULATION>

            // <INSERTION SORT AVERAGE TIME CALCULATION>
            for (int j = 0; j < 10; j++) {
                startTime = System.nanoTime();
                HeapSort.sort(temp_insert[i]);
                estimatedTime = System.nanoTime() - startTime;
                time_insert.add(estimatedTime);
            }
            // </INSERTION AVERAGE TIME CALCULATION>

            // <MERGE SORT AVERAGE TIME CALCULATION>
            for (int j = 0; j < 10; j++) {
                startTime = System.nanoTime();
                HeapSort.sort(temp_merge[i]);
                estimatedTime = System.nanoTime() - startTime;
                time_merge.add(estimatedTime);
            }
            // </MERGE AVERAGE TIME CALCULATION>

            // <QUICK SORT AVERAGE TIME CALCULATION>
            for (int j = 0; j < 10; j++) {
                startTime = System.nanoTime();
                HeapSort.sort(temp_quick[i]);
                estimatedTime = System.nanoTime() - startTime;
                time_quick.add(estimatedTime);
            }
            // </QUICK SORT AVERAGE TIME CALCULATION>

            // <MERGE SORT WITH DLL AVERAGE TIME CALCULATION>
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            for (int j = 0; j < temp_mergedll[i].length; j++) {
                list.addAfter(temp_mergedll[i][j]);
            }
            for (int j = 0; j < 10; j++) {
                startTime = System.nanoTime();
                MergeSortDLL.sort(list.getHead());
                estimatedTime = System.nanoTime() - startTime;
                time_mergedll.add(estimatedTime);
            }
            // </MERGE SORT WITH DLL AVERAGE TIME CALCULATION>
        }

        int average = 0;

        System.out.print("HEAP:\t\t");
        for (int i = 0; i < 100; i++) {
            if(i%10 == 9){
                average /= 10;
                System.out.print(average+"\t");
            }
            average += time_heap.get(i);
        }
        System.out.println();

        System.out.print("INSERT:\t\t");
        for (int i = 0; i < 100; i++) {
            if(i%10 == 9){
                average /= 10;
                System.out.print(average+"\t");
            }
            average += time_insert.get(i);
        }
        System.out.println();

        System.out.print("MERGE:\t\t");
        for (int i = 0; i < 100; i++) {
            if(i%10 == 9){
                average /= 10;
                System.out.print(average+"\t");
            }
            average += time_merge.get(i);
        }
        System.out.println();

        System.out.print("MERGEDLL:\t");
        for (int i = 0; i < 100; i++) {
            if(i%10 == 9){
                average /= 10;
                System.out.print(average+"\t");
            }
            average += time_mergedll.get(i);
        }
        System.out.println();

        System.out.print("QUICK:\t\t");
        for (int i = 0; i < 100; i++) {
            if(i%10 == 9){
                average /= 10;
                System.out.print(average+"\t");
            }
            average += time_quick.get(i);
        }

        System.out.println("\n---------------------------------------------------------------------------------------------");
        System.out.println("The unit of time is 'Nanoseconds'.");
    }
}
