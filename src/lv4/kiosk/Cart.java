package lv4.kiosk;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    // 속성
    private String name;
    private double price;
    private int quantity;
    private List<Cart> cartList = new ArrayList<>();

    // 생성자
    public Cart(String name, double price){
        this.name = name;
        this.price = price;
    }

    // 기능
    public List<Cart> getCartList(){
        return this.cartList;
    }

}
