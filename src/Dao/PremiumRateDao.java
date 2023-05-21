package Dao;

import insurance.Insurance;
import insurance.InsuranceListImpl;
import insurance.PremiumRate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PremiumRateDao extends Dao {
    public PremiumRateDao() {
        try {
            super.connect();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void create(PremiumRate premiumRate){
        String query = "insert into premiumRate values ("
                +"null, "
                + premiumRate.getAccidentRate() +", "
                + premiumRate.getExpectedProfitRate() +", "
                + premiumRate.getRate()+");";
        System.out.println(query);
        super.create(query);
    }

    public void update(PremiumRate beforePremiumRate, PremiumRate afterPremiumRate){
        String query = "update premiumrate set accidentRate = "+ afterPremiumRate.getAccidentRate() + ","+
                " expectedProfitRate = " + afterPremiumRate.getExpectedProfitRate() + ","+
                " rate = "+ afterPremiumRate.getRate()+ ","+
                " where insuranceId = " + beforePremiumRate.getPremiumRateID() + ";";
        System.out.println(query);
        super.update(query);
    }

    public void delete(PremiumRate premiumRate){
        String query = "delete from premiumrate where premiumrateID = " +premiumRate.getPremiumRateID() +";";
        System.out.println(query);
        super.delete(query);
    }
    public ArrayList<PremiumRate> retrieveAll(){
        String query = "select * from premiumrate;";
        ArrayList<PremiumRate> premiumRateList = new ArrayList<>();
        ResultSet resultSet = super.retrieve(query);
        try {
            while(resultSet.next()) {
                PremiumRate premiumRate = new PremiumRate(
                        resultSet.getInt("premiumRateID"),
                        resultSet.getFloat("accidentRate"),
                        resultSet.getFloat("expectedProfitRate"),
                        resultSet.getFloat("rate")
                );
                premiumRateList.add(premiumRate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return premiumRateList;
    }
    
}




