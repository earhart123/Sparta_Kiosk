package lv4.kiosk;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    // 속성
    private double total=0;
    private List<MenuItem> cartList = new ArrayList<>();

    // 생성자

    // 기능
    public List<MenuItem> getCartList(){
        return this.cartList;
    }

    public double getTotal(){
        return this.total;
    }

    public void addCart(MenuItem menuItem){
        cartList.add(menuItem);
        total += menuItem.getItemPrice();
    }

    public void clearCart(){
        cartList.clear();
    }

    public boolean isEmptyList(){
        return cartList.isEmpty();
    }

    public void removeCart(int index){
        total -= cartList.get(index).getItemPrice();
        cartList.remove(index);
    }
}
