package insurance;

public class Insurance {

	private int coverageAmount;
	private String coverageEvent;
	private int coveragePeriod;
	private String coverageTarget;
	private int insuranceFee;
	private int insuranceID;
	private String insuranceName;
	private PremiumRate premiumRate;

	public Insurance(){

	}

	public boolean authorize(){
		return false;
	}

	public float calculateRate(){
		return 1;
	}

}