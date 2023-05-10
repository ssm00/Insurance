package compensation;
import java.util.ArrayList;
public interface CompensationList {
	boolean add(String compensationMoney, int condition, int evaluation);
	boolean delete(String compensationId);
	ArrayList<Compensation> retrieve();
	boolean update();
}
