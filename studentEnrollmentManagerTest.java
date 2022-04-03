import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class studentEnrollmentManagerTest {
    List<studentEnrollment> testList = new ArrayList<studentEnrollment>();



    @org.junit.Test
    public void add() {
        System.out.println("Test add() method");
        studentEnrollmentManager.add();

    }

    @org.junit.Test
    public void displayAll() {
        studentEnrollmentManager.displayAll();
    }

    @org.junit.Test
    public void displayAllCourseInOneSemester() {
        studentEnrollmentManager.displayAllCourseInOneSemester();
    }

    @org.junit.Test
    public void displayAllStudentInOneCourse() {
        studentEnrollmentManager.displayAllStudentInOneCourse();
    }

    @org.junit.Test
    public void displayAllCourseOfOneStudent() {
        studentEnrollmentManager.displayAllCourseOfOneStudent();
    }

    @org.junit.Test
    public void updateStudentEnrollment() {
        studentEnrollmentManager.updateStudentEnrollment();
    }

    @org.junit.Test
    public void deleteEnrollment() {
        studentEnrollmentManager.deleteEnrollment();
    }

    @org.junit.Test
    public void printOutData() {
        studentEnrollmentManager.printOutData();
    }
}