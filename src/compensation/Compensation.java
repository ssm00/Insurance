package compensation;

import java.util.StringTokenizer;

public class Compensation {
	private String compensationMoney;
	private String condition;
	private String evaluation;
	String compensationId;

	public Compensation(String compensationDetail){
		StringTokenizer stringTokenizer = new StringTokenizer(compensationDetail);
    	this.compensationId = stringTokenizer.nextToken();
    	this.compensationMoney = stringTokenizer.nextToken();
    	this.condition = stringTokenizer.nextToken();
    	this.evaluation = stringTokenizer.nextToken();
	}

	public boolean authorize(String condition){
		if (this.condition != null) {
			this.condition = condition;
			return true;
		}		
		else return false;
	}

	public boolean examine(String evaluation){
		if (this.evaluation != null) {
			this.evaluation = evaluation;
			return true;
		}		
		else return false;	}

	public boolean remit(String compensationMoney){
		if (this.compensationMoney != null) {
			this.compensationMoney = compensationMoney;
			return true;
		}		
		else return false;	}

	// public boolean terminate(){
	// 	if (this.condition != null) {
	// 		this.condition = condition;
	// 		return true;
	// 	}		
	// 	else return false;	}

}