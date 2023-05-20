package customer;

public class Customer {
	private int customerID;
	private String customerName;
	private String address;
	private int age;
	private String gender;
	private String job;

	public Customer(int customerID, String customerName, String address, int age, String gender, String job){
		this.customerID = customerID;
		this.customerName = customerName;
		this.address = address;
		this.age = age;
		this.gender = gender;
		this.job = job;
	}

	public int getCustomerID(){return customerID;}
	public String getCustomerName(){return customerName;}
	public String getAddress(){return address;}
	public int getAge(){return age;}
	public String getGender(){return gender;}
	public String getJob(){return job;}
}