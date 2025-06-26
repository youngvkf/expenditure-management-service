package homeScreen;

import java.time.LocalDate;

public class Subscription {
	
	private String ottName;
	private int price;
	private int dayOfMonth;
	private int preMonth; 
	private LocalDate prePaymentDate;
	private LocalDate nextPaymentDate;
	
	public Subscription(String ottName, int price, int preMonth, int dayOfMonth) {
		this.ottName = ottName;
		this.price = price;
		this.dayOfMonth = dayOfMonth;
		this.preMonth = preMonth;
		
		this.prePaymentDate = LocalDate.of(2025,  preMonth, dayOfMonth);
		this.nextPaymentDate = prePaymentDate.plusMonths(1);
	}
	
	public String getOttName() {
		return ottName;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getPreMonth() {
		return preMonth;
	}
	
	public int getDayOfMonth() {
		return dayOfMonth;
	}
	
	public LocalDate getPrePaymentDate() {
		return prePaymentDate;
	}
	
	public LocalDate getNextPaymentDate() {
		return nextPaymentDate;
	}
	
	public String showInfo() {
		return ottName + " | 결제 금액: " + price + "원 | 결제예정일: " + nextPaymentDate.getMonth() + dayOfMonth;
	}
}
