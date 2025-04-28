package lv4.kiosk;

import java.util.List;

public class Menu {
    private String categoryName;
    private List<MenuItem> menuItemList;

    // Menu 생성자
    Menu(List<MenuItem> menuItemList, String categoryName){
        this.menuItemList = menuItemList;
        this.categoryName = categoryName;
    }

    public String getCategoryName(){
        return categoryName;
    }
    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    // List에 들어있는 MenuItem을 순차적으로 보여주는 함수
    public void printMenuItems(){
        for(int i=0; i<menuItemList.size(); i++){
            String name = menuItemList.get(i).getItemName();
            double price = menuItemList.get(i).getItemPrice();
            String description = menuItemList.get(i).getItemDescription();

            System.out.print((i+1)+". ");
            System.out.printf("%-21s | W %.1f | %s%n", name, price, description);
        }
        System.out.println("0. 뒤로가기               | 종료");
        System.out.print("메뉴 선택: ");
    }
}
