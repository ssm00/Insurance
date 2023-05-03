package contract;

import java.util.ArrayList;

public class ContractListImpl implements ContractList {

	private ArrayList<Contract> contractList;

	public ContractListImpl(){

	}

	public void finalize() throws Throwable {

	}

	public boolean add(){
		return false;
	}

	public boolean delete(){
		return false;
	}

	public ArrayList<Contract> retrieve(){
		return null;
	}

	public boolean update(){
		return false;
	}

}