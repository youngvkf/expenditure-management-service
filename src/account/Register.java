package account;

import java.util.Scanner;

public class Register {
	String ID;
	String password;
	String email;
	String phoneNumber;
	String studentID;
	public String major;
	public String nickname;
	public UserType userType;
	
	public enum UserType {
		COLLEGE, GRADUATE
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
	}
}
