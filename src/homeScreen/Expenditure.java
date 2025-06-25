package homeScreen;

import java.time.LocalDate;

public class Expenditure {
	private String expenditureName;
	private int expenditure;
	protected LocalDate expenditureDate;
	Category category;
	
	public enum Category{
		FOOD("외식"), SNACK("커피, 간식"), SHOPPING("쇼핑"), EDUCATION("교육"), 
			TRANSFER("이체"), BEAUTY("미용");
		
		private final String categoryName;
		
		Category(String categoryName){
			this.categoryName = categoryName;
		}
		
		public static String getDisplayName(Category category) {
			return category.categoryName;
		}
	}
	
	public Expenditure(String expenditureName, Category category, int expenditure, LocalDate date) {
		this.expenditureName = expenditureName;
		this.category = category;
		this.expenditure = expenditure;
		this.expenditureDate = date;
	}
	
	public String getExpenditureName() {
		return expenditureName;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public int getExpenditure() {
		return expenditure;
	}
	
	public LocalDate getExpenditureDate() {
		return expenditureDate;
	}
	
	public String showInfo() {
		return this.getExpenditureName() + " | " + this.getExpenditure() + " | " + this.getExpenditureDate();
	}
}
