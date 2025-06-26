package benefitService;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

import account.Register;

public class BenefitService {
	 	Register user;  // 사용자 정보
	    // PostManagement postManager;  // 커뮤니티에 추천 결과 업로드도 가능
	    ArrayList <Benefits> scholarship;  // 장학금
	    ArrayList <Benefits> foodBenefits;  // 식비 혜택
	    ArrayList <Benefits> transportBenefits;  // 교통비 혜택
	    ArrayList <Benefits> housingSubscription;  // 주택 청약
	    ArrayList <Benefits> etc;  // 기타
	    
	    Benefits[] transportRecommend;  // 교통비 혜택 서비스 추천 모음
	    Benefits[] foodRecommend;  // 식비 혜택 서비스 추천 모음
	    
	    int transportExpenditure = 123500;  // 이번 달 교통비
	    int foodExpenditure = 456750;  // 이번 달 식비
	    
	    ArrayList <Benefits> targetList;
	    
	    public BenefitService(Register user) {
	        this.user = user;
	        
	        scholarship = new ArrayList<>(Arrays.asList(new Benefits("정부지원금"), new Benefits("학교지원금")));
	        foodBenefits = new ArrayList<>(Arrays.asList(new Benefits("근거리 가격 비교 이벤트 진행")));
	        transportBenefits = new ArrayList<>(Arrays.asList(new Benefits("기후동행카드"), new Benefits("경기버스지원비")));
	        housingSubscription = new ArrayList<>(Arrays.asList(new Benefits("청년주택청약 정보")));
	        etc = new ArrayList<>();
	        
	        transportRecommend = new Benefits[4];
	        foodRecommend = new Benefits[3];
	        
	        transportRecommend[0] = new Benefits("기후동행카드", 10);
		    transportRecommend[1] = new Benefits("K-패스", 7);
		    transportRecommend[2] = new Benefits("삼성카드", 4);
		    transportRecommend[3] = new Benefits("신한카드", 2);
		    
		    foodRecommend[0] = new Benefits("현대카드", 22.5);
		    foodRecommend[1] = new Benefits("삼성카드", 21);
		    foodRecommend[2] = new Benefits("신한카드", 19);
	    }

	    public void showBenefitScreen(Scanner sc) {
	        while (true) {
	            System.out.println("맞춤 혜택 추천");
	            System.out.println("1. 내가 사용하는 혜택 서비스");
	            System.out.println("2. 또래에게 인기있는 혜택 서비스");
	            System.out.println("3. 청춘대로 톡톡카드 제안");
	            System.out.println("4. 혜택 카드 서비스 추천");
	            System.out.println("0. 뒤로가기");
	            System.out.print(">> ");
	            int choice = sc.nextInt();
	            sc.nextLine();
	            System.out.println("=============================================");

	            switch (choice) {
	                case 1:
	                	showMyBenefitServiceScreen(sc);  // 내가 사용하는 혜택 서비스 관리
	                    break;
	                case 2:
	                	showPopularService();
	                    break;
	                case 3:
	                    showCardDetail(sc);
	                    break;
	                case 4:
	                	showBenefitRecommend(sc);
	                	break;
	                case 0:
	                    return;
	                default:
	                    System.out.println("올바른 번호를 입력해주세요.");
	            }
	        }
	    }
	    // 내가 사용하는 혜택 서비스 관리
	    public void showMyBenefitServiceScreen(Scanner sc) {
	    	showYourBenefitLists(); // 혜택 리스트 보여주기
	    	System.out.println("=============================================");
	    	
	    	System.out.println("1. 내가 사용하는 혜택 추가하기");
	    	System.out.println("2. 내가 사용하는 혜택 삭제하기");
	    	System.out.println("0. 뒤로가기");
	    	
	    	System.out.print(">> ");
	    	int option = sc.nextInt();
	    	sc.nextLine();
	    	
	    	switch (option) {
	    	case 1:
	    		System.out.println("1.장학금 2.식비혜택 3.교통비혜택 4.주택청약 5.기타");
	    		System.out.print(">> ");
	    		int benefitOption = sc.nextInt();
	    		sc.nextLine();
	    		System.out.print("혜택이름: ");
	    		String benefitName = sc.nextLine();
	    		addBenefits(benefitOption, benefitName);
	    		break;
	    	case 2:
	    		System.out.println("1.장학금 2.식비혜택 3.교통비혜택 4.주택청약 5.기타");
	    		System.out.print(">> ");
	    		benefitOption = sc.nextInt();
	    		sc.nextLine();
	    		System.out.print("삭제할 혜택이름: ");
	    		benefitName = sc.nextLine();
	    		deleteBenefits(benefitOption, benefitName);
	    		break;
	    	case 0:
	    		return;
	    	default: 
	    		System.out.println("잘못된 입력입니다.");
	    		return;
	    	}
	    	System.out.println("=============================================");
	    }
	    // 혜택 목록 보여주기
	    public void showYourBenefitLists() {
	    	System.out.print("[장학금] ");
	    	showBenefitList(scholarship);
	    	System.out.print("[식비혜택] ");
	    	showBenefitList(foodBenefits);
	    	System.out.print("[교통비혜택] ");
	    	showBenefitList(transportBenefits);
	    	System.out.print("[주택청약] ");
	    	showBenefitList(housingSubscription);
	    	System.out.print("[기타] ");
	    	showBenefitList(etc);
	    }
	    // 각 혜택 종류에 해당하는 혜택들 보여주기
	    public void showBenefitList(ArrayList<Benefits> benefitList){
	    	int lastIndex = benefitList.size() - 1;
	    	for (Benefits b : benefitList) {
	    		System.out.print(b.getBenefitName());
	    		if (!b.equals(benefitList.get(lastIndex)))
	    			System.out.print(" | ");
	    	}
	    	System.out.println();
	    }
	    // 또래에게 인기있는 서비스 보여주기
	    public void showPopularService() {
	    	System.out.println(user.nickname + "님 또래에게 인기있는 혜택 서비스");
	    	System.out.println("---------------------------------------------");
	    	System.out.println("실시간 인기순위");
	    	System.out.println("1. 우리은행 WON 통장 청년형");
	    	System.out.println("2. 카카오뱅크 미니");
	    	System.out.println("3. 청년도약계좌");
	    	System.out.println("4. 청춘대로 톡톡카드");
	    	System.out.println("=============================================");
	    }
	    // 혜택 서비스 추천(교통비, 식비) 보여주기
	    public void showBenefitRecommend(Scanner sc) {
	    	System.out.println("1. 교통비 혜택 추천");
	    	System.out.println("2. 식비 혜택 추천");
	    	System.out.println("0. 뒤로 가기");
	    	System.out.print(">> ");
	    	
	    	int option = sc.nextInt();
	    	sc.nextLine();
	    	System.out.println("---------------------------------------------");
	    	
	    	switch(option) {
	    	case 1:
	    		showTransportBenefitRecommend();
	    		break;
	    	case 2:
	    		showFoodBenefitRecommend();
	    		break;
	    	case 0:
	    		return;
	    	default:
	    		System.out.println("잘못된 입력입니다.");
	    	}
	    }
	    // 교통비 서비스 추천
	    public void showTransportBenefitRecommend() {
	    	System.out.println("교통비 줄일 수 있는 서비스를 추천할게요!");
	    	System.out.println("당신의 이번 달 교통비는?");
	    	System.out.println(transportExpenditure + "원");
	    	System.out.println("---------------------------------------------");
	    	
	    	for (Benefits b : transportRecommend) {
	    		System.out.println(b.getCardName() + " 쓰고");
	    		System.out.println("최대 " + b.getCashback() + "만원 아껴쓰기");
	    	}
	    	System.out.println("=============================================");
	    }
	    // 식비 서비스 추천
	    public void showFoodBenefitRecommend() {
	    	System.out.println("식비를 줄일 수 있는 서비스를 추천할게요!");
	    	System.out.println("당신의 이번 달 식비는?");
	    	System.out.println(foodExpenditure + "원");
	    	System.out.println("---------------------------------------------");
	    	
	    	for (Benefits b : foodRecommend) {
	    		System.out.println(b.getCardName() + " 쓰고");
	    		System.out.println("최대 " + b.getCashback() + "만원 아껴쓰기");
	    	}
	    	System.out.println("=============================================");
	    }
	    // 혜택 추가
	    public void addBenefits(int benefitOption, String benefitName) {
	    	setTargetList(benefitOption);
	    	targetList.add(new Benefits(benefitName));
	    }
	    // 혜택 삭제
	    public void deleteBenefits(int benefitOption, String benefitName) {
	    	setTargetList(benefitOption);
	    	boolean removed = targetList.removeIf(b -> b.getBenefitName().equals(benefitName));
	    	
	    	if (removed)
	    		System.out.println("삭제 완료");
	    	else
	    		System.out.println("해당하는 혜택이 없습니다.");
	    }
	    
	    public void setTargetList(int option){
	    	switch(option) {
	    	case 1: 
	    		targetList = scholarship;
	    		break;
	    	case 2:
	    		targetList = foodBenefits;
	    		break;
	    	case 3:
	    		targetList = transportBenefits;
	    		break;
	    	case 4:
	    		targetList = housingSubscription;
	    		break;
	    	case 5:
	    		targetList = etc;
	    		break;
	    	default:
	    		System.out.println("잘못된 입력입니다.");
	    		return;
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
