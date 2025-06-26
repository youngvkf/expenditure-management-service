package 지출관리서비스;

import java.util.InputMismatchException;
import java.util.Scanner;

import account.Register;
import benefitService.BenefitService;
import community.PostManagement;
import homeScreen.HomeScreen;
import myPage.MyPage;

public class Main {

	public static void main(String[] args) {
		Register user = new Register();
		HomeScreen hs = new HomeScreen();
		PostManagement pm = new PostManagement();
		
		Scanner sc = new Scanner(System.in);
		
		pm.setUser(user); // 커뮤니티 서비스로 사용자 정보 보내기 -> 포스트에 사용자 정보(이름) 뜨게 하기
		
		System.out.println("===========================");
		System.out.println("UNIPLAN");
		System.out.println("===========================");
		user.getRegister(sc); // 회원가입 및 로그인하기
		BenefitService bs = new BenefitService(user);
		MyPage mp = new MyPage(user);
		
		while(true) {
			int option = 0;
			boolean validInput = false;
			
			System.out.println("1. 홈 화면");
			System.out.println("2. 맞춤혜택서비스 화면");
			System.out.println("3. 커뮤니티 화면");
			System.out.println("4. 마이페이지 화면");
			System.out.println("0. 종료");
				
			while(!validInput) {
				try{
					System.out.print("원하는 메뉴 번호 입력: ");
					option = sc.nextInt();
					sc.nextLine();
						
					if (option >= 1 && option <= 4)
						validInput = true;
					else
						System.out.println("잘못된 입력입니다");
				} catch (InputMismatchException e) {
					System.out.println("잘못된 입력입니다");
					sc.nextLine();
				}
			}
			System.out.println();
			
			
			switch(option) {
			case 1:
				hs.showHomeScreen(sc);  // 홈 화면
				break;
			case 2:
				bs.showBenefitScreen(sc);  // 맞춤혜택서비스 화면
				break;
			case 3:
				pm.showCommunityScreen(sc);  // 커뮤니티 화면
				break;
			case 4:
				mp.showMyPage(sc);  // 마이페이지 화면
				break;
			case 0:
				System.exit(0);
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
		}
	}  

}
