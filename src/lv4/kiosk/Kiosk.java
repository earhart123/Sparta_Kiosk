package lv4.kiosk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menuList = new ArrayList<>();
    private List<MenuItem> menuItemList = new ArrayList<>();

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력

            // 숫자 입력 받기

            // 입력 받은 숫자가 올바르다면 인덱스로 활용하여 List에 접근하기
            // List<Menu>에 인덱스로 접근하면 Menu만 추출할 수 있겠죠?

            // Menu가 가진 List<MenuItem>을 반복문을 활용하여 햄버거 메뉴 출력

            // 숫자 입력 받기
            // 입력 받은 숫자가 올바르다면 인덱스로 활용해서 Menu가 가지고 있는 List<MenuItem>에 접근하기
            // menu.getMenuItems().get(i); 같은 형식으로 하나씩 들어가서 얻어와야 합니다.
        }
    }

    private void initMenu(){
        List<MenuItem> burgerItemList = new ArrayList<>();
        burgerItemList.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerItemList.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerItemList.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerItemList.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        menuList.add(new Menu(burgerItemList, "Burgers"));

        List<MenuItem> drinkItemList = new ArrayList<>();
        drinkItemList.add(new MenuItem("Strawberry Peach Tea", 5.0, "아이스티와 상큼한 딸기, 복숭아 맛을 더한 시즈널 레몬에이드"));
        drinkItemList.add(new MenuItem("Classic Shakes", 6.8, "쫀득하고 진한 커스터드가 들어간 클래식 쉐이크"));
        drinkItemList.add(new MenuItem("Fresh Brewed Iced Tea", 3.7, "직접 유기농 홍차를 우려낸 아이스 티"));
        drinkItemList.add(new MenuItem("Coca-cola", 2.9, "맛있고 상쾌한 코카콜라"));
        drinkItemList.add(new MenuItem("Shack Coffee", 4.0, "쉑 블렌드 원두를 사용한 밸런스 좋은 블랙 커피"));
        menuList.add(new Menu(drinkItemList, "Drinks"));

        List<MenuItem> FriedItemList = new ArrayList<>();
        FriedItemList.add(new MenuItem("Fries", 4.9, "바삭하고 담백한 프라이"));
        FriedItemList.add(new MenuItem("Cheese Fries", 6.0, "고소하고 진한 치즈 소스를 듬뿍 올린 프라이"));
        FriedItemList.add(new MenuItem("Cherry Pepper Fries", 7.2, "치즈 소스와 매콤한 체리페퍼를 듬뿍 올린 프라이"));
        menuList.add(new Menu(FriedItemList, "Fries"));

        List<MenuItem> DessertItemList = new ArrayList<>();
        DessertItemList.add(new MenuItem("Shack Attack", 6.2, "세 가지 초콜릿 토핑이 블렌딩된 쉐이크쉑의 대표 콘크리트"));
        DessertItemList.add(new MenuItem("Injeolmi Time", 6.2, "달콤한 솔티드 허니와 쫄깃한 인절미가 매력적인 콘크리트"));
        DessertItemList.add(new MenuItem("Honey Butter Crunch", 6.2, "바닐라 커스터드에 허니 버터 소스와 슈가 콘이 블렌딩된 콘크리트"));
        DessertItemList.add(new MenuItem("Shack in the Garden", 6.2, "바닐라 커스터드에 라즈베리 잼, 쇼트브레드와 말차가 블렌딩된 콘크리트"));
        menuList.add(new Menu(DessertItemList, "Desserts"));
    }

}
