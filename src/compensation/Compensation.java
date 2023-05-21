package compensation;

public class Compensation {
	private String compensationMoney;
	private int damage;
	private int evaluation;
	private String compensationId;
	public Compensation(String compensationId, String compensationMoney, int damage, int evaluation){
		this.compensationMoney = compensationMoney;
		this.damage = damage;
		this.evaluation = evaluation;
		this.compensationId = compensationId;
	}
    public boolean authorize(int condition){
		if (this.damage <= 1) {
			this.damage = condition;
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
	public boolean remit(String compensationMoney){
		if (this.compensationMoney != null) {
			this.compensationMoney = compensationMoney;
			return true;
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
	public int getDamage() {
		return damage;
	}
	public void setDamage(int condition) {
		this.damage = condition;
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
