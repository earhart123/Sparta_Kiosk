package lv4.kiosk;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    // 속성
    private int quantity;
    private double total=0;
    private List<MenuItem> cartList = new ArrayList<>();

    // 생성자

    // 기능
    public List<MenuItem> getCartList(){
        return this.cartList;
    }

    public void addCart(MenuItem menuItem){
        cartList.add(menuItem);
        total += menuItem.getItemPrice();
    }

    public void removeCart(MenuItem menuItem){
        cartList.remove(menuItem);
        total -= menuItem.getItemPrice();
    }

    public boolean isEmptyList(){
        return cartList.isEmpty();
    }
}
