package sales;

import java.util.Date;

public class Sale {

	private int customerID;
	private String employeeID;
	private int insuranceID;
	private Date salesDate;

	public Sale(int customerID, String employeeID, int insuranceID, Date salesDate){
		this.customerID = customerID;
		this.employeeID = employeeID;
		this.insuranceID = insuranceID;
		this.salesDate = salesDate;
	}

	public Date getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}

	public int getInsuranceID() {
		return insuranceID;
	}

	public void setInsuranceID(int insuranceID) {
		this.insuranceID = insuranceID;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
}