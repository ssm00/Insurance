package Domain;

import utils.ConnectErrorException;
import utils.EmptyValueException;
import utils.InvalidInputException;

import java.io.IOException;
import java.io.Serializable;

public class Insurance implements Serializable {
	private int insuranceID;
	private String insuranceName;
	private int coverageAmount;
	private String coverageEvent;
	private int coveragePeriod;
	private String coverageTarget;
	private int insuranceFee;
	private boolean authorizeState;
	private PremiumRate premiumRate;
	public Insurance(int insuranceID, String insuranceName, int coverageAmount, String coverageEvent, int coveragePeriod, String coverageTarget, int insuranceFee){
		this.insuranceID = insuranceID;
		this.insuranceName = insuranceName;
		this.coverageAmount = coverageAmount;
		this.coverageEvent = coverageEvent;
		this.coveragePeriod = coveragePeriod;
		this.coverageTarget = coverageTarget;
		this.insuranceFee = insuranceFee;
		this.authorizeState = false;
	}
	public Insurance() {
	}
	public Insurance generateORM(int insuranceID, String insuranceName, int coverageAmount, String coverageEvent, int coveragePeriod, String coverageTarget, int insuranceFee, boolean authorizeState, PremiumRate premiumRate) {
		Insurance insurance = new Insurance();
		insurance.setInsuranceID(insuranceID);
		insurance.setInsuranceName(insuranceName);
		insurance.setCoverageAmount(coverageAmount);
		insurance.setCoverageEvent(coverageEvent);
		insurance.setCoveragePeriod(coveragePeriod);
		insurance.setCoverageTarget(coverageTarget);
		insurance.setInsuranceFee(insuranceFee);
		insurance.setAuthorizeState(authorizeState);
		insurance.setPremiumRate(premiumRate);
		return insurance;
	}
	public boolean authorize(String connection) throws InvalidInputException, ConnectErrorException, EmptyValueException, IOException {
		if (connection.equals("1")) {
			setAuthorizeState(true);
			return true;
		}else {
			return false;
		}
	}
	public float calculateRate(){
		this.premiumRate = new PremiumRate(insuranceID,coverageAmount,coverageEvent,coveragePeriod, coverageTarget, insuranceFee);
		return premiumRate.calculate();
	}
	public int getCoverageAmount() {
		return coverageAmount;
	}
	public void setCoverageAmount(int coverageAmount) {
		this.coverageAmount = coverageAmount;
	}
	public String getCoverageEvent() {
		return coverageEvent;
	}
	public void setCoverageEvent(String coverageEvent) {
		this.coverageEvent = coverageEvent;
	}
	public int getCoveragePeriod() {
		return coveragePeriod;
	}
	public void setCoveragePeriod(int coveragePeriod) {
		this.coveragePeriod = coveragePeriod;
	}
	public String getCoverageTarget() {
		return coverageTarget;
	}
	public void setCoverageTarget(String coverageTarget) {
		this.coverageTarget = coverageTarget;
	}
	public int getInsuranceFee() {
		return insuranceFee;
	}
	public void setInsuranceFee(int insuranceFee) {
		this.insuranceFee = insuranceFee;
	}
	public int getInsuranceID() {
		return insuranceID;
	}
	public void setInsuranceID(int insuranceID) {
		this.insuranceID = insuranceID;
	}
	public String getInsuranceName() {
		return insuranceName;
	}
	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}
	public PremiumRate getPremiumRate() {
		return premiumRate;
	}
	public void setPremiumRate(PremiumRate premiumRate) {
		this.premiumRate = premiumRate;
	}
	public boolean isAuthorize() {
		return authorizeState;
	}
	public void setAuthorizeState(boolean authorizeState) {
		this.authorizeState = authorizeState;
	}
}
