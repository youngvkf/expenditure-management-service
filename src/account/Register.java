package account;

import java.util.InputMismatchException;
import java.util.Scanner;
// 수정사항: 필요없는 사용자 정보, 메소드 없애기
public class Register {
	private String phoneNumber;  // 전화번호
	private String residentNumber;  // 주민번호
	private String bankAccount;  // 은행 계좌번호
	public String nickname;  // 사용자 이름
	public String schoolName; // 학교 이름
	public String address; // 거주지역
	private BankType bankType; // 은행
	// 은행
	public enum BankType {
		NH("농협은행"), IBK("기업은행"), KB("국민은행"), MG("새마을금고"), SC("제일은행"), KAKAO("카카오뱅크");
		
		private final String displayName;
		
		BankType(String displayName){
			this.displayName = displayName;
		}
		// 은행 이름 보여주기
		public static String getDisplayName(BankType bankType) {
			return bankType.displayName;
		}
	}
	// 휴대폰 번호 입력받기
	public String getPhoneNumber(Scanner sc) {
		System.out.println("휴대폰 번호");
		System.out.print("휴대폰 번호 입력: ");
		phoneNumber = sc.nextLine();
		System.out.println("======================================");
		return phoneNumber;
	}
	// 주민등록번호 입력받기
	public String getResidentNumber(Scanner sc) {
		System.out.println("주민등록번호 앞 7자리");
		System.out.println("생년월일 - 0******");
		System.out.print(">> ");
		residentNumber = sc.nextLine();
		System.out.println("------------------------------------");
		return residentNumber;
	}
	// 사용자 이름 입력받기
	public String getNickname(Scanner sc) {
		System.out.println("이름");
		System.out.print("이름 입력: ");
		nickname = sc.nextLine();
		System.out.println("------------------------------------");
		return nickname;
	}
	// 은행계좌 입력받기
	public String getBankAccount(Scanner sc) {
		System.out.print("계좌번호: ");
		bankAccount = sc.nextLine();
		System.out.println("------------------------------------");
		return bankAccount;
	}
	// 은행 입력받기
	public BankType getBankType(Scanner sc) {
		int option = 0;
		boolean validInput = false;
		
		System.out.println("은행 선택");
		System.out.println("1. 농협");
		System.out.println("2. 기업은행");
		System.out.println("3. kb국민");
		System.out.println("4. 새마을 금고");
		System.out.println("5. 제일은행");
		System.out.println("6. 카카오뱅크");
		// 유효한 범위의 은행 선택 -> 루프 해제
		while(!validInput) {
			try {
				System.out.print(">> ");
				option = sc.nextInt();
				sc.nextLine();
				
				if (option >= 1 && option <= 6) {
					validInput = true;
				}
				else
					System.out.println("잘못된 입력입니다.");
				
			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
			}
		}
		System.out.println("=======================================");
		
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
	// 학교 입력
	public String getSchoolName(Scanner sc) {
		System.out.print("학교: ");
		schoolName = sc.nextLine();
		System.out.println("------------------------------------");
		return schoolName;
	}
	// 거주지역 입력
	public String getAddress(Scanner sc) {
		System.out.print("거주지역: ");
		address = sc.nextLine();
		System.out.println("======================================");
		return address;
	}
	// 회원가입창
	public void getRegister(Scanner sc) {
		System.out.println("휴대폰 본인인증");
		System.out.println("회원여부 확인 및 가입을 진행합니다");
		System.out.println();
		
		getNickname(sc);
		getResidentNumber(sc);
		getPhoneNumber(sc);
		
		System.out.println("계좌 입력");
		System.out.println("인증서 발급을 위해 보유하신 계좌로 1원 이체를 진행합니다");
		
		getBankAccount(sc);
		getBankType(sc);
		
		System.out.println("추가정보");
		getSchoolName(sc);
		getAddress(sc);
	}
}
