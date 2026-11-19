package services;

import model.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class StudentService {
  List<Student> students = new ArrayList<>();
  Set<String> studentsIds = new HashSet<>();

  public Boolean addStudent(Student student) {
    String id = student.getId();
    if (studentsIds.contains(id)) {
      return false;
    } else {
      students.add(student);
      studentsIds.add(id);
      return true;
    }
  }

  public Student findStudentById(String id) {
    for (Student student : students) {
      if (student.getId().equals(id)) {
        return student;
      }
    }
    return null;
  }

  public Boolean removeStudent(String id) {
    Student student = findStudentById(id);
    if (student != null) {
      students.remove(student);
      studentsIds.remove(id);
      return true;
    }
    return null;
  }

  public void displayStudents() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'displayStudents'");
  }
}