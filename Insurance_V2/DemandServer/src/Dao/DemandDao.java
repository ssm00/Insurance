package Dao;

import Domain.Demand;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DemandDao extends Dao{

    public DemandDao(){
        super.connect();
    }
    public void create(Demand demand) throws SQLException {
        String query = "insert into contract values ("
                +'\''+demand.getDemandId()+'\''+", "
                +demand.getAccidentDate() +", "
                +'\''+demand.getAccidentType() +'\''+", "
                +demand.getCopyofIdentification()+", "
                +'\''+demand.getDetails() +'\''+", "
                +'\''+demand.getDiagnosis() +'\''+", "
                +demand.getDocumentaryEvidence()+", "
                +'\''+demand.getTreatmentHospital() +'\''+", "
                +'\''+demand.getCustomerName() +'\''+", "
                +'\''+demand.getBank() +'\''+", "
                +'\''+demand.getInformation() +'\''+", "
                +'\''+demand.getAccountNumber() +'\'' +");";
        System.out.println(query);
        super.create(query);
    }
//    public void update(String beforeDemandID, Demand afterDemand) throws SQLException {
//        String query = "update contract set coverageDetails = "+ '\''+ afterContract.getCoverageDetails() +'\''+ ","+
//                " expirationDate = " + '\''+ (afterContract.getExpirationDate().getYear() + 1900) +"-"+afterContract.getExpirationDate().getMonth()+"-"+afterContract.getExpirationDate().getDate() +'\''+ ","+
//                " insuranceFee = " + afterContract.getInsuranceFee() +","+
//                " insurancdID = " + afterContract.getInsuranceID() +","+
//                " isExpired = "+ afterContract.getIsExpired()+ ","+
//                " renewalStatus = " +  afterContract.getRenewalStatus()+
//                " where contractID = " + beforeContractID + ";";
//
//        System.out.println(query);
//        super.update(query);
//    }
    public void delete(Demand demand) throws SQLException {
        String query = "delete from contract where demandId = " +'\''+ demand.getDemandId()+'\''+";";
        super.delete(query);
    }
    public ArrayList<Demand> retrieveAll() throws SQLException{
        String query = "select * from demand;";
        ArrayList<Demand> demandList = new ArrayList<Demand>();
        ResultSet resultSet = super.retrieve(query);
        while(resultSet.next()) {
            Demand demand = new Demand(resultSet.getString("demandId"),
                    resultSet.getInt("accidentDate"),
                    resultSet.getString("accidentType"),
                    resultSet.getInt("copyofIdentification"),
                    resultSet.getString("details"),
                    resultSet.getString("diagnosis"),
                    resultSet.getInt("documentaryEvidence"),
                    resultSet.getString("treatmentHospital"),
                    resultSet.getString("customerName"),
                    resultSet.getString("accountNumber"),
                    resultSet.getString("bank"),
                    resultSet.getString("information")
                    );
            demandList.add(demand);
        }
        return demandList;
    }

}
