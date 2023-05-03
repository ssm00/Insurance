package compensation;
public class Compensation {

	private String compensationMoney;
	private int condition;
	private int evaluation;

	public Compensation(){

	}

	public boolean authorize(){
		return false;
	}

	public boolean examine(){
		return false;
	}

	public boolean remit(){
		return false;
	}

	public boolean terminate(){
		return false;
	}

}