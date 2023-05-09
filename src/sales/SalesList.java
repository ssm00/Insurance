package sales;

import demand.Demand;

import java.util.ArrayList;

public interface SalesList {

	public boolean add();

	public boolean delete();

	public ArrayList<Sale> retrieve();

	public boolean update();

}
