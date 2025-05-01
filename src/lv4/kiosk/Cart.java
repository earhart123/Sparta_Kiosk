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
        total = 0;
    }

    public boolean isEmptyList(){
        return cartList.isEmpty();
    }

    public void removeCart(int index){
        total -= cartList.get(index).getItemPrice();
        cartList.remove(index);
    }

    public void printCartList(){
        cartList.forEach(item -> item.printMenuItem("%-21s"));
    }
    public void printCartList(int index){
        for (MenuItem item : cartList) {
            System.out.printf("%s. %-21s | W %.1f | %s%n", (index++), item.getItemName(), item.getItemPrice(), item.getItemDescription());
        }
    }
}
