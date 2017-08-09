package week6_first_classes;

import java.util.ArrayList;


/**
 * Not an object oriented program.
 */
public class ITECCourseManager_NoObjects {

    public static void main(String args[]) {

        String maintenanceCourseName = "Microcomputer Systems Maintenance";
        int maintenanceCourseCode = 1310;
        ArrayList<String> maintenanceCourseStudentList = new ArrayList<String>();
        int maintenanceCourseMaxStudents = 20;

        //Add some students.   TODO check that we have not exceeded the max number for the class
        maintenanceCourseStudentList.add("Anna");
        maintenanceCourseStudentList.add("Bill");
        maintenanceCourseStudentList.add("Carl");

        String datacomCourseName = "Data Communications";
        int datacomCourseCode = 1425;
        ArrayList<String> datacomCourseStudentList = new ArrayList<String>();
        int datacomCourseMaxStudents = 30;

        //Add some students
        datacomCourseStudentList.add("Dave");
        datacomCourseStudentList.add("Ed");
        datacomCourseStudentList.add("Flora");

        //Print information about these courses
        writeCourseInfo(maintenanceCourseName, maintenanceCourseCode, maintenanceCourseStudentList, maintenanceCourseMaxStudents);
        writeCourseInfo(datacomCourseName, datacomCourseCode, datacomCourseStudentList, datacomCourseMaxStudents);
    }

    public static void writeCourseInfo(String name, int code, ArrayList<String>students, int maxStudents) {
        System.out.println("Course Name: " + name);
        System.out.println("Course Code: " + code);
        System.out.println("Students enrolled:");
        for (String student : students) {
            System.out.println(student);
        }
        System.out.println("There are " + getNumberOfStudents(students) + " students enrolled");
        System.out.println("The max number of students that can enroll in this course is  " + maxStudents);
    }


    public static int getNumberOfStudents(ArrayList<String> students) {
        return students.size();
    }

}

