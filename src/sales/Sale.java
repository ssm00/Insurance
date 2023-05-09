package sales;

import java.util.Date;

public class Sale {

	private String customerID;
	private String employeeID;
	private int insuranceID;
	private Date salesDate;

	public Sale(String customerID, String employeeID, int insuranceID, Date salesDate){
		this.customerID = customerID;
		this.employeeID = employeeID;
		this.insuranceID = insuranceID;
		this.salesDate = salesDate;
	}

}