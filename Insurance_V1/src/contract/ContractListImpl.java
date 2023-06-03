package contract;

import java.util.ArrayList;

public class ContractListImpl implements ContractList {

	private ArrayList<Contract> contractList;

	public ContractListImpl(){
		contractList = new ArrayList<Contract>();
	}
	public boolean add(Contract contract){
		contractList.add(contract);
		return false;
	}
	public boolean delete(Contract contract){
		contractList.remove(contract);
		return false;
	}
	public ArrayList<Contract> retrieve(){
		return contractList;
	}

	public boolean update(){
		return false;
	}

}