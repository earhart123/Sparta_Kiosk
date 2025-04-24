package project.kiosk;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menuList;

    public void addMenu(){
        menuList.get(0).setCategoryName("Burgers");
        MenuItem temp = new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");

        menuList.add(0, menuList.get(0));

        int size = menuList.size();
        //menuList.setCategoryName("Burgers");
        menuList.get(size).addMenuItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));

    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("[ SHAKESHACK MENU ]");
        System.out.println("[ SHAKESHACK MENU ]");
    }
}
