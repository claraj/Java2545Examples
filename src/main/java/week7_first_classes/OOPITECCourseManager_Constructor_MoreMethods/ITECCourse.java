package week7_first_classes.OOPITECCourseManager_Constructor_MoreMethods;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores data about an ITEC course.
 */

public class ITECCourse {

    //Data that an ITECCourse object needs to store
    String name;
    int code;
    List<String> students;
    int maxStudents;

    //Constructor
    ITECCourse(String courseName, int courseCode, int courseMaxStudents) {
        this.name = courseName;
        this.code = courseCode;
        this.students = new ArrayList<>();  //Set up the students list
        this.maxStudents = courseMaxStudents;
    }

    void addStudent(String studentName) {
        //No need to create ArrayList, the constructor has already done it
        students.add(studentName);
    }

    void removeStudent(String studentName) {
        if (students.contains(studentName)) {
            students.remove(studentName);
            System.out.println(studentName + " was un-enrolled from " + name);
        } else {
            System.out.println(studentName + " was not found in " + name);
        }
    }
    
    
    void writeCourseInfo() {
        System.out.println("Course Name: " + name);
        System.out.println("Course Code: " + code);
        System.out.println("Students enrolled:");
        for (String student : students) {
            System.out.println(student);
        }
        System.out.println("There are " + getNumberOfStudents() + " students enrolled");
        System.out.println("The max number of students for this course is  " + maxStudents);
    }

    int getNumberOfStudents() {
        return this.students.size();
    }

}


