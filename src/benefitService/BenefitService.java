package benefitService;

import java.util.Scanner;
import java.util.List;

import account.Register;
import community.PostManagement;
import homeScreen.Expenditure;
import homeScreen.Subscription;;

public class BenefitService {
	 	Register user;  // 사용자 정보
	    List<Expenditure> expenditures;  // 지출 내역
	    List<Subscription> subscriptions;  // 구독 목록
	    PostManagement postManager;  // 커뮤니티에 추천 결과 업로드도 가능

	    public BenefitService(Register user, List<Expenditure> expenditures, List<Subscription> subscriptions, PostManagement pm) {
	        this.user = user;
	        this.expenditures = expenditures;
	        this.subscriptions = subscriptions;
	        this.postManager = pm;
	    }

	    public void showBenefitScreen(Scanner sc) {
	        while (true) {
	            System.out.println("\n맞춤 혜택 추천");
	            System.out.println("1. 교통비");
	            System.out.println("2. 식비");
	            System.out.println("3. 나이");
	            System.out.println("4. 청춘대로 톡톡카드 제안");
	            System.out.println("0. 뒤로가기");
	            System.out.print(">> ");
	            int choice = sc.nextInt();
	            sc.nextLine();

	            switch (choice) {
	                case 1:
	                    System.out.println("교통비 줄일 수 있는 서비스를 추천할게요!");
	                    break;
	                case 2:
	                    System.out.println("식비 줄일 수 있는 서비스를 추천할게요!");
	                    break;
	                case 3:
	                    System.out.println(user.nickname + "님 또래에게 인기있는 혜택 서비스");
	                    break;
	                case 4:
	                    showCardDetail(sc);
	                    break;
	                case 0:
	                    return;
	                default:
	                    System.out.println("올바른 번호를 입력해주세요.");
	            }
	        }
	    }

	    private void showCardDetail(Scanner sc) {
	        System.out.println("\n청춘대로 톡톡카드 혜택");
	        System.out.println("- 스타벅스 50% 할인");
	        System.out.println("- 연회비 0원");
	        System.out.println("- 전월실적 30만원 이상");
	        System.out.println();

	        System.out.println("1. 가입하기");
	        System.out.println("2. 자세히 보기");
	        System.out.println("3. 뒤로가기");
	        System.out.print(">> ");
	        int option = sc.nextInt();
	        sc.nextLine();

	        switch (option) {
	            case 1:
	                System.out.println("카드 가입 화면으로 연결");
	                break;
	            case 2:
	                System.out.println("혜택 상세 설명");
	                break;
	            case 3:
	                return;
	        }
	    }
}
