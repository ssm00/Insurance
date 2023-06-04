package Domain;

import utils.InvalidInputException;

import java.io.Serializable;

public class PremiumRate implements Serializable {
	private int premiumRateID;
	private float accidentRate;
	private float expectedProfitRate;
	private float rate;
	public PremiumRate(int premiumRateID, int coverageAmount, String coverageEvent, int coveragePeriod, String coverageTarget, int insuranceFee) {
		final float COVERAGE_AMOUNT_MULTIPLIER = 0.0005f;
		final float COVERAGE_PERIOD_MULTIPLIER = 0.002f;
		final float COVERAGE_TARGET_MULTIPLIER = 0.005f;
		final float INSURANCE_FEE_MULTIPLIER = 0.001f;
		this.premiumRateID = premiumRateID;
		this.accidentRate = coverageAmount * COVERAGE_AMOUNT_MULTIPLIER + coveragePeriod * COVERAGE_PERIOD_MULTIPLIER;
		this.accidentRate += coverageTarget.equals("자동차") ? COVERAGE_TARGET_MULTIPLIER : 0;
		this.expectedProfitRate = insuranceFee * INSURANCE_FEE_MULTIPLIER;
	}
	public PremiumRate() {
	}
	public PremiumRate generateORM(int premiumRateID, float accidentRate, float expectedProfitRate, float rate) {
		PremiumRate premiumRate = new PremiumRate();
		premiumRate.setPremiumRateID(premiumRateID);
		premiumRate.setAccidentRate(accidentRate);
		premiumRate.setExpectedProfitRate(expectedProfitRate);
		premiumRate.setRate(rate);
		return premiumRate;
	}
	public float calculate(){
		rate = (float) ((accidentRate * 20) + (expectedProfitRate * 10));
		return rate;
	}
	public boolean update(float accidentRate, float expectedProfitRate) throws InvalidInputException {
		if (accidentRate < 0 || expectedProfitRate < 0) {
			throw new InvalidInputException("잘못된 입력입니다.");
		}
		this.accidentRate = accidentRate;
		this.expectedProfitRate = expectedProfitRate;
		return true;
	}
	public int getPremiumRateID() {
		return premiumRateID;
	}
	public float getAccidentRate() {
		return accidentRate;
	}
	public float getExpectedProfitRate() {
		return expectedProfitRate;
	}
	public float getRate() {
		return rate;
	}
	public void setPremiumRateID(int premiumRateID) {
		this.premiumRateID = premiumRateID;
	}

	public void setAccidentRate(float accidentRate) {
		this.accidentRate = accidentRate;
	}

	public void setExpectedProfitRate(float expectedProfitRate) {
		this.expectedProfitRate = expectedProfitRate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}
}