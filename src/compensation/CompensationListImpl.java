package compensation;
import java.util.ArrayList;
public class CompensationListImpl implements CompensationList {
    protected ArrayList<Compensation> compensationList;
    public CompensationListImpl() {
        this.compensationList = new ArrayList<Compensation>();
    }
    public ArrayList<Compensation> getAllCompensationList() {
        return this.compensationList;
    }
    public boolean add(String compensationMoney, int condition, int evaluation) {
        if (this.compensationList.add(new Compensation(compensationMoney, condition, evaluation))) return true;
        else return false;
    }
    public boolean delete(String compensationId){
        for (int i = 0; i < this.compensationList.size(); i++) {
            Compensation compensation = (Compensation) this.compensationList.get(i);
            if (compensation.match(compensationId)) {
                if (this.compensationList.remove(compensation)) return true;
                else return false;
            }
        }
        return false;
    }
    public ArrayList<Compensation> retrieve(){
        if (this.compensationList.size() == 0);
        return this.compensationList;
    }
    public boolean update(){
        // update compensationList
        return false;
    }
}

