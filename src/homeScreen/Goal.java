package homeScreen;

import java.time.LocalDate;

public class Goal {
	private int goalExpenditure;
	private int goalPeriod;
	LocalDate startDate;
	
	
	public Goal(int goalExpenditure, int goalPeriod, LocalDate startDate){
		this.goalExpenditure = goalExpenditure;
		this.goalPeriod = goalPeriod;
		this.startDate = startDate;
	}
	
	public int getGoalExpenditure() {
		return goalExpenditure;
	}
	
	public int getGoalPeriod() {
		return goalPeriod;
	}
	
	public LocalDate getStartDate() {
		return startDate;
	}
	
	public void setGoalExpenditure(int goalExpenditure) {
		this.goalExpenditure = goalExpenditure;
	}
	
	public void setGoalPeriod(int goalPeriod) {
		this.goalPeriod = goalPeriod;
	}
	
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	public String showInfo() {
		
		if (goalPeriod == 0)
			return startDate + "에 " + goalExpenditure + "이하로 쓰기.";
		else if (goalPeriod == 1)
			return startDate + "부터 일주일동안 " + goalExpenditure + "이하로 쓰기.";
		else if (goalPeriod == 2)
			return startDate + "부터 한 달 간 " + goalExpenditure + "이하로 쓰기.";
		return null;
	}
	
}
