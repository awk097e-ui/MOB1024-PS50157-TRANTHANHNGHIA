package service;

import java.util.ArrayList;
import java.util.List;
import model.Employee;

public class EmployeeService {

    private List<Employee> employees = new ArrayList<>();

    public void add(Employee employee) {
        employees.add(employee);
        System.out.println("Them nhan vien thanh cong!");
    }

    public void display() {
        if (employees.isEmpty()) {
            System.out.println("Danh sach nhan vien trong!");
            return;
        }

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public Employee findById(String id) {
        for (Employee employee : employees) {
            if (employee.getId().equalsIgnoreCase(id)) {
                return employee;
            }
        }
        return null;
    }

    public void updateSalary(String id, double salary) {
        Employee employee = findById(id);

        if (employee != null) {
            employee.setSalary(salary);
            System.out.println("Cap nhat luong thanh cong!");
        } else {
            System.out.println("Khong tim thay nhan vien!");
        }
    }
}