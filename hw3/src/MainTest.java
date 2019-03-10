public class MainTest{
	
	public static void main(String[] args) {

		test_part1();
		test_part2();
		test_part3();




	}

	public static void test_part1(){
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("                                   PART 1                                     ");
		System.out.println("------------------------------------------------------------------------------");

		GTUCourse gtuCourse = new GTUCourse(); //Object constructor automatically reads from file

		gtuCourse.printList(gtuCourse.getCourseList());
		try {
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("Getting by code 'XXX XXX' and printing this list");
			gtuCourse.printList(gtuCourse.getByCode("XXX XXX"));
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("Getting semester '3' and printing this list");
			gtuCourse.printList(gtuCourse.listSemesterCourses(3));
			System.out.println("------------------------------------------------------------------------------");
		}
		catch (Exception e){
			System.out.println(e);
		}


		try {
			System.out.println("Getting by range between '0' and '6' and printing this list");
			gtuCourse.printList(gtuCourse.getByRange(0,6));
			System.out.println("Getting by range between '-1' and '4' and printing this list");
			gtuCourse.printList(gtuCourse.getByRange(-1,4));
		}
		catch (Exception e){
			System.out.println(e);
		}

	}
	public static void test_part2(){
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("                                   PART 2                                     ");
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Disable, enable, size");
		System.out.println("---------------------");

		ControllableLinkedList<Course> courseList = new ControllableLinkedList<>();
		courseList = courseList.readCourses();

		System.out.println("Size of list before disabling items: "+courseList.size());
		courseList.showDisabled();
		System.out.println("Disabling 0,1,2 indexes");
		courseList.disable(0);
		courseList.disable(1);
		courseList.disable(2);
		System.out.println("Size of list after disabling items: "+courseList.size());
		System.out.println("Disabled items: ");
		courseList.showDisabled();
		System.out.println("Enabling index 0");
		System.out.println("Disabled items: ");
		courseList.enable(0);
		courseList.showDisabled();

		System.out.println("------------------------------------------------------------------------------");
		System.out.println("get, set, remove");
		System.out.println("----------------");

		System.out.println("Getting index 0 (enabled item)");
		System.out.println(courseList.get(0));
		System.out.println("\nGetting index 1 (disabled item)");
		System.out.println(courseList.get(1));

		System.out.println("\nRemoving index 0 (enabled item)");
		courseList.remove(0);
		System.out.println("Now index 0 and index 1 are disabled");

		System.out.println("\nRemoving index 0 (disabled item)");
		courseList.remove(0);

		System.out.println("\nSetting index 5 (enabled item)");
		System.out.println(courseList.set(5,courseList.get(10)));
		System.out.println("\nSetting index 1 (disabled item)");
		System.out.println(courseList.set(1,courseList.get(10)));
	}

	public static void test_part3(){
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("                                   PART 3                                     ");
		System.out.println("------------------------------------------------------------------------------");

		GTUCourse gtuCourse = new GTUCourse();
		SemesterLinkedList semesterLinkedList = new SemesterLinkedList();

		for (int i = 0; i < gtuCourse.getCourseList().size(); i++) {
			semesterLinkedList.add(gtuCourse.getCourseList().get(i));
		}

		System.out.println("------------------------------------------------------------------------------");
		System.out.println("iterator hasNext()");
		System.out.println("---------");

		SemesterLinkedList.SemesterIterator it1 = semesterLinkedList.iterator();

		while (it1.hasNext()){
			System.out.println(it1.next());
		}

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("iterator nextInSemester(1) 15 times");
        System.out.println("---------");
        SemesterLinkedList.SemesterIterator it2 = semesterLinkedList.iterator();
        for (int i = 0; i < 15; i++) {
            System.out.println(it2.nextInSemester(1));
        }
	}
}