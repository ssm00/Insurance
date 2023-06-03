package contract;

import java.util.ArrayList;

public interface ContractList {
	public boolean add(Contract contract);
	public boolean delete(Contract contract);
	public ArrayList<Contract> retrieve();
	public boolean update();
}