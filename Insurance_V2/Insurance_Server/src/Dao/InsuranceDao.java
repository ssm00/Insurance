package Dao;
import Domain.Insurance;
import Domain.PremiumRate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InsuranceDao extends Dao {
    public InsuranceDao() {
        try {
            super.connect();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void create(Insurance insurance){
        String query = "insert into insurance values ("
                +insurance.getInsuranceID()+", "
                +'\''+insurance.getInsuranceName() +'\''+", "
                +insurance.getCoverageAmount()+", "
                +'\''+insurance.getCoverageEvent() +'\''+", "
                +insurance.getCoveragePeriod() +", "
                +'\''+insurance.getCoverageTarget() +'\''+", "
                +insurance.getInsuranceFee()+", "
                +insurance.isAuthorize()+", "
                +insurance.getPremiumRate().getPremiumRateID()+");";
        System.out.println(query);
        super.create(query);
    }

    public void update(Insurance beforeInsurance, Insurance afterInsurance){
        String query = "update insurance set insuranceName = "+ '\''+ afterInsurance.getInsuranceName() +'\''+ ","+
                " coverageAmount = " +  afterInsurance.getCoverageAmount() + ","+
                " coverageEvent = " + '\''+ afterInsurance.getCoverageEvent() +'\''+ ","+
                " coveragePeriod = " +  afterInsurance.getCoveragePeriod() + ","+
                " coverageTarget = " +'\''+ afterInsurance.getCoverageTarget() +'\''+ ","+
                " insuranceFee = "+ afterInsurance.getInsuranceFee()+ ","+
                " authorizeState = "+ afterInsurance.isAuthorize()+ ","+
                " premiumRateID = " + afterInsurance.getPremiumRate().getPremiumRateID()+
                " where insuranceId = " + beforeInsurance.getInsuranceID() + ";";
        System.out.println(query);
        super.update(query);
    }
    public void delete(Insurance insurance){
        String query = "delete from insurance where insuranceId = " +insurance.getInsuranceID() +";";
        System.out.println(query);
        super.delete(query);
    }
    public ArrayList<Insurance> retrieveAll(){
        String query = "select * from insurance;";
        ArrayList<Insurance> insuranceList = new ArrayList<>();
        ResultSet resultSet = super.retrieve(query);
        try {
            while(resultSet.next()) {
                int premiumRateID = resultSet.getInt("premiumRateID");
                ResultSet premiumRateInfo = super.retrieve("select * from premiumRate where premiumRateID = " + premiumRateID + ";");
                PremiumRate premiumRate = null;
                while(premiumRateInfo.next()) {
                    premiumRate = new PremiumRate();
                    premiumRate.generateORM(premiumRateInfo.getInt("premiumRateID"),
                            premiumRateInfo.getFloat("accidentRate"),
                            premiumRateInfo.getFloat("expectedProfitRate"),
                            premiumRateInfo.getFloat("rate"));
                }
                Insurance insurance = new Insurance();
                insurance.generateORM(resultSet.getInt("insuranceID"),
                        resultSet.getString("insuranceName"),
                        resultSet.getInt("coverageAmount"),
                        resultSet.getString("coverageEvent"),
                        resultSet.getInt("coveragePeriod"),
                        resultSet.getString("coverageTarget"),
                        resultSet.getInt("insuranceFee"),
                        resultSet.getBoolean("authorizeState"),
                        premiumRate);
                insuranceList.add(insurance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insuranceList;
    }
}
