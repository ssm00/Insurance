package customer;

public class Customer {
	private String customerID;
	private String customerName;
	private String address;
	private int age;
	private String gender;
	private String job;

	public Customer(String customerID, String customerName, String address, int age, String gender, String job){
		this.customerID = customerID;
		this.customerName = customerName;
		this.address = address;
		this.age = age;
		this.gender = gender;
		this.job = job;
	}

	public String getCustomerID(){return customerID;}
	public String getCustomerName(){return customerName;}
	public String getAddress(){return address;}
	public int getAge(){return age;}
	public String getGender(){return gender;}
	public String getJob(){return job;}
}