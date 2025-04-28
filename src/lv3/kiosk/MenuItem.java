package lv3.kiosk;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {
    private String name;
    private double price;
    private String description;

    MenuItem(String name, double price, String description){
        this.name = name;
        this.price = price;
        this.description = description;

        List<String> list = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }
    public double getPrice(){
        return this.price;
    }
    public String getDescription(){
        return this.description;
    }
}
