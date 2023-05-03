package compensation;

import java.util.ArrayList;

public interface CompensationList {

	public boolean add();

	public boolean delete();

	public ArrayList<Compensation> retrieve();

	public boolean update();

}