# Sparta_Kiosk
스파르타코딩 내일배움캠프 - 키오스크 프로젝트

## 프로젝트 소개
Java 문법을 사용하여 메뉴를 주문하는 키오스크를 구현합니다.

## 개발 환경
- `Java`
- `Oracle OpenJDK 17.0.5`

## 주요 기능
- 출력된 메뉴 중 입력받은 숫자에 따라 다른 로직을 실행
- 메뉴 선택, 메뉴 담기, 장바구니 메뉴 삭제, 장바구니 메뉴 주문 기능
- 특정번호 '0'을 입력하면 키오스크를 종료합니다.
--------------------
## 클래스 다이어그램
![image](https://github.com/user-attachments/assets/91121cb7-99f0-46ef-bf11-4044362e253a)

--------------------
#### 🛒최종 키오스크
> src/lv4.kiosk

메뉴를 선택하여 장바구니에 담아 주문할 수 있는 키오스크
- Main.java - 키오스크 메인 클래스
- Kiosk.java - 키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리하는 클래스
- Cart.java - 장바구니를 관리하는 클래스
- Menu.java - MenuItem의 상위 개념 클래스
- MenuItem.java - 개별 음식 메뉴 항목을 관리하는 클래스
- DiscountType - 사용자 유형별 할인율이 정의된 enum

**실행 흐름**
1. 메인 메뉴 리스트 출력
2. 사용자가 메인 메뉴에서 선택한 카테고리의 하위 메뉴 리스트 출력
3. 사용자가 메뉴 선택 후 장바구니에 저장
4. 장바구니에 저장된 메뉴 있을 시 메인 메뉴에 관련 메뉴 출력
5. 장바구니에 있는 메뉴 삭제
6. 장바구니에 있는 모든 메뉴 주문
7. 주문 시 할인 유형 선택 후 주문 가능
8. 메인 메뉴에서 '0' 입력 시 키오스크 종료

- 사용자에게 입력 받는 모든 경우에서 에러 처리
  - 유효하지 않은 번호 입력 시 재입력 가능

--------------------
#### 하위 버전 키오스크
**Lv1 키오스크**
- Main.java - 키오스크 메인 클래스

**Lv2 키오스크**
- Main.java - 키오스크 메인 클래스
- MenuItem.java - 개별 음식 메뉴 항목을 관리하는 클래스

**Lv3 키오스크**
- Main.java - 키오스크 메인 클래스
- Kiosk.java - 키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리하는 클래스
- MenuItem.java - 개별 음식 메뉴 항목을 관리하는 클래스

**Lv1 ~ Lv3 공통 기능**
1. 햄버거 메뉴 리스트 출력
2. 사용자가 선택할 메뉴 번호를 입력받음
3. 선택한 메뉴를 출력
4. '0' 입력 시 키오스크 종료

## 실행 화면

**메인 메뉴**

![image](https://github.com/user-attachments/assets/48521248-c70e-4d49-836c-7647c0acbd06) 

메인 메뉴 출력 및 사용자 입력

1~4 번호 입력 시 선택한 메뉴의 하위 메뉴 리스트 출력

![image](https://github.com/user-attachments/assets/2f2f674f-2bae-40d8-a524-c09a8cdf1ffb)

'0' 입력 후 키오스크 종료

**하위 메뉴**

![image](https://github.com/user-attachments/assets/a8dfd8e8-1e75-400c-a946-7788a692e648) 

하위 메뉴 리스트 출력 및 사용자 입력

![image](https://github.com/user-attachments/assets/3d043a2b-5d6e-4fbf-aa40-24c0fa04e23c)

하위 메뉴 선택 후 장바구니에 담기 여부 출력

![image](https://github.com/user-attachments/assets/be246310-f8df-407d-8074-d68dc861382b)

장바구니 담기 후 이전 화면으로 이동

![image](https://github.com/user-attachments/assets/15a87d2c-1005-49ab-b70c-689b628bd1ae)

0 입력 후 메인 메뉴로 이동

**장바구니 메뉴**

장바구니 삭제

![image](https://github.com/user-attachments/assets/3d83fb8e-7ab9-40b7-93e2-225ddb13a74f)

장바구니에 담긴 메뉴 있을 경우 장바구니 메뉴(5, 6) 출력

![image](https://github.com/user-attachments/assets/7753fd29-235e-4b9a-8594-0168754a893d)

장바구니 삭제 메뉴

![image](https://github.com/user-attachments/assets/7e277620-a562-4e72-8194-34fd9374771e)

장바구니에 담긴 메뉴 삭제 완료

![image](https://github.com/user-attachments/assets/b3ac9280-70f6-44d5-961a-0dc98cb7107c)

장바구니에 담긴 메뉴 전체 삭제 후 메인 메뉴로 이동


장바구니 주문

![image](https://github.com/user-attachments/assets/b0cb376d-80a5-47ab-89fb-c580deffeb63)

장바구니 주문 메뉴

![image](https://github.com/user-attachments/assets/45b3ce5a-0424-4cab-9bf0-b830aafaaa14)

주문 선택 후 할인 유형 선택

![image](https://github.com/user-attachments/assets/7d45cb6d-07f1-42e3-873f-dca95282b5ed)

선택한 할인 유형별 할인 금액 출력, 주문 완료 후 메인 메뉴로 이동

