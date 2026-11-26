
package service;

import model.Student;
import model.StudentType;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;

public class StudentService {

        private List<Student> students = new ArrayList<>();

        public StudentService() {
                students.add(new Student("SV01", "Nghia", StudentType.REGULAR, 0));
                students.add(new Student("SV02", "An", StudentType.PART_TIME, 0));
                students.add(new Student("SV03", "Binh", StudentType.INTERNATIONAL, 0));
                students.add(new Student("SV04", "Cuong", StudentType.REGULAR, 0));
                students.add(new Student("SV05", "Dung", StudentType.PART_TIME, 0));
                students.add(new Student("SV06", "Hoa", StudentType.INTERNATIONAL, 0));
                students.add(new Student("SV07", "Minh", StudentType.REGULAR, 0));
                students.add(new Student("SV08", "Tuan", StudentType.INTERNATIONAL, 0));
                students.add(new Student("SV09", "Phuong", StudentType.PART_TIME, 0));
                students.add(new Student("SV10", "Khanh", StudentType.INTERNATIONAL, 0));
        }

        public void bai4() {

                System.out.println("\n========== BAI 4 ==========");

                System.out.println("Sinh vien INTERNATIONAL co GPA >= 3.2:");

                students.stream()
                                .filter(s -> s.getType() == StudentType.INTERNATIONAL)
                                .filter(s -> s.getGpa() >= 3.2)
                                .forEach(s -> System.out.println(s));

                System.out.println("\nTop 3 sinh vien co GPA cao nhat:");

                students.stream()
                                .sorted(Comparator.comparingDouble(
                                                Student::getGpa).reversed())
                                .limit(3)
                                .forEach(s -> System.out.println(s));

                System.out.println("\nTen sinh vien PART_TIME:");

                List<String> names = students.stream()
                                .filter(s -> s.getType() == StudentType.PART_TIME)
                                .map(Student::getName)
                                .collect(Collectors.toList());

                names.forEach(name -> System.out.println(name));
        }

        public void bai5() {

                System.out.println("\n========== BAI 5 ==========");

                Map<StudentType, Long> countByType = students.stream()
                                .collect(Collectors.groupingBy(
                                                Student::getType,
                                                Collectors.counting()));

                System.out.println("So luong sinh vien theo tung loai:");

                countByType.forEach((type, count) -> System.out.println(type + ": " + count));

                Map<StudentType, Double> averageGpaByType = students.stream()
                                .collect(Collectors.groupingBy(
                                                Student::getType,
                                                Collectors.averagingDouble(Student::getGpa)));

                System.out.println("\nGPA trung binh theo tung loai:");

                averageGpaByType.forEach((type, gpa) -> System.out.printf("%s: %.2f%n", type, gpa));

                Map.Entry<StudentType, Double> highestGpa = averageGpaByType.entrySet()
                                .stream()
                                .max(Map.Entry.comparingByValue())
                                .orElse(null);

                System.out.println("\nLoai sinh vien co GPA trung binh cao nhat:");

                if (highestGpa != null) {
                        System.out.printf("%s - GPA: %.2f%n",
                                        highestGpa.getKey(),
                                        highestGpa.getValue());
                }

                System.out.println("\nThong ke GPA chi tiet:");

                Map<StudentType, DoubleSummaryStatistics> statistics = students.stream()
                                .collect(Collectors.groupingBy(
                                                Student::getType,
                                                Collectors.summarizingDouble(Student::getGpa)));

                statistics.forEach((type, stats) -> {
                        System.out.println(type);
                        System.out.println("Tong GPA: " + stats.getSum());
                        System.out.println("GPA trung binh: " + stats.getAverage());
                        System.out.println("GPA cao nhat: " + stats.getMax());
                });
        }
}
