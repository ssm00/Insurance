package compensation;
import java.util.ArrayList;
public interface CompensationList {
<<<<<<< HEAD
	boolean add(String compensationList);
	boolean delete(String compensationId);
	ArrayList<Compensation> retrieve();
	boolean update();
}
=======
	boolean add(String compensationMoney, int condition, int evaluation);
	boolean delete(String compensationId);
	ArrayList<Compensation> retrieve();
	boolean update();
}
>>>>>>> ecdb0ccc5b28034294bfc0191bc661cacd0fcc9e
