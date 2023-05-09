package insurance;

import java.util.ArrayList;

public interface InsuranceList {

	public boolean add();

	public boolean delete();

	public ArrayList<Insurance> retrieve();

	public boolean update();

}