import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GTUCourseTest {

    private GTUCourse course=new GTUCourse();
    @Test
    void getByCode() throws Exception { assertEquals(9,course.getByCode("XXX XXX").size()); }

    @Test
    void listSemesterCourses() throws Exception {
        assertEquals(8,course.listSemesterCourses(1).size());
    }

    @Test
    void getByRange() throws Exception {
        assertEquals(2,course.getByRange(1,3).size());
    }
}