package lv2.kiosk;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<MenuItem> menuItemList = createMenuItemList();

        while(true) {
            int receivedNumber;
            printMenuItemList(menuItemList);
            try {
                receivedNumber = inputNumber();
            } catch (InputMismatchException e) {
                System.out.println("유효한 숫자를 입력해주세요.");
                continue;
            }

            if (!isNumber(receivedNumber)) {
                System.out.println("유효하지 않은 숫자입니다. 다시 입력해주세요.");
                System.out.println("======================================");
                continue;
            } else if (receivedNumber == 0) {
                System.out.println("키오스크를 종료합니다.");
                break;
            }

            System.out.print("선택한 메뉴: ");
            MenuItem selectedMenu = menuItemList.get(receivedNumber - 1);
            System.out.printf("%1s | W %.1f | %s%n", selectedMenu.getName(), selectedMenu.getPrice(), selectedMenu.getDescription());
            System.out.println("======================================");

        }

    }

    public static List<MenuItem> createMenuItemList(){
        List<MenuItem> menuItemList = new ArrayList<>();

        menuItemList.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItemList.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItemList.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItemList.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        return menuItemList;
    }

    public static void printMenuItemList(List<MenuItem> menuItemList){
        System.out.println("[ SHAKESHACK MENU ]");
        for(int i=0; i<menuItemList.size(); i++){
            String name = menuItemList.get(i).getName();
            double price = menuItemList.get(i).getPrice();
            String description = menuItemList.get(i).getDescription();

            System.out.print((i+1)+". ");
            System.out.printf("%-15s | W %.1f | %s%n", name, price, description);
        }
        System.out.println("0. 종료             | 종료");
    }

    public static boolean isNumber(int number){
        return number >= 0 && number <= 4;
    }

    public static int inputNumber(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("메뉴 선택: ");

        return scanner.nextInt();
    }
}
