package contract;

import customer.Customer;
import insurance.Insurance;

import java.util.Date;


public class Contract {

	private String coverageDetails;
	private Date expirationDate;
	private int insuraceID;
	private int insuranceFee;
	private boolean isExpired;
	private boolean renewalStatus;
	public Contract(){

	}

	public boolean checkExpired(){
		return false;
	}

	public boolean updateRenuewalStatus(){
		return false;
	}

}