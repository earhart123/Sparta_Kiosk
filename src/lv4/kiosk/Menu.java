package lv4.kiosk;

import java.util.List;

public class Menu {
    private String categoryName;
    private List<MenuItem> menuItemList;

    Menu(List<MenuItem> menuItemList, String categoryName){
        this.menuItemList = menuItemList;
        this.categoryName = categoryName;
    }

    // MenuItem 클래스를 List로 관리

    // List에 들어있는 MenuItem을 순차적으로 보여주는 함수
    // List를 리턴하는 함수

    // 구조에 맞게 함수를 선언해놓고 가져다 사용하세요.

    public void setCategoryName(String categoryName){
        this.categoryName = categoryName;
    }
    public void setMenuItemList(MenuItem menuItem){
        this.menuItemList.add(0, menuItem);
    }

    public String getCategoryName(){
        return categoryName;
    }
    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void printMenuItems(){
        for(int i=0; i<menuItemList.size(); i++){
            String name = menuItemList.get(i).getMenuItemName();
            double price = menuItemList.get(i).getMenuItemPrice();
            String description = menuItemList.get(i).getMenuItemDescription();

            System.out.print((i+1)+". ");
            System.out.printf("%-21s | W %.1f | %s%n", name, price, description);
        }
        System.out.println("0. 뒤로가기               | 종료");
        System.out.print("메뉴 선택: ");
    }

    public void addMenuItem(MenuItem menuItem){
    }
}
