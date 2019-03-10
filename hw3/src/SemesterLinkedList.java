import java.util.*;

/**
 * This is a user defined LinkedList class
 */
public class SemesterLinkedList{
	private static Node head;
	private static int size = 0;

	/**
	 * Default constructor
	 */
	public SemesterLinkedList() {
		head = null;
	}

	/**
	 * Constructor for getting Course input
	 * @param course input
	 */
	public SemesterLinkedList(Course course){
		head = new Node(course);
	}

	/**
	 * Add the last of list
	 * @param course
	 */
	public void add(Course course){
		if (head == null)
			head = new Node(course);

		Node temp = head;

		while(temp.next != null){
			temp = temp.next;
		}
		
		temp.next = new Node(course);
		size++;
	}

	/**
	 * Add element to given index
	 * @param index given index
	 * @param course element
	 */
	public void add(int index, Course course){
		if (head == null)
			head = new Node(course);

		Node temp = head;
		Node holder;
		
		for(int i=0; i < index-1 && temp.next != null; i++){
			temp = temp.next;
		}
		holder = temp.next;
		temp.next = new Node(course);
		temp.next.next = holder;
		size++;
	}

	/**
	 * Removes element in given index
	 * @param index given index
	 */
	public void remove(int index){
		Node temp = head;

		for(int i = 0; i < index - 1 && temp.next != null; i++){
			temp = temp.next;
		}
		temp.next = temp.next.next;
		size--;
	}

	/**
	 * Object overridden toString method
	 * @return string
	 */
	@Override
	public String toString(){
		Node temp = head;
		String str = null;

		while(temp != null){
			str += temp.course + ",";
			temp = temp.next;
		}
		str += "\n";

		return str;
	}

	/**
	 * Return number of elements
	 * @return number of elements
	 */
	public static int size(){
		return size;
	}

	/**
	 * Iterator for semester class
	 * @return iterator
	 */
	public SemesterIterator iterator(){
		return new SemesterIterator();
	}

	/***************INNER CLASSES************/
	/**
	 * This is an iterator class for semesterLinkedList
	 */
	public class SemesterIterator{
		private Node current;

		/**
		 * Constructor for SemesterIterator
		 */
		public SemesterIterator(){
			current = head;
		}

		/**
		 * Next item
		 * @return next
		 */
		public Course next(){
			if( !hasNext() ) 
				throw new NoSuchElementException();

			Course nextElement = current.course;
			current = current.next;

			return nextElement;
		}

		/**
		 * If there is a next item, return true
		 * @return boolean true
		 */
		public boolean hasNext(){
			return current != null;
		}

		/**
		 * Next node in same semester
		 * @param semester value of semester
		 * @return next node
		 */
		public Course nextInSemester(int semester){
			if( !hasNext() ){
				current = head;
			}

			while(current.course.getSemester() != semester){
				current = current.next;

				if( !hasNext() ){
				current = head;
				}
			}

			Course nextElement = current.course;
			current = current.next;

			return nextElement;
		}
	}

	/**
	 * This class provides connection between linked elements
	 */
	private class Node{
		private Node next;
		private Course course;
		
		public Node(Course course){
			this.course = course;
		}
	}
}