package project.kiosk;

public class MenuItem {
    private String name;
    private double price;
    private String description;


    MenuItem(String name, double price, String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // setter
    public void setMenuItem(String name, double price, String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }
    public void setMenuItemName(String name){
        this.name = name;
    }
    public void setMenuItemPrice(double price){
        this.price = price;
    }
    public void setMenuItemDescription(String description){
        this.description = description;
    }

    // getter
    public String getMenuItemName(){
        return name;
    }
    public double getMenuItemPrice(){
        return price;
    }
    public String getMenuItemDescription(){
        return description;
    }

}
