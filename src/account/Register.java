package account;

import java.util.Scanner;

public class Register {
	String ID;
	String password;
	String email;
	String phoneNumber;
	String studentID;
	String bankAccount;
	public String major;
	public String nickname;
	public UserType userType;
	BankType bankType;
	
	public enum UserType {
		COLLEGE, GRADUATE
	}
	
	public enum BankType {
		NH("농협은행"), IBK("기업은행"), KB("국민은행"), MG("새마을금고"), SC("제일은행"), KAKAO("카카오뱅크");
		
		private final String displayName;
		
		BankType(String displayName){
			this.displayName = displayName;
		}
		
		public static String getDisplayName(BankType bankType) {
			return bankType.displayName;
		}
	}
	
	public String getID(Scanner sc) {
		System.out.print("아이디: ");
		ID = sc.nextLine();
		return ID;
	}
	
	public String getPassword(Scanner sc) {
		System.out.print("비밀번호: ");
		password = sc.nextLine();
		return password;
	}
	
	public void confirmPassword(Scanner sc) {
		String confirmPW;
		while(true) {
			System.out.print("비밀번호 확인: ");
			confirmPW = sc.nextLine();
			if (!password.equals(confirmPW)) {
				System.out.println("비밀번호가 일치하지 않습니다.\n");
			}
			else
				break;
		}
	}
	
	public String getEmail(Scanner sc) {
		System.out.print("이메일: ");
		email = sc.nextLine();
		return email;
	}
	
	public String getPhoneNumber(Scanner sc) {
		System.out.print("휴대폰 번호: ");
		phoneNumber = sc.nextLine();
		return phoneNumber;
	}
	
	public String getStudentID(Scanner sc) {
		System.out.print("학번: ");
		studentID = sc.nextLine();
		return studentID;
	}
	
	public UserType getUserType(Scanner sc) {
		System.out.print("대학생이면 0, 대학원생이면 1 입력: ");
		
		while(true) {
			int input = sc.nextInt();
			sc.nextLine();
			if (input == 0) {
				this.userType = UserType.COLLEGE;
				return userType;
			}
			else if (input == 1) {
				this.userType = UserType.GRADUATE;
				return userType;
			}
			else {
				System.out.println("잘못된 입력입니다.\n");
			}
		}
	}
	
	public String getMajor(Scanner sc) {
		System.out.print("전공: ");
		major = sc.nextLine();
		return major;
	}
	
	public String getNickname(Scanner sc) {
		System.out.print("닉네임: ");
		nickname = sc.nextLine();
		return nickname;
	}
	
	public String getBankAccount(Scanner sc) {
		System.out.println("계좌 입력");
		System.out.println("인증서 발급을 위해 보유하신 계좌로 1원 이체를 진행합니다");
		System.out.print("계좌번호: ");
		bankAccount = sc.nextLine();
		System.out.println("------------------------------------");
		return bankAccount;
	}
	
	public BankType getBankType(Scanner sc) {
		int option;
		
		System.out.println("은행 선택");
		System.out.println("1. 농협");
		System.out.println("2. 기업은행");
		System.out.println("3. kb국민");
		System.out.println("4. 새마을 금고");
		System.out.println("5. 제일은행");
		System.out.println("6. 카카오뱅크");
		System.out.print(">> ");
		option = sc.nextInt();
		sc.nextLine();
		
		switch(option) {
		case 1:
			bankType = BankType.NH;
			break;
		case 2:
			bankType = BankType.IBK;
			break;
		case 3:
			bankType = BankType.KB;
			break;
		case 4:
			bankType = BankType.MG;
			break;
		case 5:
			bankType = BankType.SC;
			break;
		case 6:
			bankType = BankType.KAKAO;
			break;
		}
		return bankType;
	}
	
	public void getRegister(Scanner sc) {
		System.out.println("회원가입을 시작합니다.");
		getID(sc);
		getPassword(sc);
		confirmPassword(sc);
		getEmail(sc);
		getPhoneNumber(sc);
		getUserType(sc);
		getMajor(sc);
		getNickname(sc);
		System.out.println("회원가입이 완료되었습니다.");
		System.out.println("==================================");
		
		getBankAccount(sc);
		getBankType(sc);
	}
}
