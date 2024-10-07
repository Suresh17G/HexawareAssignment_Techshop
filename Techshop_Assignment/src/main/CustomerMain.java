package main;

import java.util.Scanner;
import dao.CustomerDao;
import Entity.Customers;
import exception.InvalidDataException;

public class CustomerMain{
    Customers customer; 
    Scanner sc = new Scanner(System.in);

    CustomerDao customerDao = new CustomerDao(); 

    public void addCustomer() throws ClassNotFoundException {
        customer = new Customers();
        System.out.print("Enter the customer id: ");
        int customerID = sc.nextInt();
        customer.setCustomerID(customerID);

        System.out.print("Enter customer first Name: ");
        String cfname = sc.next();
        customer.setFirstName(cfname);

        System.out.print("Enter customers Last Name:");
        String lastName = sc.next();
        customer.setLastName(lastName);

        System.out.print("Enter Email:");
        String email = sc.next();
        customer.setEmail(email);

        System.out.print("Enter Phone:");
        String phone = sc.next();
        customer.setPhone(phone);

        System.out.print("Enter Address:");
        String address = sc.next();
        customer.setAddress(address);

        // You should call the method to insert the customer into the database
        try {
            customerDao.insertCustomer(customer);
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }

        System.out.println("Customer added successfully !!!");
    }

    public void viewCustomer() throws ClassNotFoundException {
    	 System.out.print("Enter customerid: ");
         int cusid = sc.nextInt();
        customerDao.getCustomerDetails(cusid);
    }

    public void custDetailupd() throws ClassNotFoundException {
        System.out.print("Enter customerid :");
        int cusid = sc.nextInt();
        System.out.print("Enter the new email :");
        String cusemail = sc.next();
        System.out.print("Enter the new phonenumber :");
        String cusphone = sc.next();
        try {
            customerDao.updateCustomerInfo(cusid, cusemail, cusphone);
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }
    }

    public void numOfOrder() throws ClassNotFoundException {
        System.out.print("Enter customer ID:");
        int customerID = sc.nextInt();
        customerDao.calculateTotalOrders(customerID);
    }
}
