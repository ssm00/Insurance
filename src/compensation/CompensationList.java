package compensation;
import java.util.ArrayList;
public interface CompensationList {
	boolean add(Compensation compensation);
	boolean delete(Compensation compensation);
	ArrayList<Compensation> retrieve();
	boolean update();
}
