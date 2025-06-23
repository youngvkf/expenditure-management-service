package homeScreen;

import java.util.Scanner;

import account.LogIn;
import community.PostManagement;

public class HomeScreen {
	
	ExpenditureManagement eManagement;
	SubscriptionManagement sManagement;
	GoalManagement gManagement;
	
	PostManagement pManagement;
	LogIn user;
	
	public HomeScreen(PostManagement pManagement, LogIn user) {
		eManagement = new ExpenditureManagement();
		sManagement = new SubscriptionManagement();
		gManagement = new GoalManagement();
		
		this.pManagement = pManagement;
		this.user = user;
	}
	
	public void showHomeScreen(Scanner sc) {		
		
		while(true) {
			System.out.println("홈 화면입니다.");
			System.out.println("1. 지출 관리");
			System.out.println("2. 구독 서비스 관리");
			System.out.println("3. 목표 관리");
			System.out.println("4. 맞춤 혜택 보기");
			System.out.println("5. 커뮤니티");
			System.out.println("6. 마이페이지");
			
			System.out.println("원하는 옵션 번호 입력 >> ");
			int option = sc.nextInt();
			sc.nextLine();
			
			switch (option) {
			case 1: 
				eManagement.showExpenditureScreen(sc);
				break;
			case 2:
				sManagement.showSubscriptionScreen(sc);
				break;
			case 3:
				gManagement.showGoalScreen(sc);
				break;
			case 5: 
				pManagement.showCommunityScreen(sc);
				break;
			}
		}
		
	}
}
