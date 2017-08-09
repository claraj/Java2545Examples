package week6_first_classes.OOPITECCourseManager_AccessModifiers;

/**
 * Class with the main method in - create and work with some ITECCourse objects
 */
public class ITECCourseManager {

    public static void main(String args[]) {

        //Much less code!
        ITECCourse maintenanceCourse = new ITECCourse("Microcomputer Systems Maintenance", 1310, 20);

        //Add some students.
        //TODO check that we have not exceeded the max number for the class

        maintenanceCourse.addStudent("Anna");
        maintenanceCourse.addStudent("Bill");
        maintenanceCourse.addStudent("Carl");

        //Carl decided to drop the class...
        maintenanceCourse.removeStudent("Carl");

        maintenanceCourse.writeCourseInfo();

        ITECCourse datacomCourse = new ITECCourse("Data Communications", 1424, 30);

        datacomCourse.addStudent("Dave");
        datacomCourse.addStudent("Ed");
        datacomCourse.addStudent("Flora");

        datacomCourse.writeCourseInfo();


        //Test the add students method with an example class
        // This class has a max of 3 students
        ITECCourse smallCourse = new ITECCourse("Made up name small class", 1234, 3);
        smallCourse.addStudent("Jake");
        smallCourse.addStudent("Kirby");
        smallCourse.addStudent("Liam");
        //We shouldn't be able to add another student – what happens?
        smallCourse.addStudent("Marigold");

    }

}

