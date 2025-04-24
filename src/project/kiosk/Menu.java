package project.kiosk;

import java.util.List;

public class Menu {
    private String categoryName;
    private List<MenuItem> menuItemList;

    Menu(String categoryName){
        this.categoryName = categoryName;
    }

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
        //MenuItem menuItemTemp = new MenuItem();

//        menuItemTemp.setMenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
//        menuItemList.add(menuItemTemp);
//
//        menuItemTemp.setMenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
//        menuItemList.add(menuItemTemp);
//
//        menuItemTemp.setMenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
//        menuItemList.add(menuItemTemp);
//
//        menuItemTemp.setMenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");
//        menuItemList.add(menuItemTemp);
    }
}
