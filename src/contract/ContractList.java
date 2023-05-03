package contract;

import java.util.ArrayList;


public interface ContractList {

	public boolean add();

	public boolean delete();

	public ArrayList<Contract> retrieve();

	public boolean update();

}