package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import compensation.Compensation;
import compensation.CompensationListImpl;

public class CompensationDao extends Dao {
    public CompensationDao() {
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

    public void update(Compensation beforeCompensation, Compensation afterCompensation){
        String query = "update compensation set compensationMoney = "+ afterCompensation.getCompensationMoney()+ ","+
                " damage = " + afterCompensation.getDamage()+ ","+
                " evaluation = " + afterCompensation.getEvaluation() +
                " where compensationId = " + beforeCompensation.getCompensationId() + ";";
        System.out.println(query);
        super.update(query);
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
                    resultSet.getInt("compensationId"),
                    resultSet.getInt("compensationMoney"),
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
