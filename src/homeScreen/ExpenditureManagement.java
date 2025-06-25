package homeScreen;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import homeScreen.Expenditure.Category;

public class ExpenditureManagement {
	int totalProperty = 258457;
	int totalExpenditure = 257948;
	int accountProperty = 257948;
	
	ArrayList <Expenditure> expenditureList;
	
	public ExpenditureManagement() {
		
		expenditureList = new ArrayList <Expenditure>();
		// 이번 달 지출
		expenditureList.add(new Expenditure("마라탕", Category.FOOD, 20000, LocalDate.parse("2025-06-05")));
		expenditureList.add(new Expenditure("커피", Category.SNACK, 5000, LocalDate.parse("2025-06-15")));
		expenditureList.add(new Expenditure("옷", Category.SHOPPING, 20000, LocalDate.parse("2025-06-10")));
		expenditureList.add(new Expenditure("책", Category.EDUCATION, 18000, LocalDate.parse("2025-06-02")));
		expenditureList.add(new Expenditure("월세", Category.TRANSFER, 500000, LocalDate.parse("2025-06-22")));
		expenditureList.add(new Expenditure("화장품", Category.BEAUTY, 12000, LocalDate.parse("2025-06-12")));
		// 저번 달 지출
		expenditureList.add(new Expenditure("외식", Category.FOOD, 30000, LocalDate.parse("2025-05-05")));
		expenditureList.add(new Expenditure("간식", Category.SNACK, 3000, LocalDate.parse("2025-05-15")));
		expenditureList.add(new Expenditure("옷", Category.SHOPPING, 20000, LocalDate.parse("2025-05-10")));
		expenditureList.add(new Expenditure("책", Category.EDUCATION, 18000, LocalDate.parse("2025-05-02")));
		expenditureList.add(new Expenditure("월세", Category.TRANSFER, 500000, LocalDate.parse("2025-05-22")));
		expenditureList.add(new Expenditure("머리 염색", Category.BEAUTY, 110000, LocalDate.parse("2025-05-12")));
	}
	// 지출 관리 서비스 보여주기
	public void showExpenditureScreen(Scanner sc) {
		showAccountExpenditure();
		showTotalProperty();
		showMonthlyExpenditure();
		String yesOrNo;
		
		while(true) {
			System.out.print("지출이 있습니까? (y/n): ");
			yesOrNo = sc.nextLine();
			
			if (yesOrNo.equalsIgnoreCase("Y")) {
				addExpenditure(sc);
				break;
			}
			else if (yesOrNo.equalsIgnoreCase("N")) break;
			else System.out.println("잘못된 입력입니다.");
		}
		
		while(true) {
			System.out.print("내 지출 그래프 미리보기 (y/n): ");
			yesOrNo = sc.nextLine();
			
			if (yesOrNo.equalsIgnoreCase("Y")) {
				showExpenditureGraph();
				break;
			}
			else if (yesOrNo.equalsIgnoreCase("N")) break;
			else System.out.println("잘못된 입력입니다.");
		}
		System.out.println("--------------------------------------------");
	}
	// 월별 지출 현황
	public void showMonthlyExpenditure() {
		
		int monthlyExpenditure = getMonthlyExpenditure(LocalDate.now());  // 이번 달 지출
		int preMonthlyExpenditure = getMonthlyExpenditure(LocalDate.now().minusMonths(1));  // 저번 달 지출
		int difference = Math.abs(preMonthlyExpenditure - monthlyExpenditure);  // 이번 달/저번 달 지출 차이
		
		System.out.println("이번 달 지출");
		System.out.println(monthlyExpenditure);
		
		if (monthlyExpenditure > preMonthlyExpenditure) {
			System.out.println("지난 달 같은 기간보다 " + difference + "원 더 썼어요");
		}
		else
			System.out.println("지난 달 같은 기간보다 " + difference + "원 덜 썼어요");
		System.out.println();
	}
	// 입출금 계좌
	public void showAccountExpenditure() {
		System.out.println("입출금 계좌");
		System.out.println(accountProperty + "원");
		System.out.println("토스뱅크 통장");
		System.out.println("--------------------------------------------");
	}
	// 카테고리별 지출 보여주기
	public void showExpenditureGraph() {
		Category[] categories = Category.values();
		for (Category c : categories) {
			showExpenditureForCategory(c);
		}
	}
	// 해당 카테고리의 지출 보여줌
	public void showExpenditureForCategory(Category category) {
		System.out.println("[ " + Category.getDisplayName(category) + " ]");
		
		for (Expenditure e : expenditureList) {
			// 이번 달 지출 내역만
			if (e.expenditureDate.getMonth().equals(LocalDate.now().getMonth())) {
				if (e.category.equals(category)) {
					System.out.println(e.showInfo());
				}
			}
		}
		System.out.println("--------------------------------------------");
	}
	// 순자산
	public void showTotalProperty() {
		System.out.println("순자산");
		System.out.println(totalProperty + "원");
		System.out.println("--------------------------------------------");
	}
	// 지출 기입하기
	public void addExpenditure(Scanner sc) {
		System.out.print("어디에 지출했나요? >> ");
		String newExpenditureName = sc.nextLine();
		System.out.println();

		Category category = selectCategory(sc);
		
		System.out.print("지출 금액: ");
		int expenditure = sc.nextInt();
		sc.nextLine();
		
		System.out.print("결제 날짜(YYYY-MM-DD): ");
		LocalDate expenditureDate = LocalDate.parse(sc.nextLine());
		 
		expenditureList.add(new Expenditure(newExpenditureName, category, expenditure, expenditureDate));
		System.out.println("--------------------------------------------");
	}
	// 지출의 카테고리 정하기
	public Category selectCategory(Scanner sc) {
		Category [] categories = Category.values();
		System.out.println("지출 카테고리");
		System.out.println("1. 식비");
		System.out.println("2. 커피, 간식");
		System.out.println("3. 쇼핑");
		System.out.println("4. 교육");
		System.out.println("5. 이체");
		System.out.println("6. 미용");
		System.out.print(">> ");
		int category = sc.nextInt();
		sc.nextLine();
		System.out.println();
		
		return categories[category - 1];
	}
	// 지출 생기면 순자산, 계좌 자산 바뀜
	public void updateProperty(int newExpenditure) {
		totalProperty -= newExpenditure;
		accountProperty -= newExpenditure;
	}
	// 월별 지출 리턴
	public int getMonthlyExpenditure(LocalDate date) {
		int monthlyExpenditure = 0;
		
		for (Expenditure e : expenditureList) {
			if(e.getExpenditureDate().getMonthValue() == date.getMonthValue())
				monthlyExpenditure += e.getExpenditure();
		}
		
		return monthlyExpenditure;
	}

}
