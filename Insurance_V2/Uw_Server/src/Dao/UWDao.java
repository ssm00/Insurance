package Dao;

import Domain.UW;

public class UWDao extends Dao{
    public UWDao(){
        super.connect();
    }

    public void create(UW uw){

        String query = "insert into uw values ("
                +uw.getApplicationForm() +", "
                +'\''+uw.getSecurity() +'\''
                //+ lossRate ..?..
                +");"
                ;
        System.out.println(query);
        super.create(query);

    }
}
