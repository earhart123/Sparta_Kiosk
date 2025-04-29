package lv4.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Kiosk {
    private List<Menu> menuList = new ArrayList<>();
    private List<MenuItem> menuItemList = new ArrayList<>();
    private int receivedNumber;
    private int receivedMenuNumber;
    private int chosenCart;
    private int chosenOrder;
    private int chosenNumber;
    private Cart cart = new Cart();

    public void start() {
        Scanner scanner = new Scanner(System.in);
        initMenu();

        while (true) {
            // List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
            printMenuList();

            // 숫자 입력 받기
             try {
                 receivedNumber = scanner.nextInt();
             } catch (InputMismatchException e) {
                 System.out.println("유효한 숫자를 입력해주세요.");
                 scanner.next();
                 continue;
             }

            // 유효하지 않은 숫자 입력되었을 경우
            if (!(receivedNumber >= 0 && receivedNumber <= menuList.size()+2)) {
                System.out.println("유효하지 않은 숫자입니다. 다시 입력해주세요.");
                System.out.println("======================================");
                continue;
            } else if (cart.isEmptyList() && (receivedNumber == 5 || receivedNumber == 6)){
                System.out.println("유효하지 않은 숫자입니다. 다시 입력해주세요.");
                System.out.println("======================================");
                continue;
            }

            if(receivedNumber == 0){
                System.out.println("키오스크를 종료합니다.");
                break;
            }else if(receivedNumber >=0 && receivedNumber <= menuList.size()){
                while(true) {

                    printMenuItemList(receivedNumber);
                    try {
                        receivedMenuNumber = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("유효한 숫자를 입력해주세요.");
                        scanner.next();
                        continue;
                    }

                    // 입력 받은 숫자가 올바르다면 인덱스로 활용하여 MenuItem 출력
                    Menu menu = menuList.get(receivedNumber - 1);
                    menuItemList = menu.getMenuItemList();
                    if (!(receivedMenuNumber >= 0 && receivedMenuNumber <= menuItemList.size())) {
                        System.out.println("유효하지 않은 숫자입니다. 다시 입력해주세요.");
                        System.out.println("======================================");
                        continue;
                    } else if (receivedMenuNumber == 0) {
                        System.out.println("카테고리 선택 화면으로 돌아갑니다.");
                        break;
                    }

                    while(true) {
                        System.out.print("선택한 메뉴: ");
                        MenuItem menuItem = menuItemList.get(receivedMenuNumber - 1);
                        menuItem.printMenuItem();

                        System.out.println("> 위 메뉴를 장바구니에 추가하시겠습니까?");
                        System.out.println("1. 확인      2. 취소");
                        try {
                            chosenCart = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("유효한 숫자를 입력해주세요.");
                            scanner.next();
                            continue;
                        }
                        if (chosenCart == 1) {
                            System.out.printf("%s 장바구니에 추가되었습니다.\n", menuItem.getItemName());
                            // 장바구니에 추가하는 코드
                            cart.addCart(menuItem);
                            break;
                        } else if (chosenCart == 2) {
                            System.out.println("해당 메뉴 선택이 취소되었습니다. 이전 화면으로 돌아갑니다.");
                            break;
                        } else {
                            System.out.println("유효하지 않은 숫자입니다. 다시 입력해주세요.");
                        }
                    }
                    System.out.println("======================================");
                }
            }else if(receivedNumber == 5) {
                while(true) {
                    printCartList();
                    try {
                        chosenOrder = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("유효한 숫자를 입력해주세요.");
                        scanner.next();
                        continue;
                    }
                    if (chosenOrder == 1) {
                        // 주문 완료 및 장바구니 초기화
                        System.out.printf("주문이 완료되었습니다. 금액은 W %.1f 입니다.\n", cart.getTotal());
                        cart.clearCart();
                        break;
                    } else if (chosenOrder == 2) {
                        System.out.println("이전 화면으로 돌아갑니다.");
                        break;
                    } else {
                        System.out.println("유효하지 않은 숫자입니다. 다시 입력해주세요.");
                        continue;
                    }
                }
            }else if(receivedNumber == 6){
                while(true) {
                    // 장바구니 목록 출력
                    System.out.println("[ Cart ]");
                    // 장바구니 리스트에 담긴 아이템 출력
                    for (MenuItem list : cart.getCartList()) {
                        int i = 0;
                        System.out.printf("%s. %-21s | W %.1f | %s%n\n", i+1, list.getItemName(), list.getItemPrice(), list.getItemDescription());
                    }
                    System.out.println("0. 이전 화면으로");
                    // 삭제 또는 모두 삭제
                    System.out.println("삭제할 메뉴를 선택하세요.");
                    try {
                        chosenNumber = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("유효한 숫자를 입력해주세요.");
                        scanner.next();
                        continue;
                    }
                    // 입력받은 번호가 메뉴 숫자보다 많을 경우 재입력 받기
                    if(chosenNumber >0 && chosenNumber <= cart.getCartList().size()){
                        System.out.printf("%s. %s 가 장바구니에서 삭제되었습니다.\n", chosenNumber, cart.getCartList().get(chosenNumber-1).getItemName());
                        cart.removeCart(chosenNumber-1);

                        if(cart.isEmptyList()) break;
                        continue;
                    }else if(chosenNumber == 0){
                        break;
                    }
                    else if(chosenNumber == cart.getCartList().size()+1){ // 카트 리셋
                        cart.clearCart();
                        System.out.println("담긴 메뉴가 모두 삭제되었습니다.");
                        break;
                    }
                    else{
                        System.out.println("유효하지 않은 숫자입니다. 다시 입력해주세요.");
                        System.out.println("======================================");
                        continue;
                    }
                }

            }
        }
    }

    private void printMenuList(){
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menuList.size(); i++) {
            Menu m = menuList.get(i);
            System.out.println((i + 1) + ". " + m.getCategoryName());
        }

        // 장바구니에 물건이 있다면 주문하기 메뉴를 출력
        if(!cart.isEmptyList()){
            System.out.println("[ ORDER MENU ]");
            System.out.println("5. Orders       | 장바구니를 확인 후 주문합니다.");
            System.out.println("6. Cancel       | 진행중인 주문을 취소합니다.");
        }
        System.out.println("0. 종료       | 종료");
    }

    private void printMenuItemList(int chosenNumber){
        Menu menu = menuList.get(chosenNumber-1);
        System.out.println("[ " + menu.getCategoryName() + " MENU ]");
        menu.printMenuItems();

    }

    private void printCartList(){
        System.out.println("아래와 같이 주문하시겠습니까?\n");
        System.out.println("[ Orders ]");
        // 장바구니 리스트에 담긴 아이템 출력
        for(MenuItem list: cart.getCartList()){
            System.out.printf("%-21s | W %.1f | %s%n\n", list.getItemName(), list.getItemPrice(), list.getItemDescription());
        }
        System.out.println("[ Total ]");
        // 장바구니 아이템 합계금액 출력
        System.out.printf("W %.1f\n", cart.getTotal());
        System.out.println("1. 주문      2. 메뉴판으로");
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
