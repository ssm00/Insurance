package sales;

import demand.Demand;

import java.util.ArrayList;

public interface SalesList {

	public boolean add(Sale sale);

	public boolean delete(Sale sale);

	public ArrayList<Sale> retrieve();

	public boolean update();

}
