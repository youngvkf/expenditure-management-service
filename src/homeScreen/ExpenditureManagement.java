package homeScreen;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;

public class ExpenditureManagement {
	int totalProperty = 258457;
	int totalExpenditure = 257948;
	int accountProperty = 257948;
	
	ArrayList <Expenditure> expenditureList;
	
	public ExpenditureManagement() {
		
		expenditureList = new ArrayList <Expenditure>();
		
		expenditureList.add(new Expenditure("외식", "식비", 20000, LocalDate.parse("2025-06-05")));
		expenditureList.add(new Expenditure("월세", "커피, 간식", 500000, LocalDate.parse("2025-06-15")));
		expenditureList.add(new Expenditure("공과금", "쇼핑", 20000, LocalDate.parse("2025-06-10")));
		expenditureList.add(new Expenditure("책", "교육", 18000, LocalDate.parse("2025-06-02")));
		expenditureList.add(new Expenditure("배달음식", "이체", 20000, LocalDate.parse("2025-06-22")));
		expenditureList.add(new Expenditure("세제", "미용", 7000, LocalDate.parse("2025-06-12")));
	}
	
	public void showMonthlyExpenditure() {
		int monthlyExpenditure = getMonthlyExpenditure(LocalDate.now());
		int preMonthlyExpenditure = getMonthlyExpenditure(LocalDate.now().minusMonths(1));
		int difference = Math.abs(preMonthlyExpenditure - monthlyExpenditure);
		
		if (monthlyExpenditure > preMonthlyExpenditure) {
			System.out.println("지난 달 같은 기간보다 " + difference + "원 더 썼어요");
		}
		else
			System.out.println("지난 달 같은 기간보다 " + difference + "원 덜 썼어요");
	}
	
	public void showAccountExpenditure() {
		System.out.println("입출금 계좌");
		System.out.println(accountProperty + "원");
		System.out.println("토스뱅크 통장");
	}
	
	public void showExpenditureGraph() {
		for (Expenditure e : expenditureList) {
			if (e != null) {
				System.out.println(e.showInfo());
			}
		}
	}
	
	public void showTotalProperty() {
		
		System.out.println("순자산");
		System.out.println(totalProperty + "원");
		System.out.println("당신의 총 지출: " + totalExpenditure);
		
	}
	
	public void showExpenditureScreen(Scanner sc) {
		showMonthlyExpenditure();
		showTotalProperty();
		String yesOrNo;
		
		while(true) {
			System.out.println("지출이 있습니까? (y/n): ");
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
		showMonthlyExpenditure();
		showTotalProperty();
	}
	
	public void updateTotalExpenditure(int newExpenditure) {
		totalExpenditure += newExpenditure;
	}
	
	public void updateTotalProperty(int newExpenditure) {
		totalProperty -= newExpenditure;
	}
	
	public int getMonthlyExpenditure(LocalDate date) {
		int monthlyExpenditure = 0;
		
		for (Expenditure e : expenditureList) {
			if(e.getExpenditureDate().getMonthValue() == date.getMonthValue())
				monthlyExpenditure += e.getExpenditure();
		}
		
		return monthlyExpenditure;
	}

}
