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
		int result = expirationDate.compareTo(new Date());

		if(result <= 0){
			return false; // 만료안됨
		}
		else{
			return true;// 만료됨
		}
	}

	public boolean updateRenuewalStatus(){
		return false;
	}

}