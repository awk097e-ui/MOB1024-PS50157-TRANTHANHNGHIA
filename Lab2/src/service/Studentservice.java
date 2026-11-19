
package service;

import java.util.List;
import java.util.ArrayList;
import model.Student;
import model.StudentType;

public class Studentservice {

    public static List<Student> createStudent() {

        List<Student> students = new ArrayList<>();

        students.add(new Student("S001", "John Doe", StudentType.REGULAR));
        students.add(new Student("S002", "Jane Smith", StudentType.PART_TIME));
        students.add(new Student("S003", "Alice Johnson", StudentType.REGULAR));

        return students;
    }

    public static void printStudents(List<Student> students) {

        for (Student student : students) {
            System.out.println(student);
        }
    }
}
