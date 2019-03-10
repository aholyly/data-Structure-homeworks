package part3;

/**
 * This class is a sorting method that split and sort and merge the list.
 * @param <E> Generic Element
 */
public class MergeSortDLL<E extends Comparable<E>> {

    static DoubleLinkedList.Node head;  // head of list

    /**
     * Prints all elements inside the list
     * @param node
     */
    public void print(DoubleLinkedList.Node node){
        DoubleLinkedList.Node temp = node;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    /**
     * Split the list to half
     * @param head
     * @return first half of list
     */
    private static DoubleLinkedList.Node split(DoubleLinkedList.Node head) {
        DoubleLinkedList.Node first = head, second = head;
        while (first.next != null && first.next.next != null) {
            first = first.next.next;
            second = second.next;
        }
        DoubleLinkedList.Node temp = second.next;
        second.next = null;
        return temp;
    }

    /**
     * Sorting method of class
     * @param node
     * @return sorted list
     */
    public static DoubleLinkedList.Node sort(DoubleLinkedList.Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        DoubleLinkedList.Node second = split(node);

        // Recur for left and right halves
        node = sort(node);
        second = sort(second);

        // Merge the two sorted halves
        return merge(node, second);
    }

    /**
     * Merge two given lists
     * @param first - first half of given list
     * @param second - second half of given list
     * @return merged list
     */
    private static DoubleLinkedList.Node merge(DoubleLinkedList.Node first, DoubleLinkedList.Node second) {
        // If first linked list is empty
        if (first == null) {
            return second;
        }

        // If second linked list is empty
        if (second == null) {
            return first;
        }

        // Pick the smaller value
        if (first.data.compareTo(second.data) < 0) {
            first.next = merge(first.next, second);
            first.next.prev = first;
            first.prev = null;
            return first;
        } else {
            second.next = merge(first, second.next);
            second.next.prev = second;
            second.prev = null;
            return second;
        }
    }
}