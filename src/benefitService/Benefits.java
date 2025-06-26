package benefitService;

public class Benefits {
	String cardName;
	String benefitName;
	double cashback;
	
	public Benefits(String cardName, double cashback) {
		this.cardName = cardName;
		this.cashback = cashback;
	}
	
	public Benefits(String benefitName) {
		this.benefitName = benefitName;
	}
	
	public String getCardName() {
		return this.cardName;
	}
	
	public String getBenefitName() {
		return this.benefitName;
	}
	
	public double getCashback() {
		return this.cashback;
	}
	
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	
	public void setCashback(int cashback) {
		this.cashback = cashback;
	}
}
