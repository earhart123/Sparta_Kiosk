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

    public void addMenuItem(MenuItem menuItem){
    }

    public void printMenuItem(){


    }
}
