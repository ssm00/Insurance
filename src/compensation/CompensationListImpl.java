package compensation;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CompensationListImpl implements CompensationList {
    protected ArrayList<Compensation> compensationList;
    public CompensationListImpl(File file) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(file));
		this.compensationList = new ArrayList<Compensation>();
		while (reader.ready()) {
			String compensationDetail = reader.readLine();
			if (!compensationDetail.equals("")) {
				this.compensationList.add(new Compensation(compensationDetail));
			}
		}
		reader.close();
    }
    public ArrayList<Compensation> getAllCompensationRecords() {
		return this.compensationList;
	}
    public boolean add(String compensationDetail){
        if (this.compensationList.add(new Compensation(compensationDetail))) return true;
        else return false;
    }

    public boolean delete(String compensationId){
        for (int i = 0; i < this.compensationList.size(); i++) {
			Compensation compensation = (Compensation) this.compensationList.get(i);
			if (compensation.compensationId.equals(compensationId)) {
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
        return false;
    }
}
