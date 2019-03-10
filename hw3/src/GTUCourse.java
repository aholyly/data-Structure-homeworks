import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This class is read information from file and hold this information in LinkedList
 */
public class GTUCourse {
	private LinkedList<Course> courseList;
	private String FILENAME = "Courses.csv";

	/**
	 * Allocate linkedList and read courses from CSV file.
	 */
	public GTUCourse(){
		courseList = new LinkedList<>();
		readCourses();
	}

	public LinkedList<Course> getCourseList() {
		return courseList;
	}

	/**
	 * Prints given list to the screen
	 * @param list list to print screen
	 */
	void printList(LinkedList<Course> list){
		for (int i = 0; i < list.size(); ++i) {
			System.out.println(list.get(i).toString() );
		}
	}

	/**
	 * This method eads courses information from csv file and adds to linkedList
	 */
	public void readCourses(){
		System.out.println("Reading from '"+FILENAME+"'");
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

					courseList.add(temp);
                }   
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
	}

	/**
	 * This method gets all elements by given course code
	 * @param code given course code
	 * @return found courses
	 */
	public LinkedList<Course> getByCode(String code) throws Exception{
		LinkedList<Course> temp = new LinkedList<>();

		for (int i = 0; i < courseList.size(); ++i) {
			if(courseList.get(i).getCode().equals(code)){
				temp.add(courseList.get(i));
			}

			if (temp.size() == 0)
				throw new Exception("Given course code cannot found!");
		}

		return temp;
	}

	/**
	 * This method gets all elements by given semester
	 * @param semester given course semester
	 * @return found courses
	 */
	LinkedList<Course> listSemesterCourses (int semester) throws Exception{
		LinkedList<Course> temp = new LinkedList<>();

		for (int i = 0; i < courseList.size(); ++i) {
			if(courseList.get(i).getSemester() == semester){
				temp.add(courseList.get(i));
			}
		}

		if (temp.size() == 0)
			throw new Exception("Given semester cannot found!");

		return temp;
	}

	/**
	 * This method gets all elements by given range.
	 * @param start_index start index of range
	 * @param last_index end index of range
	 * @return found elements in range
	 * @throws Exception
	 */
	LinkedList<Course> getByRange(int start_index, int last_index) throws Exception{
		int listSize = courseList.size(),
			rangeSize = last_index - start_index + 1;

		//ERROR CHECK
		if(start_index < 0 || last_index < 0)
			throw new Exception("Index less than zero!");
		if(start_index > last_index)
			throw new Exception("Start index bigger than last index!");
		if(rangeSize > listSize)
			throw new Exception("Out of range!");
		//////////////////

		LinkedList<Course> temp = new LinkedList<>();

		for (int i = start_index; i < last_index; ++i) {
			temp.add(courseList.get(i));
		}

		return temp;
	}
}