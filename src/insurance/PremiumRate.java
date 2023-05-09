package insurance;

import utils.InvalidInputException;

public class PremiumRate {

	private float accidentRate;
	private float expectedProfitRate;
	private float rate;

	public PremiumRate(int coverageAmount, String coverageEvent, int coveragePeriod, String coverageTarget, int insuranceFee) {
		final float COVERAGE_AMOUNT_MULTIPLIER = 0.5f;
		final float COVERAGE_PERIOD_MULTIPLIER = 2f;
		final float COVERAGE_TARGET_MULTIPLIER = 5f;
		final float INSURANCE_FEE_MULTIPLIER = 1f;
		this.accidentRate = coverageAmount * COVERAGE_AMOUNT_MULTIPLIER + coveragePeriod * COVERAGE_PERIOD_MULTIPLIER;
		this.accidentRate += coverageTarget.equals("자동차") ? COVERAGE_TARGET_MULTIPLIER : 0;
		this.expectedProfitRate = insuranceFee * INSURANCE_FEE_MULTIPLIER;
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
}