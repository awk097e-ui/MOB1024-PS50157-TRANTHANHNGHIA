import model.Student;
import services.StudentService;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        studentService.addStudent(new Student("1001", "Nguyen Van A", 3.5));
        studentService.addStudent(new Student("1002", "Tran Thi B", 2.8));
        studentService.addStudent(new Student("1003", "Tran Van C", 3.7));
        System.out.println("Danh sach sinh vien:");
        studentService.displayStudents();
        Student student = studentService.findStudentById("1002");
        if (student != null) {
            System.out.println("Thong tin sinh vien co ID 1002:");
            System.out.println(student);
        }
    }
}
