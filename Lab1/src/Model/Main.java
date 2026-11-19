package Model;

public class Main {
    public static void main(String[] args) {

        product[] products = {
                new product("P01", "Laptop", 15000000),
                new product("P02", "Chuot", 200000),
                new product("P03", "Ban phim", 500000),
                new ImportedProduct("P04", "iPhone", 20000000, 0.1, 500000),
                new ImportedProduct("P05", "MacBook", 30000000, 0.15, 700000)
        };

        System.out.println("===== DANH SACH SAN PHAM =====");

        product maxProduct = products[0];

        for (product p : products) {
            System.out.println(p);
            System.out.println("Gia cuoi cung: " + p.finalPrice());
            System.out.println("----------------------------");

            if (p.finalPrice() > maxProduct.finalPrice()) {
                maxProduct = p;
            }
        }

        System.out.println("===== SAN PHAM CO GIA CAO NHAT =====");
        System.out.println(maxProduct);
        System.out.println("Gia cuoi cung: " + maxProduct.finalPrice());
    }
}