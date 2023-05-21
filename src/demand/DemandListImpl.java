package demand;

import java.util.ArrayList;

public class DemandListImpl implements DemandList {
	protected ArrayList<Demand> demandList;
	public DemandListImpl(){
		this.demandList = new ArrayList<Demand>();
	}
	public ArrayList<Demand> getAllDemandList() {
		return this.demandList;
	}
	public boolean add(){
		if (this.demandList.add(new Demand(0, 0, 0, null, null, 0, null))) return true;
		else return false;
	}

	public boolean delete(){
		return false;
	}

	public ArrayList<Demand> retrieve(){
		return null;
	}

	public boolean update(){
		return false;
	}

}
