package account;

import java.util.Scanner;

public class LogIn extends Register{
	private boolean loginState = false;
	
	public void findID(Scanner sc) {
		String cEmail;
		System.out.println("아이디 찾기");
		System.out.println("이메일 주소로 인증하기");
		System.out.print("이메일 주소: ");
		cEmail = sc.nextLine();
		
		if (cEmail.equals(this.email) && this.email != null) {
			System.out.println("인증 완료");
			System.out.println("당신의 ID: " + this.ID);
		}
		else
			System.out.println("가입이 안된 이메일입니다.");
	}
	
	public void findPW(Scanner sc) {
		String cID;
		String cEmail;
		
		System.out.println("비밀번호 찾기");
		System.out.print("ID: ");
		cID = sc.nextLine();
		System.out.print("이메일 주소: ");
		cEmail = sc.nextLine();
		
		if (cID.equals(this.ID) && this.ID != null) {
			if (cEmail.equals(this.email) && this.email != null) {
				System.out.println("인증 완료");
				System.out.println("당신의 password: " + this.password);
			}
			else
				System.out.println("가입이 안된 이메일입니다.");
		}
		else
			System.out.println("가입이 안된 ID입니다.");
	}
	
	public void registration(Scanner sc) {
		if (!loginState) {
			System.out.println("아직 계정이 없으신가요? 회원가입");
			getRegister(sc);
		}
	}
	
	public void getLogin(Scanner sc) {
		String loginID;
		String loginPassword;
		
		if (!loginState) {
			System.out.println("로그인하기\n");
			System.out.print("아이디: ");
			loginID = sc.nextLine();
			System.out.print("패스워드: ");
			loginPassword = sc.nextLine();
			System.out.println();
			
			if (loginID.equals(this.ID) && this.ID != null) {
				if (loginPassword.equals(this.password) && this.password != null) {
					System.out.println("로그인이 완료되었습니다.\n");
					loginState = true;
				}
				else
					System.out.println("비밀번호가 정확하지 않습니다.\n");
			}
			else
				System.out.println("ID가 정확하지 않습니다.\n");
		}
	}
	
	public boolean isLoginState() {
		return loginState;
	}
}
