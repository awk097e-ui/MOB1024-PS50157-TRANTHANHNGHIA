package Model;

public class ImportedProduct extends product {
    private double importTaxRate;
    private double shippingFee;

    public ImportedProduct(String id, String name, double basePrice,
            double importTaxRate, double shippingFee) {

        super(id, name, basePrice);
        setImportTaxRate(importTaxRate);
        setShippingFee(shippingFee);
    }

    public double getImportTaxRate() {
        return importTaxRate;
    }

    public void setImportTaxRate(double importTaxRate) {
        if (importTaxRate < 0 || importTaxRate > 1) {
            throw new IllegalArgumentException("Thue phai tu 0 den 1");
        }
        this.importTaxRate = importTaxRate;
    }

    public double getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(double shippingFee) {
        if (shippingFee < 0) {
            throw new IllegalArgumentException("Phi van chuyen khong duoc am");
        }
        this.shippingFee = shippingFee;
    }

    @Override
    public double finalPrice() {
        return getBasePrice()
                + getBasePrice() * importTaxRate
                + shippingFee;
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Thue nhap khau: " + importTaxRate
                + " | Phi van chuyen: " + shippingFee;
    }
}