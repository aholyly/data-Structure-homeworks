import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * This class is a derived class from LinkedList. The difference between
 * the two is we can enable and disable elements.
 * @param <E> generic type E
 */
public class ControllableLinkedList<E> extends LinkedList<E> {


	private ArrayList<Integer> status;
	private String FILENAME = "Courses.csv";

	/**
	 * Constructor is used for allocate ArrayList
	 */
	public ControllableLinkedList(){
		super();
		status = new ArrayList<>();
	}

	/**
	 * Get status of arrayList
	 * @return
	 */
	public ArrayList<Integer> getStatus() {
		return status;
	}
	/**************** OVERRIDES ****************/
	/**
	 * This overridden method is provides tag the added elements enabled.
	 * @param element element to add end of the list
	 * @return added or not
	 */
	@Override
	public boolean add(E element){
		boolean returnVal = super.add(element);
		
		status.add(1);

		return returnVal;
	}

	/**
	 * This overridden method is provides tag the added elements enabled.
	 * @param index index of element to add
	 * @param element element to add end of the list
	 */
	@Override
	public void add(int index, E element){
		super.add(index,element);

		status.add(index,1);
	}

	/**
	 * This overridden method is provides remove the tag
	 * @return removed element
	 */
	@Override
	public E remove(){
		E returnVal = null;
		
		if(status.get(0) == 1){ //enabled
			returnVal = super.remove();
			status.remove(0);
		}
		else
			System.out.println("Cannot remove disabled item!");
		
		return returnVal;
	}

	/**
	 * This overridden method is provides remove the tag
	 * @param index index of element to remove
	 * @return removed element
	 */
	@Override
	public E remove(int index){
		E returnVal = null;
		
		if(status.get(index) == 1){ //enabled
			returnVal = super.remove(index);
			status.remove(index);
		}
		else
			System.out.println("Cannot remove disabled item!");
		
		return returnVal;
	}

	/**
	 * This overridden method is provides remove all tags
	 */
	@Override
	public void clear(){
		super.clear();

		status.clear();
	}

	/**
	 * This overridden method gets the enabled element at index
	 * @param index index of element
	 * @return element at index
	 */
	@Override
	public E get(int index){
		E returnVal = null;

		if(status.get(index) == 1) //enabled
			returnVal = super.get(index);
		else
			System.out.println("Cannot get disabled item!");
		
		return returnVal;
	}

	/**
	 * This overridden method gets listIterator of linked list
	 * @param index index of head
	 * @return list iterator
	 */
	@Override
	public ListIterator<E> listIterator(int index){
		if(status.get(index) == 0)
			return null;

		return super.listIterator(index);
	}

	/**
	 * This overridden method counts enabled elements
	 * @return size of enabled elements
	 */
	@Override
	public int size(){
		int size = 0;

		for(int i = 0; i < status.size(); ++i) {
			if(status.get(i) == 1)
				size++;
		}

		return size;
	}

	/**
	 * This overridden method sets indexed element
	 * @param index index of element
	 * @param element element to set
	 * @return element previously at the index
	 */
	@Override
	public E set(int index, E element){
		E returnVal = null;
		
		if(status.get(index) == 1) //enabled
			returnVal = super.set(index,element);
		else
			System.out.println("Cannot set disabled item!");
		
		return returnVal;
	}
	/*******************************************/

	/**
	 * Disables indexed element to provide changing, deleting and printing actions
	 * @param index index of element
	 */
	public void disable(int index){
		//ERROR CHECK
		status.set(index,0);
	}

	/**
	 * Enables indexed element from disabled actions
	 * @param index index of element
	 */
	public void enable(int index){
		//ERROR CHECK
		status.set(index,1);
	}

	/**
	 * Prints all disabled elements to screen. If list is clear, prints nothing.
	 */
	public void showDisabled(){
		for (int i = 0; i < super.size(); ++i) {
			if(status.get(i) == 0)
				System.out.println(super.get(i)+" ");
		}
	}

	/**
	 * This method reads course list from csv file and return this list.
	 * @return course list
	 */
	public ControllableLinkedList<Course> readCourses(){
		System.out.println("Reading from '"+FILENAME+"'");
		ControllableLinkedList<Course> tempList = new ControllableLinkedList<>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(FILENAME));
			String line;

			//Read file line by line while file not reached end of file
			while ( (line = in.readLine() ) != null) {
				String[] tokens = line.split(";");

				if(!tokens[0].equals("Semester")){
					Course temp = new Course(Integer.parseInt(tokens[0]),
							tokens[1],tokens[2],Integer.parseInt(tokens[3]),
							Integer.parseInt(tokens[4]),tokens[5]);

					tempList.add(temp);
				}
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}

		return tempList;
	}
}