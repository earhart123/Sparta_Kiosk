package lv4.kiosk;

import java.util.List;
import java.util.stream.IntStream;

public class Menu {
    private String categoryName;
    private List<MenuItem> menuItemList;

    // Menu 생성자
    Menu(List<MenuItem> menuItemList, String categoryName) {
        this.menuItemList = menuItemList;
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    // List에 들어있는 MenuItem을 순차적으로 보여주는 함수
    public void printMenuItems() {
        IntStream.range(0, menuItemList.size())
                .forEach(i -> {
                    MenuItem menuItem = menuItemList.get(i);
                    System.out.print((i + 1) + ". ");
                    menuItem.printMenuItem("%-21s");
                });
    }
}