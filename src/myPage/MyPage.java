package myPage;

import java.util.Scanner;

public class MyPage {
	public void showMyPage(Scanner sc) {
		int option;
		System.out.println("1. 내 정보 확인");
		System.out.println("2. 프로필 수정");
		
		while(true) {
			System.out.print(">> ");
			option = sc.nextInt();
			sc.nextLine();
			
			if (option != 1 || option != 2) {
				System.out.println("잘못된 입력입니다.");
			}
			else
				break;
		}
		System.out.println("=========================================");
	}
	// 내 정보 확인
	public void showMyInfo() {
		
	}
}
