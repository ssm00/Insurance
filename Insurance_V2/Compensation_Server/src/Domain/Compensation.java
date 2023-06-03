package Domain;

import java.io.Serializable;

public class Compensation implements Serializable {
	private Integer compensationMoney;
	private int damage;
	private int evaluation;
	private Integer compensationId;
	public Compensation(Integer compensationId, Integer compensationMoney, int damage, int evaluation){
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
	public boolean remit(Integer compensationMoney){
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
	public Integer getCompensationMoney() {
		return compensationMoney;
	}
	public void setCompensationMoney(Integer compensationMoney) {
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
	public Integer getCompensationId() {
		return compensationId;
	}
	public void setCompensationId(Integer compensationId) {
		this.compensationId = compensationId;
	}
}
