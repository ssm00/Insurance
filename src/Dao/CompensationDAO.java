package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import compensation.Compensation;
import compensation.CompensationListImpl;

public class CompensationDAO extends Dao {
    public CompensationDAO() {
        super.connect();
    }
    public void create(Compensation compensation){
        String query = "insert into compensation values ("
                + compensation.getCompensationId() +", "
                + compensation.getCompensationMoney() +", "
                + compensation.getDamage() +", "
                + compensation.getEvaluation() +"); ";
        super.create(query);
    }

    public void update(Compensation compensation){
        
    }

    public void delete(Compensation compensation){
        String query = "delete from compensation where compensationId = " +compensation.getCompensationId() +";";
        super.delete(query);
    }
    public CompensationListImpl retrieveAll(){
        String query = "select * from compensation;";
        CompensationListImpl compensationList = new CompensationListImpl();
        ResultSet resultSet = super.retrieve(query);
        try {
            while(resultSet.next()) {
                Compensation compensation = new Compensation(
                    resultSet.getString("compensationId"),
                    resultSet.getString("compensationMoney"),
                    resultSet.getInt("damage"),
                    resultSet.getInt("evaluation"));
                compensationList.add(compensation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return compensationList;
    }
}
