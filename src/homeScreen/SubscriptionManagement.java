package homeScreen;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class SubscriptionManagement {
	
	ArrayList <Subscription> subscriptionList;
	LocalDate currentDate;
	
	public SubscriptionManagement() {
		subscriptionList = new ArrayList <Subscription>();
		
		subscriptionList.add(new Subscription("넷플릭스", 13500, 6, 10));
		subscriptionList.add(new Subscription("유튜브 프리미엄", 14900, 6, 15));
		subscriptionList.add(new Subscription("챗GPT", 30000, 5, 27));
		subscriptionList.add(new Subscription("듀오링고", 14000, 5, 25));
		
		currentDate = LocalDate.now();
	}
	
	public void showSubscriptionScreen(Scanner sc) {
		showSubscriptionList();
		paymentReminder();
		int option;
		
		while(true) {
			System.out.println("1. 구독 서비스 추가");
			System.out.println("2. 구독 서비스 해지");
			
			System.out.println("원하는 옵션 번호 입력 >> ");
			option = sc.nextInt();
			sc.nextLine();
			
			if (option == 1) {
				registerSubscription(sc);
				break;
			}
			else if (option == 2) {
				deleteSubscription(sc);
				break;
			}
			else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
	
	public void paymentReminder() {
		currentDate = LocalDate.now();
		
		for (Subscription s : subscriptionList) {
			long dateDifference = ChronoUnit.DAYS.between(currentDate, s.getNextPaymentDate());
			
			if (dateDifference >= 0 && dateDifference <= 3) {
				System.out.println("**" + s.getOttName() + "의 예정 결제일이 " + dateDifference + "일 남았습니다. **");
			}
		}
	}
	
	public void showSubscriptionList() {
		System.out.println("------------- 현재 구독중인 서비스 ---------------");
		for (Subscription s : subscriptionList) {
			if (s != null) System.out.println(s.showInfo());
		}
		System.out.println("---------------------------------------------");
	}
	
	public void registerSubscription(Scanner sc) {
		System.out.println("새로운 구독 서비스를 추가합니다.");
		
		System.out.print("구독 서비스 이름: ");
		String newOttName = sc.nextLine();
		
		System.out.print("결제 금액: ");
		int newPrice = sc.nextInt();
		sc.nextLine();
		
		System.out.print("마지막 결제 날짜(4 25 << 이와 같은 형식으로 기입해주세요.): ");
		int newPreMonth = sc.nextInt();
		int newDayOfMonth = sc.nextInt();
		sc.nextLine();
		 
		subscriptionList.add(new Subscription(newOttName, newPrice, newPreMonth, newDayOfMonth));
		
		showSubscriptionList();
	}
	
	public void deleteSubscription(Scanner sc) {
		boolean found = false;
		
		
		System.out.println("삭제할 구독 서비스의 이름을 기입해주세요: ");
		String deleteOttName = sc.nextLine();
			
		for (int i = 0; i < subscriptionList.size(); i++) {
			if (subscriptionList.get(i).getOttName().equalsIgnoreCase(deleteOttName)) {
				subscriptionList.remove(i);
				found = true;
			}
		}
			
		if (found == true) {
			System.out.println("구독이 삭제되었습니다.");
		}
		else {
			System.out.println("해당하는 서비스가 없습니다.");
		}
		
		showSubscriptionList();
	}
}
