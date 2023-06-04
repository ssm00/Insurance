package Domain;

import java.util.Date;


public class Contract {
	private String coverageDetails;
	private Date expirationDate;

	private int insuranceID;
	private int insuranceFee;
	private int contractID;
	private boolean isExpired;
	private boolean renewalStatus;
	public Contract(int contractID, int insuranceID, int insuranceFee, Date expirationDate, String coverageDetails){
		this.contractID = contractID;
		this.insuranceID = insuranceID;
		this.insuranceFee = insuranceFee;
		this.expirationDate = expirationDate;
		this.coverageDetails = coverageDetails;
		this.isExpired = false;
		this.renewalStatus =false;
	}

	public int getInsuranceID(){
		return insuranceID;
	}
	public int getInsuranceFee(){
		return insuranceFee;
	}
	public Date getExpirationDate(){
		return expirationDate;
	}
	public String getCoverageDetails(){return coverageDetails;}
	public boolean getIsExpired(){return isExpired;}
	public boolean getRenewalStatus(){return renewalStatus;}

	public boolean checkExpired(){
		int result = expirationDate.compareTo(new Date());
		if(result <= 0){isExpired = true;}
		else{isExpired = false;}
		return isExpired;
	}
	public boolean updateRenuewalStatus(boolean renewalStatus){
		this.renewalStatus = renewalStatus;
		return this.renewalStatus;
	}
	public void setrenewalStatus(boolean renewalStatus) {
		this.renewalStatus = renewalStatus;
	}

	public int getContractID() {
		return contractID;
	}

	public void setContractID(int contractID) {
		this.contractID = contractID;
	}
}