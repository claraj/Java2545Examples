package week6_first_classes.OOPITECCourseManager;

/**
 * Class with the main method in - create and work with some ITECCourse objects
 */
public class ITECCourseManager {

    public static void main(String args[]) {
        ITECCourse maintenanceCourse = new ITECCourse();
        maintenanceCourse.name = "Microcomputer Systems Maintenance";
        maintenanceCourse.code = 1310;
        maintenanceCourse.maxStudents = 20;

        //Add some students.
        //TODO check that we have not exceeded the max number for the class

        maintenanceCourse.addStudent("Anna");
        maintenanceCourse.addStudent("Bill");
        maintenanceCourse.addStudent("Carl");

        maintenanceCourse.writeCourseInfo();

        ITECCourse datacomCourse = new ITECCourse();
        datacomCourse.name = "Data Communications";
        datacomCourse.code = 1425;
        datacomCourse.maxStudents = 30;

        datacomCourse.addStudent("Dave");
        datacomCourse.addStudent("Ed");
        datacomCourse.addStudent("Flora");

        datacomCourse.writeCourseInfo();

    }

}

