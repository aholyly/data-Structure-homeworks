package part3;

/**
 * This class is a generic double linked list implementation
 * @param <E> Generic Element
 */
public class DoubleLinkedList<E extends Comparable<E>> {
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    /**
     * Constructor does nothing
     */
    public DoubleLinkedList() {
    }

    /**
     * @return head of the list
     */
    public Node getHead() {
        return head;
    }

    /**
     * Prints all elements inside the list
     */
    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    /**
     * Adds an element tail of the list
     * @param element
     */
    public void addAfter(E element){
        Node temp = new Node(element);
        if(head == null){
            head = temp;
            tail = head;
        }
        else{
            tail.next = temp;
            tail = tail.next;
        }
        size++;
    }

    /**
     * This class is a node class for link the elements
     * @param <E>
     */
    public static class Node<E extends Comparable<E>> implements Comparable<E> {
        E data;
        Node next;
        Node prev;

        public Node(E data) {
            this.data = data;
            next = null;
            prev = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }

        @Override
        public int compareTo(E o) {
            return data.compareTo(o);
        }
    }
}
