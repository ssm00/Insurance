package sales;

import java.util.ArrayList;

public class SalesListImpl implements SalesList {
	private ArrayList<Sale> saleList;

	public SalesListImpl(){
		this.saleList = new ArrayList<Sale>();
	}

	public boolean add(Sale sale){
		this.saleList.add(sale);
		return true;
	}

	public boolean delete(Sale sale){
		this.saleList.remove(sale);
		return true;
	}

	public ArrayList<Sale> retrieve(){
		return saleList;
	}

	public boolean update(){
		return false;
	}


}