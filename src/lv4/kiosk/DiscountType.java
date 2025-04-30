package lv4.kiosk;

public enum DiscountType {
//    NATIONAL_MERIT(0.3),
//    MILITARY(0.2),
//    STUDENT(0.1),
//    GENERAL(0);
    국가유공자(0.3),
    군인(0.2),
    학생(0.1),
    일반(0);

    private double rate;

    DiscountType(double rate) {
        this.rate = rate;
    }

    public double discountPrice(double price){
        return price * (1 - rate);
    }

    @Override
    public String toString() {
        return String.format("%-6s : %2.0f%%", this.name(), rate * 100);
    }
}
