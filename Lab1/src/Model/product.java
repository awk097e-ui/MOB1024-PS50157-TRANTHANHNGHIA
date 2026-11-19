package Model;

public class product {
    private String id;
    private String name;
    private double basePrice;

    public product(String id, String name, double basePrice) {
        setId(id);
        setName(name);
        setBasePrice(basePrice);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID khong duoc rong");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        if (basePrice < 0) {
            throw new IllegalArgumentException("Gia khong duoc am");
        }
        this.basePrice = basePrice;
    }

    public double finalPrice() {
        return basePrice;
    }

    @Override
    public String toString() {
        return "ID: " + id
                + " | Ten: " + name
                + " | Gia goc: " + basePrice;
    }
}