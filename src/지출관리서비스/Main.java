package 지출관리서비스;

import java.util.Scanner;

import account.LogIn;
import account.LoginRegister;
import account.Register;
import community.PostManagement;
import homeScreen.HomeScreen;

public class Main {

	public static void main(String[] args) {
		LoginRegister loginRegister = new LoginRegister();
		PostManagement pManagement = new PostManagement();
		
		Scanner sc = new Scanner(System.in);
		
		while(!loginRegister.getUser().isLoginState()) {
			loginRegister.loginRegisterScreen();
		}  // 회원가입 및 로그인
		
		pManagement.setUser(loginRegister.getUser()); // 커뮤니티 서비스로 사용자 정보 보내기 -> 포스트에 사용자 정보(이름) 뜨게 하기
		
		HomeScreen hs = new HomeScreen(pManagement, loginRegister.getUser());
		hs.showHomeScreen(sc);  // 로그인 후 홈 화면으로
	}  /* 수정논의사항: 1. 홈화면 이동 후 다른 화면 이동 -> 홈스크린 코드 무거워짐 -> 리펙토링하면되긴 함
	 2. 홈화면과 다른 화면들 중 선택 -> 서비스 이용 후 뒤로가기 선택해야 해서 번거롭긴 함 */

}
