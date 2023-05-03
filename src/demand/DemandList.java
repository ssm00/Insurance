package demand;

import java.util.ArrayList;
public interface DemandList {

	public boolean add();

	public boolean delete();

	public ArrayList<Demand> retrieve();

	public boolean update();

}