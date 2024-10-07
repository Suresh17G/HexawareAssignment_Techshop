package dao;

import Entity.Customers;
import exception.InvalidDataException;

public interface CustomerInterface {
	void insertCustomer (Customers customer)throws InvalidDataException, ClassNotFoundException ;
    void getCustomerDetails(int customerID) throws ClassNotFoundException;
    void updateCustomerInfo(int cusid, String cusemail, String cusphone) throws InvalidDataException, ClassNotFoundException;
    void calculateTotalOrders(int customerID) throws ClassNotFoundException;

    void closeResources();

}
