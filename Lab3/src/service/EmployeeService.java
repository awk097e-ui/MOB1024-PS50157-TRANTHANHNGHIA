
package service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import model.Employee;

public class EmployeeService {

        private List<Employee> employees = new ArrayList<>();

        public EmployeeService() {
                employees.add(new Employee(1, "An", 18000000));
                employees.add(new Employee(2, "Binh", 12000000));
                employees.add(new Employee(3, "Anh", 22000000));
                employees.add(new Employee(4, "Cuong", 15000000));
                employees.add(new Employee(5, "Dung", 13000000));
                employees.add(new Employee(6, "Hoa", 25000000));
                employees.add(new Employee(7, "A Minh", 17000000));
                employees.add(new Employee(8, "Tuan", 11000000));
        }

        public void bai2() {

                System.out.println("\n========== BAI 2 ==========");

                System.out.println("Nhan vien co luong >= 15 trieu:");

                employees.stream()
                                .filter(e -> e.getSalary() >= 15000000)
                                .forEach(e -> System.out.println(e));

                System.out.println("\nNhan vien sap xep theo luong giam dan:");

                employees.stream()
                                .sorted(Comparator.comparingDouble(
                                                Employee::getSalary).reversed())
                                .forEach(e -> System.out.println(e));

                System.out.println("\nDanh sach ten nhan vien:");

                List<String> names = employees.stream()
                                .map(Employee::getName)
                                .collect(Collectors.toList());

                names.forEach(name -> System.out.println(name));

                System.out.println("\nSo nhan vien co ten bat dau bang A:");

                long count = employees.stream()
                                .filter(e -> e.getName().toLowerCase().startsWith("a"))
                                .count();

                System.out.println(count);
        }

        public void bai3() {

                System.out.println("\n========== BAI 3 ==========");

                double totalSalary = employees.stream()
                                .mapToDouble(Employee::getSalary)
                                .sum();

                double averageSalary = employees.stream()
                                .mapToDouble(Employee::getSalary)
                                .average()
                                .orElse(0);

                Employee maxSalary = employees.stream()
                                .max(Comparator.comparingDouble(
                                                Employee::getSalary))
                                .orElse(null);

                System.out.printf("Tong luong: %,.0f VND%n", totalSalary);

                System.out.printf("Luong trung binh: %,.0f VND%n",
                                averageSalary);

                System.out.println("Nhan vien co luong cao nhat:");
                System.out.println(maxSalary);
        }
}
