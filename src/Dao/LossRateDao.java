package Dao;

import uw.LossRate;
import uw.UW;

public class LossRateDao extends Dao{

    public  LossRateDao(){
        super.connect();
    }

    public void create(LossRate lossRate){

        String query = "insert into lossRate values ("
                + lossRate.getLossRate() +", "
                + lossRate.getAccidentType() +", "
                +'\''+lossRate.getCoverageLimit() +'\''+", "
                +'\''+lossRate.getInsuranceFee() +'\''+", "
                +'\''+lossRate.getPaidAmount() +'\''+");";
        System.out.println(query);
        super.create(query);

    }
}
