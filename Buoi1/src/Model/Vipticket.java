
package Buoi1.src.Model;

public class Vipticket extends Ticket {
    private double surchargeRate;
    private double comboFee;

    public Vipticket(String id, String movie, double basePrice,
            double surchargeRate, double comboFee) {

        super(id, movie, basePrice);

        setSurchargeRate(surchargeRate);
        setComboFee(comboFee);
    }

    public double getSurchargeRate() {
        return surchargeRate;
    }

    public double getComboFee() {
        return comboFee;
    }

    public void setSurchargeRate(double surchargeRate) {
        if (surchargeRate < 0 || surchargeRate > 1) {
            throw new IllegalArgumentException(
                    "Phụ thu phải trong khoảng 0–1");
        }
        this.surchargeRate = surchargeRate;
    }

    public void setComboFee(double comboFee) {
        if (comboFee < 0) {
            throw new IllegalArgumentException(
                    "Phí combo phải >= 0");
        }
        this.comboFee = comboFee;
    }

    @Override
    public double finalPrice() {
        return getBasePrice()
                + getBasePrice() * surchargeRate
                + comboFee;
    }
}
