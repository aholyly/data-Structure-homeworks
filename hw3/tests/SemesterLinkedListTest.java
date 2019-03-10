import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SemesterLinkedListTest {

    private SemesterLinkedList course = new SemesterLinkedList();



    @Test
    void addRemoveSize() {
        Course c= new Course(1, "XXXX","Introduction To Computer Engineering",8,8,"3+3+3");

        course.add(c);
        course.add(1,c);
        course.remove(1);
        assertEquals(1,course.size());
    }

}