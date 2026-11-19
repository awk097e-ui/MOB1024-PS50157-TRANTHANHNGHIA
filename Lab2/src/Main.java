import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import model.Student;
import model.StudentType;
import model.Product;
import model.ProductCategory;
import model.Employee;
import service.EmployeeService;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n========== LAB 2 ==========");
            System.out.println("1. Bai 1 - Quan ly sinh vien");
            System.out.println("2. Bai 2 - Quan ly san pham");
            System.out.println("3. Bai 3 - Quan ly nhan vien");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    bai1();
                    break;
                case 2:
                    bai2();
                    break;
                case 3:
                    bai3();
                    break;
                case 0:
                    System.out.println("Ket thuc chuong trinh!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (choice != 0);
    }

    // ================= BAI 1 =================

    public static void bai1() {

        List<Student> list = new ArrayList<>();

        list.add(new Student("SV01", "Nguyen Van An", StudentType.REGULAR));
        list.add(new Student("SV02", "Tran Van Binh", StudentType.REGULAR));
        list.add(new Student("SV03", "Le Thi Hoa", StudentType.PART_TIME));
        list.add(new Student("SV04", "Pham Van Nam", StudentType.PART_TIME));
        list.add(new Student("SV05", "John Smith", StudentType.INTERNATIONAL));
        list.add(new Student("SV06", "David Lee", StudentType.INTERNATIONAL));

        System.out.println("\n===== DANH SACH SINH VIEN =====");

        for (Student student : list) {
            System.out.println(student);
        }

        System.out.println("\n===== SINH VIEN THEO TUNG LOAI =====");

        for (StudentType type : StudentType.values()) {

            System.out.println("\nLoai: " + type);

            for (Student student : list) {
                if (student.getType() == type) {
                    System.out.println(student);
                }
            }
        }

        System.out.println("\n===== THONG KE SO LUONG =====");

        for (StudentType type : StudentType.values()) {

            int count = 0;

            for (Student student : list) {
                if (student.getType() == type) {
                    count++;
                }
            }

            System.out.println(type + ": " + count + " sinh vien");
        }
    }

    // ================= BAI 2 =================

    public static void bai2() {

        List<Product> list = new ArrayList<>();

        list.add(new Product("SP01", "Gao", 20000, ProductCategory.FOOD));
        list.add(new Product("SP02", "Sua", 15000, ProductCategory.FOOD));
        list.add(new Product("SP03", "Banh", 10000, ProductCategory.FOOD));

        list.add(new Product("SP04", "Laptop", 15000000, ProductCategory.ELECTRONIC));
        list.add(new Product("SP05", "Dien thoai", 8000000, ProductCategory.ELECTRONIC));
        list.add(new Product("SP06", "Tai nghe", 500000, ProductCategory.ELECTRONIC));

        list.add(new Product("SP07", "Ao thun", 150000, ProductCategory.CLOTHING));
        list.add(new Product("SP08", "Quan jean", 300000, ProductCategory.CLOTHING));

        System.out.println("\n===== DANH SACH SAN PHAM =====");

        for (Product product : list) {
            System.out.println(product);
        }

        Map<ProductCategory, Integer> quantityMap = new HashMap<>();
        Map<ProductCategory, Double> totalMap = new HashMap<>();

        for (ProductCategory category : ProductCategory.values()) {
            quantityMap.put(category, 0);
            totalMap.put(category, 0.0);
        }

        for (Product product : list) {

            ProductCategory category = product.getCategory();

            quantityMap.put(category, quantityMap.get(category) + 1);

            totalMap.put(category, totalMap.get(category) + product.getPrice());
        }

        System.out.println("\n===== THONG KE SO LUONG SAN PHAM =====");

        for (Map.Entry<ProductCategory, Integer> entry : quantityMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " san pham");
        }

        System.out.println("\n===== TONG GIA TRI SAN PHAM =====");

        for (Map.Entry<ProductCategory, Double> entry : totalMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " VND");
        }
    }

    // ================= BAI 3 =================

    public static void bai3() {

        EmployeeService service = new EmployeeService();

        service.add(new Employee("NV01", "Nguyen Van An", 10000000));
        service.add(new Employee("NV02", "Tran Van Binh", 12000000));
        service.add(new Employee("NV03", "Le Thi Hoa", 9000000));

        int choice;

        do {
            System.out.println("\n===== QUAN LY NHAN VIEN =====");
            System.out.println("1. Them nhan vien");
            System.out.println("2. Hien thi danh sach");
            System.out.println("3. Tim nhan vien theo ma");
            System.out.println("4. Cap nhat luong");
            System.out.println("0. Quay lai menu chinh");
            System.out.print("Chon chuc nang: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Nhap ma nhan vien: ");
                    String id = sc.nextLine();

                    System.out.print("Nhap ten nhan vien: ");
                    String name = sc.nextLine();

                    System.out.print("Nhap luong: ");
                    double salary = sc.nextDouble();
                    sc.nextLine();

                    service.add(new Employee(id, name, salary));
                    break;

                case 2:
                    System.out.println("\n===== DANH SACH NHAN VIEN =====");
                    service.display();
                    break;

                case 3:
                    System.out.print("Nhap ma nhan vien can tim: ");
                    String searchId = sc.nextLine();

                    Employee employee = service.findById(searchId);

                    if (employee != null) {
                        System.out.println("Tim thay nhan vien:");
                        System.out.println(employee);
                    } else {
                        System.out.println("Khong tim thay nhan vien!");
                    }
                    break;

                case 4:
                    System.out.print("Nhap ma nhan vien: ");
                    String updateId = sc.nextLine();

                    System.out.print("Nhap luong moi: ");
                    double newSalary = sc.nextDouble();
                    sc.nextLine();

                    service.updateSalary(updateId, newSalary);
                    break;

                case 0:
                    System.out.println("Quay lai menu chinh!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (choice != 0);
    }
}