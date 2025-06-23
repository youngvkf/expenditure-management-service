package homeScreen;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class GoalManagement {
	
	final int DAY_GOAL = 0;
	final int WEEK_GOAL = 1;
	final int MONTH_GOAL = 2;
	
	ArrayList <Goal> goalList;
	
	public GoalManagement() {
		goalList = new ArrayList<Goal>();
		
		goalList.add(new Goal(50000, DAY_GOAL, LocalDate.parse("2025-06-25")));
		goalList.add(new Goal(100000, WEEK_GOAL, LocalDate.parse("2025-06-25")));
		goalList.add(new Goal(500000, MONTH_GOAL, LocalDate.parse("2025-06-25")));
	}
	
	public void showGoalScreen(Scanner sc) {
		showGoalList();
		int option;
		
		System.out.println("================================");
		System.out.println("1. 목표 설정하기");
		System.out.println("2. 목표 수정하기");
		System.out.println("3. 목표 삭제하기");
		System.out.println("원하는 옵션 번호 입력 >> ");
		option = sc.nextInt();
		sc.nextLine();
		System.out.println("================================");
		
		switch(option) {
		case 1:
			addGoal(sc);
			break;
		case 2:
			editGoal(sc);
			break;
		case 3:
			deleteGoal(sc);
			break;
		}
	}
	
	public void showGoalList() {
		for (Goal g : goalList) {
			if (g != null)
				System.out.println((goalList.indexOf(g) + 1) + " | " + g.showInfo());
		}
	}
	
	public void addGoal(Scanner sc) {
		int goalPeriod;
		int goalExpenditure;
		LocalDate startDate;
		
		System.out.println("목표 기간을 정하세요.");
		System.out.println("1. 하루");
		System.out.println("2. 일주일");
		System.out.println("3. 한 달");
		System.out.print(">>");
		goalPeriod = sc.nextInt() - 1;
		sc.nextLine();
		System.out.println("--------------------------------");
		
		System.out.println("해당 기간 동안의 목표 지출액을 정하세요. >> ");
		goalExpenditure = sc.nextInt();
		sc.nextLine();
		
		System.out.println("시작 날짜를 정하세요. (yyyy-mm-dd) >> ");
		startDate = LocalDate.parse(sc.nextLine());
		
		goalList.add(new Goal(goalExpenditure, goalPeriod, startDate));
		showGoalList();
	}
	
	public void editGoal(Scanner sc) {
		int index;
		
		System.out.println("수정할 목표의 번호를 기입해주세요: ");
		index = sc.nextInt() - 1;
		sc.nextLine();
		
		while(true) {
			int option;
			
			System.out.println("1. 목표 지출 금액 수정");
			System.out.println("2. 목표 달성 기간 수정");
			System.out.println("3. 목표 달성 시작 날짜 수정");
			System.out.println("4. 수정 그만하기");
			System.out.println("수정할 부분을 선택하세요. >> ");
			option = sc.nextInt();
			sc.nextLine();
			
			switch(option) {
			case 1: 
				editGoalExpenditure(index, sc);
				break;
			case 2:
				editGoalPeriod(index, sc);
				break;
			case 3:
				editStartDate(index, sc);
				break;
			}
			if (option == 4) break;
		}
		showGoalList();
	}
	
	public void editGoalExpenditure(int index, Scanner sc) {
		int goalExpenditure;
		System.out.println("수정할 목표 지출 금액을 적어주세요: ");
		goalExpenditure = sc.nextInt();
		sc.nextLine();
		goalList.get(index).setGoalExpenditure(goalExpenditure);
	}
	
	public void editGoalPeriod(int index, Scanner sc) {
		int goalPeriod;
		System.out.println("수정할 목표 기간을 정하세요.");
		System.out.println("1. 하루");
		System.out.println("2. 일주일");
		System.out.println("3. 한 달");
		System.out.print(">>");
		goalPeriod = sc.nextInt();
		sc.nextLine();
		goalList.get(index).setGoalPeriod(goalPeriod - 1);
	}
	
	public void editStartDate(int index, Scanner sc) {
		LocalDate startDate;
		System.out.println("수정할 목표 지출 금액을 적어주세요(yyyy-mm-dd): ");
		startDate = LocalDate.parse(sc.nextLine());
		goalList.get(index).setStartDate(startDate);
	}
	
	public void deleteGoal(Scanner sc) {
		int index;
		
		System.out.println("삭제할 목표의 번호를 기입해주세요: ");
		index = sc.nextInt() - 1;
		sc.nextLine();
		goalList.remove(index);
		showGoalList();
	}
}
