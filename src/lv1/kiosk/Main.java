package lv1.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<String> menuList = new ArrayList<String>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        addMenuList();

        while(true){
            printMenuList();

            int receivedNumber = scanner.nextInt();
            if(!isNumber(receivedNumber)){
                System.out.println("유효하지 않은 숫자입니다. 다시 입력해주세요.");
                System.out.println("======================================");
                continue;
            }else if(receivedNumber==0){
                System.out.println("키오스크를 종료합니다.");
                break;
            }

            System.out.println("선택하신 아래 메뉴가 주문되었습니다.");
            System.out.println(menuList.get(receivedNumber-1));
            System.out.println("======================================");
        }
    }

    public static void addMenuList(){
        menuList.add("ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        menuList.add("SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        menuList.add("Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        menuList.add("Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
    }

    public static void printMenuList(){
        System.out.println("[ SHAKESHACK MENU ]");
        for(int i=0; i<menuList.size(); i++){
            System.out.println((i+1)+". "+menuList.get(i));
        }
        System.out.println("0. 종료                   | 종료");
    }

    public static boolean isNumber(int number){
        if(number>=0 && number<=4){
            return true;
        }else{
            return false;
        }
    }
}