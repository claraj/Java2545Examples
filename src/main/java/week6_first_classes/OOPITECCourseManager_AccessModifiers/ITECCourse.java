package week6_first_classes.OOPITECCourseManager_AccessModifiers;

import java.util.ArrayList;

/**
 * Stores data about an ITEC course.
 *
 */
public class ITECCourse {

    //Data that an ITECCourse object needs to store
    //Variables should be private
    private String name;
    private int code;
    private ArrayList<String> students;
    private int maxStudents;

    //Constructor - public
    public ITECCourse(String courseName, int courseCode, int courseMaxStudents) {
        this.name = courseName;
        this.code = courseCode;
        this.students = new ArrayList<String>();  //Set up the students list
        this.maxStudents = courseMaxStudents;
    }

    //Methods that other classes should be able to access can be public or protected
    public void addStudent(String studentName) {
        //No need to create ArrayList, the constructor has already done it

        //Check to see if the course is full before adding new student
        if (students.size() == maxStudents) {
            System.out.println("Course is full – can't add " + studentName);
            System.out.println("The maximum number of students is " + maxStudents);

        } else {
            students.add(studentName);
        }
    }

    //Rest of code follows, check in GitHub....


    public void removeStudent(String studentName) {
        if (students.contains(studentName)) {
            students.remove(studentName);
            System.out.println(studentName + " was un-enrolled from " + this.name);
        } else {
            System.out.println(studentName + " was not found in " + this.name);
        }
    }


    //Rest of ITECCourse follows...


    public void writeCourseInfo() {
        System.out.println("Course Name: " + name);
        System.out.println("Course Code: " + code);
        System.out.println("Students enrolled:");
        for (String student : students) {
            System.out.println(student);
        }
        System.out.println("There are " + getNumberOfStudents() + " students enrolled");
        System.out.println("The max number of students for this course is  " + maxStudents);
    }

    public int getNumberOfStudents() {
        return this.students.size();
    }

}


