package compensation;
<<<<<<< HEAD

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

=======
import java.util.UUID;
public class Compensation {
	private String compensationMoney;
	private int condition;
	private int evaluation;
	private String compensationId;
	public Compensation(String compensationMoney, int condition, int evaluation){
		this.compensationMoney = compensationMoney;
		this.condition = condition;
		this.evaluation = evaluation;
		this.compensationId = UUID.randomUUID().toString();
	}
	public boolean authorize(int condition){
		if (this.condition <= 1) {
			this.condition = condition;
			return true;
		}
		else return false;
	}
	public boolean examine(int evaluation){
		if (this.evaluation < 0) {
			this.evaluation = evaluation;
			return true;
		}
		else return false;
	}
>>>>>>> ecdb0ccc5b28034294bfc0191bc661cacd0fcc9e
	public boolean remit(String compensationMoney){
		if (this.compensationMoney != null) {
			this.compensationMoney = compensationMoney;
			return true;
<<<<<<< HEAD
		}		
		else return false;	}

	// public boolean terminate(){
	// 	if (this.condition != null) {
	// 		this.condition = condition;
	// 		return true;
	// 	}		
	// 	else return false;	}

}
=======
		}
		else return false;
	}
	public boolean terminate(){
		return false;
	}
	public boolean match(String compensationId) {
		if (this.compensationId.equals(compensationId)) return true;
		return false;
	}
	// Getters and setters
	public String getCompensationMoney() {
		return compensationMoney;
	}
	public void setCompensationMoney(String compensationMoney) {
		this.compensationMoney = compensationMoney;
	}
	public int getCondition() {
		return condition;
	}
	public void setCondition(int condition) {
		this.condition = condition;
	}
	public int getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}
	public String getCompensationId() {
		return compensationId;
	}
	public void setCompensationId(String compensationId) {
		this.compensationId = compensationId;
	}
}
>>>>>>> ecdb0ccc5b28034294bfc0191bc661cacd0fcc9e
