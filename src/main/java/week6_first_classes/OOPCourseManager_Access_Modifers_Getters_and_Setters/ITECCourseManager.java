package week6_first_classes.OOPCourseManager_Access_Modifers_Getters_and_Setters;

/**
 * Class with the main method in - create and work with some ITECCourse objects
 */
public class ITECCourseManager {

    public static void main(String args[]) {

        //Much less code!
        ITECCourse maintenanceCourse = new ITECCourse("Microcomputer Systems Maintenance", 1310, 20);

        //Add some students.
        maintenanceCourse.addStudent("Anna");
        maintenanceCourse.addStudent("Bill");
        maintenanceCourse.addStudent("Carl");

        //Carl decided to drop the class...
        maintenanceCourse.removeStudent("Carl");

        maintenanceCourse.writeCourseInfo();

        // Can also get individual variable values with getter methods
        System.out.println("Course name is + " + maintenanceCourse.getName());
        System.out.println("Course code is + " + maintenanceCourse.getCode());

        System.out.println("Max students in the course is " + maintenanceCourse.getMaxStudents());

        //And can set variables, if set methods are provided

        //Let's increase the max number of students

        maintenanceCourse.setMaxStudents(24);
        System.out.println("The maximum number of students is now " + maintenanceCourse.getMaxStudents());


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

