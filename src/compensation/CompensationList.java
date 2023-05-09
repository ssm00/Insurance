package compensation;

import java.util.ArrayList;

public interface CompensationList {
	boolean add(String compensationList);
	boolean delete(String compensationId);
	ArrayList<Compensation> retrieve();
	boolean update();
}