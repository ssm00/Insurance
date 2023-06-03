package demand;

import java.util.ArrayList;

public class DemandListImpl implements DemandList {
	protected ArrayList<Demand> demandList;
	public DemandListImpl(){
		this.demandList = new ArrayList<Demand>();
	}
	public boolean add(Demand demand){
		if (this.demandList.add(demand)) return true;
		else return false;
	}

	public boolean delete(Demand demand){
		if (this.demandList.remove(demand)) return true;
		else return false;
	}

	public ArrayList<Demand> retrieve(){
		return demandList;
	}

	public boolean update(){
		return false;
	}

}
