import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllableLinkedListTest {

    private ControllableLinkedList<Course> course = new ControllableLinkedList<>();
    Course c=new Course(1,"XXX","Software",1,1,"3+3+3");
    @Test
    void add() {
        Course c=new Course(1,"XXX","Software",1,1,"3+3+3");
        assertEquals(true,course.add(c));
    }

    @Test
    void remove() {
        course.add(c);
        course.remove();
        assertEquals(0,course.size());
    }

    @Test
    void get() {
        course.add(c);
        assertEquals(c,course.get(0));
    }

    @Test
    void size() {
        course.add(c);
        assertEquals(1,course.size());
    }

}