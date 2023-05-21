package compensation;

import java.util.ArrayList;
public class CompensationListImpl implements CompensationList {
    protected ArrayList<Compensation> compensationList;
    public CompensationListImpl(){
        compensationList = new ArrayList<Compensation>();
    }
    public boolean add(Compensation compensation){
        if(compensationList.add(compensation)) return true;
        return false;
    }
    public boolean delete(Compensation compensation){
        if(compensationList.remove(compensation)) return true;
        return false;
    }
    public ArrayList<Compensation> retrieve(){
        return compensationList;
    }
    public boolean update(){
        // update compensationList
        return false;
    }
}

