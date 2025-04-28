package lv4.kiosk;

public class MenuItem {
    private String name;
    private double price;
    private String description;


    MenuItem(String name, double price, String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // getter
    public String getItemName(){
        return name;
    }
    public double getItemPrice(){
        return price;
    }
    public String getItemDescription(){
        return description;
    }

    public void printMenuItem(){
        System.out.printf("%s | W %.1f | %s%n", name, price, description);
    }
}
