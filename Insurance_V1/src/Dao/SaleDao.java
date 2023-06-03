package Dao;

import Domain.Contract;
import Domain.Sale;

public class SaleDao extends Dao {
    public SaleDao(){
        super.connect();
    }
    public void create(Sale sale){
        String query = "insert into sale values ("
                +sale.getCustomerID() +", "
                +'\''+sale.getEmployeeID() +'\''+", "
                +sale.getInsuranceID() +","
                +'\''+(sale.getSalesDate().getYear() + 1900)+"-"+(sale.getSalesDate().getMonth() + 1)+"-"+sale.getSalesDate().getDate() +'\''+");"
                ;
        System.out.println(query);
        super.create(query);
    }
}
