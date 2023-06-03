package Domain;
import java.util.ArrayList;
public interface DemandList {
	public boolean add(Demand demand);
	public boolean delete(Demand demand);
	public ArrayList<Demand> retrieve();
	public boolean update();
}
