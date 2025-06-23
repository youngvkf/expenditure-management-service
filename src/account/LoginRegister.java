package account;

import java.util.Scanner;

public class LoginRegister {
	LogIn user;
	
	public LoginRegister() {
		user = new LogIn();
	}

	public void loginRegisterScreen() {
		Scanner sc = new Scanner(System.in);
		System.out.println("서비스 사용을 위해 로그인이 필요해요");
		System.out.println();
		
		while(true) {
			int option;
			System.out.println("1. 로그인");
			System.out.println("2. 아이디 찾기");
			System.out.println("3. 비밀번호 찾기");
			System.out.println("4. 회원가입\n");
			
			System.out.print("원하는 메뉴 번호를 선택하세요: ");
			option = sc.nextInt();
			sc.nextLine();
			System.out.println("=======================");
			
			switch(option) {
			case 1:
				user.getLogin(sc);
				return;
			case 2:
				user.findID(sc);
				break;
			case 3:
				user.findPW(sc);
				break;
			case 4:
				user.registration(sc);
				break;
			default:
				System.out.println("잘못된 입력입니다. 다시 시도하세요.");
			}
			System.out.println();
		}
	}
	
	public LogIn getUser() {
		return this.user;
	}

}
