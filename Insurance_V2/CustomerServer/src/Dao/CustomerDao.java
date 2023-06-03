package Dao;

import customer.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDao extends Dao{
    public CustomerDao(){super.connect();}
    public void create(Customer customer) throws SQLException {
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

    public void update(int beforeCustomerID, Customer afterCustomer) throws SQLException {
        String query = "update customer set customerName = "+ '\''+ afterCustomer.getCustomerName() +'\''+ ","+
                " address = " + '\''+ afterCustomer.getAddress() +'\''+ ","+
                " age = " + afterCustomer.getAge() +","+
                " gender = "+ '\''+ afterCustomer.getGender()+'\''+ ","+
                " job = " + '\''+ afterCustomer.getJob() +'\''+
                " where customerID = " + beforeCustomerID + ";";

        System.out.println(query);
        super.update(query);
    }

    public void delete(Customer customer) throws SQLException {
        String query = "delete from customer where customerID = " +customer.getCustomerID() +";";
        System.out.println(query);
        super.delete(query);
    }
    public ArrayList<Customer> retrieveAll() throws SQLException {
        String query = "select * from customer;";
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        ResultSet resultSet = super.retrieve(query);
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
        return customerList;
    }
}
