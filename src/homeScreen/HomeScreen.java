package homeScreen;

import java.time.LocalDate;
import java.util.Scanner;

public class HomeScreen {
	
	ExpenditureManagement eManagement; // 지출관리서비스
	SubscriptionManagement sManagement; // 구독관리서비스
	GoalManagement gManagement;  // 목표관리서비스
	
	public HomeScreen() {
		eManagement = new ExpenditureManagement();
		sManagement = new SubscriptionManagement();
		gManagement = new GoalManagement();
	}
	
	public void showHomeScreen(Scanner sc) {		
		
		while(true) {
			
			System.out.println("1. 지출 관리");
			System.out.println("2. 구독 서비스 관리");
			System.out.println("3. 목표 관리");
			
			System.out.print("원하는 옵션 번호 입력 >> ");
			int option = sc.nextInt();
			sc.nextLine();
			System.out.println();
			
			switch (option) {
			case 1: 
				eManagement.showExpenditureScreen(sc);  // 지출관리서비스로 이동 (홈 화면 내)
				break;
			case 2:
				sManagement.showSubscriptionScreen(sc);  // 구독관리서비스로 이동 (홈 화면 내)
				break;
			case 3:
				gManagement.showGoalScreen(sc);  // 목표관리서비스로 이동 (홈 화면 내)
				break;
			} 
		}
		
	}
	
}
