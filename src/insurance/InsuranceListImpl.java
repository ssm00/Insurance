package insurance;

import java.util.ArrayList;

public class InsuranceListImpl implements InsuranceList {

	private ArrayList<Insurance> insuranceList;

	public InsuranceListImpl(){
		insuranceList = new ArrayList<>();
	}

	public boolean add(Insurance insurance){
		this.insuranceList.add(insurance);
		return true;
	}

	public boolean delete(){
		return false;
	}

	public ArrayList<Insurance> retrieve(){
		return this.insuranceList;
	}

	public boolean update(){
		return false;
	}

	public ArrayList<Insurance> getInsuranceList() {
		return insuranceList;
	}
}