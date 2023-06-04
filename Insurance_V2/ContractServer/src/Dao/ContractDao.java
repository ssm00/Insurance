package Dao;

import Domain.Contract;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class ContractDao extends Dao{
    public ContractDao(){
        super.connect();
    }
    public void create(Contract contract) throws SQLException {
        String query = "insert into contract values ("
                +contract.getContractID()+", "
                +contract.getInsuranceID() +", "
                +'\''+contract.getCoverageDetails() +'\''+", "
                +'\''+(contract.getExpirationDate().getYear() + 1900) +"-"+contract.getExpirationDate().getMonth()+"-"+contract.getExpirationDate().getDate() +'\''+", "
                +contract.getInsuranceFee() +", "
                +contract.getIsExpired() +", "
                +contract.getRenewalStatus() +");";
        System.out.println(query);
        super.create(query);
    }
    public void update(int beforeContractID, Contract afterContract) throws SQLException {
        String query = "update contract set coverageDetails = "+ '\''+ afterContract.getCoverageDetails() +'\''+ ","+
                " expirationDate = " + '\''+ (afterContract.getExpirationDate().getYear() + 1900) +"-"+afterContract.getExpirationDate().getMonth()+"-"+afterContract.getExpirationDate().getDate() +'\''+ ","+
                " insuranceFee = " + afterContract.getInsuranceFee() +","+
                " isExpired = "+ afterContract.getIsExpired()+ ","+
                " renewalStatus = " +  afterContract.getRenewalStatus()+
                " where contractID = " + beforeContractID + ";";

        System.out.println(query);
        super.update(query);
    }
    public void delete(Contract contract) throws SQLException {
        String query = "delete from contract where contractID = " +contract.getContractID() +";";
        super.delete(query);
    }
    public ArrayList<Contract> retrieveAll() throws SQLException{
        String query = "select * from contract;";
        ArrayList<Contract> contractList = new ArrayList<Contract>();
        ResultSet resultSet = super.retrieve(query);
        while(resultSet.next()) {
            String[] dateList = resultSet.getString("expirationDate").split("-");
            Date date = new Date(Integer.parseInt(dateList[0]) - 1900,Integer.parseInt(dateList[1]),Integer.parseInt(dateList[2]));
            Contract contract = new Contract(resultSet.getInt("contractID"),
                    resultSet.getInt("insuranceID"),
                    resultSet.getInt("insuranceFee"),
                    date
                    ,resultSet.getString("coverageDetails"));

            contract.checkExpired();
            contract.setrenewalStatus(resultSet.getBoolean("renewalStatus"));
            contractList.add(contract);
        }
        return contractList;
    }


    public ArrayList<Contract> retrieveExpired() throws SQLException {
        String query = "select * from contract where isExpired = 1;";
        ArrayList<Contract> contractList = new ArrayList<Contract>();
        ResultSet resultSet = super.retrieve(query);
        while(resultSet.next()) {
            String[] dateList = resultSet.getString("expirationDate").split("-");
            Date date = new Date(Integer.parseInt(dateList[0]) - 1900,Integer.parseInt(dateList[1]),Integer.parseInt(dateList[2]));
            Contract contract = new Contract(resultSet.getInt("contractID"),
                    resultSet.getInt("insuranceID"),
                    resultSet.getInt("insuranceFee"),
                    date
                    ,resultSet.getString("coverageDetails"));

            contract.checkExpired();
            contract.setrenewalStatus(resultSet.getBoolean("renewalStatus"));
            contractList.add(contract);
        }
        return contractList;
    }

    public void renewalExpiredAll() throws SQLException {
        String query = "select * from contract;";
        ArrayList<Contract> contractList = new ArrayList<Contract>();
        ResultSet resultSet = super.retrieve(query);
        while(resultSet.next()) {
            String[] dateList = resultSet.getString("expirationDate").split("-");
            Date date = new Date(Integer.parseInt(dateList[0]) - 1900,Integer.parseInt(dateList[1]),Integer.parseInt(dateList[2]));
            Contract contract = new Contract(resultSet.getInt("contractID"),
                    resultSet.getInt("insuranceID"),
                    resultSet.getInt("insuranceFee"),
                    date
                    ,resultSet.getString("coverageDetails"));

            contract.checkExpired();
            contract.setrenewalStatus(resultSet.getBoolean("renewalStatus"));
            query = "update contract set isExpired = "+ contract.getIsExpired()+
                    " where contractID = " + contract.getContractID() + ";";

            System.out.println(query);
            super.update(query);
        }
    }
}
