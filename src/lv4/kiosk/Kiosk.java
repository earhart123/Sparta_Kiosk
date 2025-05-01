package lv4.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Kiosk {
    private List<Menu> menuList = new ArrayList<>();
    private List<MenuItem> menuItemList = new ArrayList<>();
    private int mainNumber;
    private int menuNumber;
    private int chosenCart;
    private int chosenOrder;
    private int chosenRemove;
    private Cart cart = new Cart();
    private List<MenuItem> cartList = cart.getCartList();

    public void start() {
        Scanner scanner = new Scanner(System.in);
        // 키오스크 메뉴 생성
        initMenu();

        while (true) {
            // 메인 메뉴 출력
            printMainMenu();

            // 숫자 입력 받기
             try {
                 mainNumber = scanner.nextInt();
             } catch (InputMismatchException e) {
                 System.out.println("유효한 숫자를 입력해주세요.");
                 scanner.next();
                 continue;
             }

            // 입력 받은 숫자에 따라 메뉴 이동
            if (cart.isEmptyList() && (mainNumber == 5 || mainNumber == 6)){
                // 장바구니가 비어있을 때 장바구니 메뉴 접근 시도 시 에러 처리
                System.out.println("유효하지 않은 숫자입니다. 다시 입력해주세요.");
                System.out.println("======================================");
                // continue;
            }
            else if(mainNumber == 0){
                System.out.println("키오스크를 종료합니다.");
                break;
            }
            else if(mainNumber >=0 && mainNumber <= menuList.size()){
                // 카테고리 메뉴 있을 시 하위 메뉴 출력
                Menu selectedMenu = menuList.get(mainNumber -1);
                while(true) {
                    printMenuItemList(mainNumber);
                    try {
                        menuNumber = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("유효한 숫자를 입력해주세요.");
                        scanner.next();
                        continue;
                    }

                    // 입력 받은 메뉴 숫자가 올바르다면 인덱스로 활용하여 MenuItem 출력
                    menuItemList = selectedMenu.getMenuItemList();
                    if (!(menuNumber >= 0 && menuNumber <= menuItemList.size())) {
                        System.out.println("유효하지 않은 숫자입니다. 다시 입력해주세요.");
                        System.out.println("======================================");
                        continue;
                    } else if (menuNumber == 0) {
                        System.out.println("카테고리 선택 화면으로 돌아갑니다.");
                        break;
                    }

                    // 선택한 메뉴 장바구니에 추가 및 취소
                    while(true) {
                        System.out.print("선택한 메뉴: ");
                        MenuItem menuItem = menuItemList.get(menuNumber - 1);
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
            }
            else if(mainNumber == 5) {
                while(true) {
                    // 장바구니 주문 메뉴 출력
                    if(cart.isEmptyList()) break;
                    printOrderMenu();
                    try {
                        chosenOrder = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("유효한 숫자를 입력해주세요.");
                        scanner.next();
                        continue;
                    }
                    // 메뉴 주문
                    if (chosenOrder == 1) {
                        int input;
                        DiscountType[] discountTypes = DiscountType.values();
                        System.out.println("할인 정보를 입력해주세요.");
                        // 할인 유형 및 할인율 출력
                        for (int i = 0; i < discountTypes.length; i++) {
                            System.out.println((i + 1) + ". " + discountTypes[i]);
                        }
                        System.out.println("0. 뒤로가기");
                        // 입력받은 숫자 에러 처리
                        while(true) {
                            try {
                                input = scanner.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("유효한 숫자를 입력해주세요.");
                                scanner.next();
                                continue;
                            }
                            // 입력 받은 숫자가 유효할 경우 할인율 계산 및 주문 완료
                            if (input >= 1 && input <= discountTypes.length) {
                                DiscountType selectedType = discountTypes[input - 1];
                                System.out.printf("주문이 완료되었습니다. 금액은 W %.1f 입니다.\n", selectedType.discountPrice(cart.getTotal()));
                                cart.clearCart();
                                break;
                            } else if (input == 0) {
                                System.out.println("이전 화면으로 돌아갑니다.");
                                break;
                            } else {
                                System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
                                // continue;
                            }
                        }
                    } else if (chosenOrder == 2) { // 메뉴 주문 취소
                        System.out.println("이전 화면으로 돌아갑니다.");
                        break;
                    } else {
                        System.out.println("유효하지 않은 숫자입니다. 다시 입력해주세요.");
                        continue;
                    }
                }
            }
            else if(mainNumber == 6){
                while(true) {
                    // 장바구니 리스트에 담긴 아이템 출력
                    System.out.println("[ Cart ]");
                    cart.printCartList(1);
                    System.out.printf("%s. 전체 삭제\n", cartList.size()+1);
                    System.out.println("0. 이전 화면으로");

                    // 삭제 또는 모두 삭제
                    System.out.println("삭제할 메뉴를 선택하세요.");
                    try {
                        chosenRemove = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("유효한 숫자를 입력해주세요.");
                        scanner.next();
                        continue;
                    }
                    // 선택한 메뉴 삭제
                    if(chosenRemove >0 && chosenRemove <= cartList.size()){
                        System.out.printf("%s. %s 가 장바구니에서 삭제되었습니다.\n", chosenRemove, cartList.get(chosenRemove -1).getItemName());
                        cart.removeCart(chosenRemove -1);

                        // 메뉴 삭제 후 장바구니가 비었을 경우 메인 화면으로 이동
                        if(cart.isEmptyList()) break;
                    }
                    else if(chosenRemove == 0){ // 0 입력 시 이전 메뉴로 이동
                        break;
                    }
                    else if(chosenRemove == cartList.size()+1){ // 카트 리셋
                        cart.clearCart();
                        System.out.println("담긴 메뉴가 모두 삭제되었습니다.");
                        break;
                    }
                    else{
                        System.out.println("유효하지 않은 숫자입니다. 다시 입력해주세요.");
                        System.out.println("======================================");
                    }
                }
            }
            else {
                System.out.println("유효하지 않은 숫자입니다. 다시 입력해주세요.");
                System.out.println("======================================");
                // continue;
            }
        }
    }

    // 메인메뉴 리스트 출력
    private void printMainMenu(){
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

    // 카테고리별 메뉴 아이템 리스트 출력
    private void printMenuItemList(int chosenNumber){
        Menu menu = menuList.get(chosenNumber-1);
        System.out.println("[ " + menu.getCategoryName() + " MENU ]");
        menu.printMenuItems();
        System.out.println("0. 뒤로가기               | 메인화면으로");
        System.out.print("메뉴 선택: ");
    }

    // 장바구니 주문하는 메뉴 (5. Order) 출력
    private void printOrderMenu(){
        System.out.println("아래와 같이 주문하시겠습니까?\n");
        System.out.println("[ Orders ]");
        // 장바구니 리스트에 담긴 아이템 출력
        cart.printCartList();
        System.out.println("\n[ Total ]");
        // 장바구니 아이템 합계금액 출력
        System.out.printf("W %.1f\n", cart.getTotal());
        System.out.println("1. 주문      2. 메뉴판으로");
    }

    // 메뉴 추가
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
