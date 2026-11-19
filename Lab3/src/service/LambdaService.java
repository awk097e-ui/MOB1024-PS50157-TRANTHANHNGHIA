
package Lab3.src.service;

import java.util.ArrayList;
import java.util.Arrays;

public class LambdaService {

    public void bai1() {

        System.out.println("\n========== BAI 1 ==========");

        ArrayList<String> names = new ArrayList<>(Arrays.asList(
                "Nghia", "An", "Binh", "Thanh", "Hoang",
                "Minh", "Phuong", "Khanh", "Tuan", "Quang"));

        System.out.println("Danh sach ten:");
        names.forEach(name -> System.out.println(name));

        System.out.println("\nTen co do dai > 5:");
        names.stream()
                .filter(name -> name.length() > 5)
                .forEach(name -> System.out.println(name));

        System.out.println("\nSap xep ten A-Z:");
        names.stream()
                .sorted((a, b) -> a.compareTo(b))
                .forEach(name -> System.out.println(name));

        System.out.println("\nSap xep theo do dai tang dan:");
        names.stream()
                .sorted((a, b) -> Integer.compare(
                        a.length(), b.length()))
                .forEach(name -> System.out.println(name));
    }
}
