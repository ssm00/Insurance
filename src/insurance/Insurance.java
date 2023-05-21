package insurance;

import utils.ConnectErrorException;
import utils.EmptyValueException;
import utils.InvalidInputException;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class Insurance {

	private int coverageAmount;
	private String coverageEvent;
	private int coveragePeriod;
	private String coverageTarget;
	private int insuranceFee;
	private int insuranceID;
	private String insuranceName;
	private PremiumRate premiumRate;
	/**
	 * added
	 */
	private boolean authorizeState;

	public Insurance(int coverageAmount, String coverageEvent, int coveragePeriod, String coverageTarget, int insuranceFee, String insuranceName){
		this.coverageAmount = coverageAmount;
		this.coverageEvent = coverageEvent;
		this.coveragePeriod = coveragePeriod;
		this.coverageTarget = coverageTarget;
		this.insuranceFee = insuranceFee;
		this.insuranceName = insuranceName;
		this.insuranceID = UUID.randomUUID().hashCode();
		this.authorizeState = false;
	}


	public boolean authorize(BufferedReader objectReader) throws InvalidInputException, ConnectErrorException, EmptyValueException, IOException {
		System.out.println("1. 연결성공");
		System.out.println("2. 연결실패");
		String connection = objectReader.readLine().trim();
		if (connection == null || insuranceName.isEmpty()) {
			throw new EmptyValueException("정보를 입력하지 않았습니다.");
		}
		if (connection.equals("1")) {
			setAuthorizeState(true);
			System.out.println("상품이 인가되었습니다");
			return true;
		} else if (connection.equals("2")) {
			throw new ConnectErrorException("금융감독원과의 연결이 되지않았습니다. 다시 시도하십시오.");
		}else {
			throw new InvalidInputException("입력은 1 혹은 2 입니다.");
		}
	}

	public float calculateRate(){
		this.premiumRate = new PremiumRate(coverageAmount,coverageEvent,coveragePeriod, coverageTarget, insuranceFee);
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

	public boolean isAuthorizeState() {
		return authorizeState;
	}

	public void setAuthorizeState(boolean authorizeState) {
		this.authorizeState = authorizeState;
	}


}
