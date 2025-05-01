package lv4.kiosk;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    // 속성
    private double total=0;
    private List<MenuItem> cartList = new ArrayList<>();

    // 생성자

    // 기능
    // getter
    public List<MenuItem> getCartList(){
        return this.cartList;
    }
    public double getTotal(){
        return this.total;
    }

    // 장바구니에 메뉴 아이템 추가 및 합계 계산
    public void addCart(MenuItem menuItem){
        cartList.add(menuItem);
        total += menuItem.getItemPrice();
    }

    // 장바구니 초기화
    public void clearCart(){
        cartList.clear();
        total = 0;
    }

    // 장바구니가 비어있는지 확인
    public boolean isEmptyList(){
        return cartList.isEmpty();
    }

    // 장바구니에 담긴 특정 아이템 제거
    public void removeCart(int index){
        total -= cartList.get(index).getItemPrice();
        cartList.remove(index);
    }

    // 장바구니에 담긴 아이템 리스트 출력
    public void printCartList(){
        cartList.forEach(item -> item.printMenuItem("%-21s"));
    }
    // 장바구니에 담긴 아이템 리스트와 인덱스 함께 출력
    public void printCartList(int index){
        for (MenuItem item : cartList) {
            System.out.printf("%s. %-21s | W %.1f | %s%n", (index++), item.getItemName(), item.getItemPrice(), item.getItemDescription());
        }
    }
}
