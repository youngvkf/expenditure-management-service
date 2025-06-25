package 지출관리서비스;

import java.util.InputMismatchException;
import java.util.Scanner;

import account.Register;
import community.PostManagement;
import homeScreen.HomeScreen;

public class Main {

	public static void main(String[] args) {
		Register user = new Register();
		HomeScreen hs = new HomeScreen();
		PostManagement pManagement = new PostManagement();
		
		Scanner sc = new Scanner(System.in);
		
		pManagement.setUser(user); // 커뮤니티 서비스로 사용자 정보 보내기 -> 포스트에 사용자 정보(이름) 뜨게 하기
		
		user.getRegister(sc); // 회원가입 및 로그인하기
		
		int option = 0;
		boolean validInput = false;
		
		System.out.println("1. 홈 화면");
		System.out.println("2. 맞춤혜택서비스 화면");
		System.out.println("3. 커뮤니티 화면");
		System.out.println("4. 마이페이지 화면");
			
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
			}
		}
		System.out.println();
		
		switch(option) {
		case 1:
			hs.showHomeScreen(sc);  // 홈 화면
			break;
		case 2:
			// 맞춤혜택서비스 화면
			break;
		case 3:
			// 커뮤니티 화면
			break;
		case 4:
			// 마이페이지 화면
			break;
		}
		
		sc.close();
	}  /* 수정논의사항: 1. 홈화면 이동 후 다른 화면 이동 -> 홈스크린 코드 무거워짐 -> 리펙토링하면되긴 함
	 2. 홈화면과 다른 화면들 중 선택 -> 서비스 이용 후 뒤로가기 선택해야 해서 번거롭긴 함 */

}
