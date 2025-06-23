package homeScreen;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ExpenditureManagement {
	int totalProperty = 1000000;
	int totalExpenditure = 585000;
	int monthlyExpenditure;
	
	ArrayList <Expenditure> expenditureList;
	
	public ExpenditureManagement() {
		
		expenditureList = new ArrayList <Expenditure>();
		
		expenditureList.add(new Expenditure("외식", "식비", 20000, LocalDate.parse("2025-06-05")));
		expenditureList.add(new Expenditure("월세", "월세", 500000, LocalDate.parse("2025-06-15")));
		expenditureList.add(new Expenditure("공과금", "월세", 20000, LocalDate.parse("2025-06-10")));
		expenditureList.add(new Expenditure("책", "자기계발", 18000, LocalDate.parse("2025-06-02")));
		expenditureList.add(new Expenditure("배달음식", "식비", 20000, LocalDate.parse("2025-06-22")));
		expenditureList.add(new Expenditure("세제", "생필품", 7000, LocalDate.parse("2025-06-12")));
	}
	
	public void showFinanceRecord() {
		
		System.out.println("==========================================");
		System.out.println("월별 총 지출 현황: " + getMonthlyExpenditure());
		System.out.println("-----------------------------------------");
		
		System.out.println("당신의 총 자산: " + totalProperty);
		System.out.println("당신의 총 지출: " + totalExpenditure);
		
		for (Expenditure e : expenditureList) {
			if (e != null) {
				System.out.println(e.showInfo());
			}
		}
		
		System.out.println("==========================================");
	}
	
	public void showExpenditureScreen(Scanner sc) {
		showFinanceRecord();
		String yesOrNo;
		
		while(true) {
			System.out.println("가계부를 기입하겠습니까? (y/n): ");
			yesOrNo = sc.nextLine();
			
			if (yesOrNo.equalsIgnoreCase("Y")) {
				addExpenditure(sc);
				break;
			}
			else if (yesOrNo.equalsIgnoreCase("N")) break;
			else System.out.println("잘못된 입력입니다.");
		}
	}
	
	public void addExpenditure(Scanner sc) {
		System.out.print("어디에 지출했나요? >> ");
		String newExpenditureName = sc.nextLine();
		
		System.out.print("지출 카테고리: ");
		String category = sc.nextLine();
		
		System.out.print("지출 금액: ");
		int expenditure = sc.nextInt();
		sc.nextLine();
		
		System.out.print("마지막 결제 날짜(YYYY-MM-DD): ");
		LocalDate expenditureDate = LocalDate.parse(sc.nextLine());
		 
		expenditureList.add(new Expenditure(newExpenditureName, category, expenditure, expenditureDate));
		
		updateTotalExpenditure(expenditure);
		updateTotalProperty(expenditure);
		showFinanceRecord();
	}
	
	public void updateTotalExpenditure(int newExpenditure) {
		totalExpenditure += newExpenditure;
	}
	
	public void updateTotalProperty(int newExpenditure) {
		totalProperty -= newExpenditure;
	}
	
	public int getMonthlyExpenditure() {
		monthlyExpenditure = 0;
		LocalDate currentDate = LocalDate.now();
		
		for (Expenditure e : expenditureList) {
			if(e.getExpenditureDate().getMonthValue() == currentDate.getMonthValue())
				monthlyExpenditure += e.getExpenditure();
		}
		
		return monthlyExpenditure;
	}
}
