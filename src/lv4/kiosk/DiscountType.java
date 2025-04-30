package lv4.kiosk;

public enum DiscountType {
    NATIONAL_MERIT(0.3),
    MILITARY(0.2),
    STUDENT(0.1),
    GENERAL(0);

    private double rate;

    private double discountPrice(double price){
        return price * (1 - rate);
    }
}
