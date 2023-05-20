package Dao;

import contract.Contract;
import contract.ContractListImpl;
import customer.Customer;
import customer.CustomerListImpl;
import sales.Sale;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class CustomerDao extends Dao{
    public CustomerDao(){super.connect();}
    public void create(Customer customer){
        String query = "insert into customer values ("
                + customer.getCustomerID() +", "
                + customer.getAge() +", "
                +'\''+customer.getCustomerName() +'\''+", "
                +'\''+customer.getAddress() +'\''+", "
                +'\''+customer.getGender() +'\''+", "
                +'\''+customer.getJob() +'\''+");";
        System.out.println(query);
        super.create(query);
    }

    public void update(Customer beforeCustomer, Customer afterCustomer){
        String query = "update customer set customerName = "+ '\''+ afterCustomer.getCustomerName() +'\''+ ","+
                " address = " + '\''+ afterCustomer.getAddress() +'\''+ ","+
                " age = " + afterCustomer.getAge() +","+
                " gender = "+ '\''+ afterCustomer.getGender()+'\''+ ","+
                " job = " + '\''+ afterCustomer.getJob() +'\''+
                " where customerID = " + beforeCustomer.getCustomerID() + ";";

        System.out.println(query);
        super.update(query);
    }

    public void delete(Customer customer){
        String query = "delete from customer where customerID = " +customer.getCustomerID() +";";
        System.out.println(query);
        super.delete(query);
    }
    public CustomerListImpl retrieveAll(){
        String query = "select * from customer;";
        CustomerListImpl customerList = new CustomerListImpl();
        ResultSet resultSet = super.retrieve(query);
        try {
            while(resultSet.next()) {
                Customer customer = new Customer(
                        resultSet.getInt("customerID"),
                        resultSet.getString("customerName"),
                        resultSet.getString("address"),
                        resultSet.getInt("age"),
                        resultSet.getString("gender"),
                        resultSet.getString("job"));
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }
}
