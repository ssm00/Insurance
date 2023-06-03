package Dao;

import Domain.Contract;
import Domain.ContractListImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ContractDao extends Dao{
    public ContractDao(){
        super.connect();
    }
    public void create(Contract contract){
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
    public void update(Contract beforeContract, Contract afterContract){
        String query = "update contract set coverageDetails = "+ '\''+ afterContract.getCoverageDetails() +'\''+ ","+
                " expirationDate = " + '\''+ (afterContract.getExpirationDate().getYear() + 1900) +"-"+afterContract.getExpirationDate().getMonth()+"-"+afterContract.getExpirationDate().getDate() +'\''+ ","+
                " insuranceFee = " + afterContract.getInsuranceFee() +","+
                " insurancdID = " + afterContract.getInsuranceID() +","+
                " isExpired = "+ afterContract.getIsExpired()+ ","+
                " renewalStatus = " +  afterContract.getRenewalStatus()+
                " where contractID = " + beforeContract.getContractID() + ";";

        System.out.println(query);
        super.update(query);
    }
    public void delete(Contract contract){
        String query = "delete from contract where contractID = " +contract.getContractID() +";";
        super.delete(query);
    }
    public ContractListImpl retrieveAll(){
        String query = "select * from contract;";
        ContractListImpl contractList = new ContractListImpl();
        ResultSet resultSet = super.retrieve(query);
        try {
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
        } catch (SQLException e) {
            System.out.println("데이터베이스와 연결할 수 없습니다.");
        }
        return contractList;
    }


}
