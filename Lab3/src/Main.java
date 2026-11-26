import service.LambdaService;
import service.EmployeeService;
import service.StudentService;

public class Main {

    public static void main(String[] args) {
        LambdaService lambdaService = new LambdaService();
        EmployeeService employeeService = new EmployeeService();
        StudentService studentService = new StudentService();

        lambdaService.bai1();

        employeeService.bai2();
        employeeService.bai3();

        studentService.bai4();
        studentService.bai5();
    }
}