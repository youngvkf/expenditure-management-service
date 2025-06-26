package myPage;

import java.util.Scanner;
import account.Register;
import account.Register.UserType;

public class MyPage {
	 private Register user;

	 public MyPage(Register user) {
		 this.user = user;
		 
		 user.age = 0;
		 user.major = "";
		 user.userType = UserType.UNKNOWN;
	 }

	    public void showMyPage(Scanner sc) {
	        while (true) {
	            System.out.println("\n===== 마이페이지 =====");
	            System.out.println("1. 내 정보 보기");
	            System.out.println("2. 프로필 수정");
	            System.out.println("0. 홈으로 가기");
	            System.out.print("메뉴 선택 >> ");

	            String input = sc.nextLine();

	            switch (input) {
	                case "1":
	                    displayUserInfo();
	                    break;
	                case "2":
	                    editProfile(sc);
	                    break;
	                case "0":
	                    System.out.println("홈으로 돌아갑니다.");
	                    System.out.println("=====================================");
	                    return;
	                default:
	                    System.out.println("유효한 번호를 입력해주세요.\n");
	            }
	        }
	    }

	    private void displayUserInfo() {
	        System.out.println("\n[내 정보]");
	        System.out.println("이름: " + user.nickname);
	        System.out.println("나이: " + user.age);
	        System.out.println("학교: " + user.schoolName);
	        System.out.println("전공: " + user.major);
	        System.out.println("학생 유형: " + UserType.getDisplayName(user.userType));
	        System.out.println("거주 지역: " + user.address);
	    }

	    private void editProfile(Scanner sc) {
	        while (true) {
	            System.out.println("\n[프로필 수정]");
	            System.out.println("1. 이름(닉네임) 수정");
	            System.out.println("2. 나이 수정");
	            System.out.println("3. 학교 수정");
	            System.out.println("4. 전공 수정");
	            System.out.println("5. 학생 유형 변경");
	            System.out.println("6. 거주 지역 수정");
	            System.out.println("0. 수정 종료");
	            System.out.print("번호 선택 >> ");

	            String input = sc.nextLine();

	            switch (input) {
	                case "1":
	                    System.out.print("새 이름 입력: ");
	                    user.nickname = sc.nextLine();
	                    break;
	                case "2":
	                    System.out.print("나이 입력: ");
	                    try {
	                        user.age = Integer.parseInt(sc.nextLine());
	                    } catch (NumberFormatException e) {
	                        System.out.println("숫자를 입력해주세요.");
	                    }
	                    break;
	                case "3":
	                    System.out.print("학교명 입력: ");
	                    user.schoolName = sc.nextLine();
	                    break;
	                case "4":
	                    System.out.print("전공 입력: ");
	                    user.major = sc.nextLine();
	                    break;
	                case "5":
	                    System.out.print("0: 학부생, 1: 대학원생 >> ");
	                    String type = sc.nextLine();
	                    if (type.equals("0")) user.userType = Register.UserType.COLLEGE;
	                    else if (type.equals("1")) user.userType = Register.UserType.GRADUATE;
	                    else System.out.println("잘못된 입력입니다.");
	                    break;
	                case "6":
	                    System.out.print("거주 지역 입력: ");
	                    user.address = sc.nextLine();
	                    break;
	                case "0":
	                    System.out.println("수정을 종료합니다.");
	                    return;
	                default:
	                    System.out.println("유효한 입력이 아닙니다.");
	            }
	        }
	    }
}
