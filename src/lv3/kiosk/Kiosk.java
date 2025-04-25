package lv3.kiosk;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<MenuItem> menuItemList = new ArrayList<>();
    private int receivedNumber;

    Kiosk(List<MenuItem> menuItemList){
        this.menuItemList = menuItemList;
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            printMenuItemList();
            try {
                receivedNumber = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("유효한 숫자를 입력해주세요.");
                scanner.next();
                continue;
            }

            if (!(receivedNumber >= 0 && receivedNumber <= 4)) {
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

    private void printMenuItemList(){
        System.out.println("[ SHAKESHACK MENU ]");
        for(int i=0; i<menuItemList.size(); i++){
            String name = menuItemList.get(i).getName();
            double price = menuItemList.get(i).getPrice();
            String description = menuItemList.get(i).getDescription();

            System.out.print((i+1)+". ");
            System.out.printf("%-15s | W %.1f | %s%n", name, price, description);
        }
        System.out.println("0. 종료             | 종료");
        System.out.print("메뉴 선택: ");
    }
}
