package homeScreen;

import java.time.LocalDate;

public class Expenditure {
	private String expenditureName;
	private String category;
	private int expenditure;
	private LocalDate expenditureDate;
	
	public Expenditure(String expenditureName, String category, int expenditure, LocalDate date) {
		this.expenditureName = expenditureName;
		this.category = category;
		this.expenditure = expenditure;
		this.expenditureDate = date;
	}
	
	public String getExpenditureName() {
		return expenditureName;
	}
	
	public String getCategory() {
		return category;
	}
	
	public int getExpenditure() {
		return expenditure;
	}
	
	public LocalDate getExpenditureDate() {
		return expenditureDate;
	}
	
	public String showInfo() {
		return expenditureName + " | 분류: " + category + " | 지출 금액: " + expenditure + " | 지출 날짜: " + expenditureDate;
	}
}
