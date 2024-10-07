package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Entity.*;
import exception.InvalidDataException;
import util.MyDBConnection;

public class CustomerDao implements CustomerInterface {
    Connection connection;
    Statement statement;
    PreparedStatement preparedStatement; 
    ResultSet resultSet; 

    public void insertCustomer(Customers customer) throws InvalidDataException, ClassNotFoundException {
        try {
            connection = MyDBConnection.getMyDbConnection();
            preparedStatement = connection.prepareStatement("insert into customers values(?,?,?,?,?,?)");
            preparedStatement.setInt(1, customer.getCustomerID());
            preparedStatement.setString(2, customer.getFirstName());
            preparedStatement.setString(3, customer.getLastName());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setString(5, customer.getPhone());
            preparedStatement.setString(6, customer.getAddress());

            int noofrows = preparedStatement.executeUpdate();
            if (noofrows > 0) {
                System.out.println(noofrows + " inserted successfully !!!");
            } else {
                throw new InvalidDataException();
            }

        } catch (SQLException e) {
        	System.out.println(e);
        } finally {
            closeResources();
        }
    }

    public void getCustomerDetails(int customerID) throws ClassNotFoundException {
        try {
            connection = MyDBConnection.getMyDbConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM customers where customerID= ?");
            preparedStatement.setInt(1, customerID);
            resultSet = preparedStatement.executeQuery(); 
            while (resultSet.next()) {
                System.out.println("CustomerID: " + resultSet.getInt(1));
                System.out.println("FirstName: " + resultSet.getString(2));
                System.out.println("LastName: " + resultSet.getString(3));
                System.out.println("Email: " + resultSet.getString(4));
                System.out.println("Phone: " + resultSet.getString(5));
                System.out.println("Address: " + resultSet.getString(6));
                System.out.println("-------------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    public void updateCustomerInfo(int cusid, String cusemail, String cusphone) throws InvalidDataException, ClassNotFoundException {
        try {
            connection = MyDBConnection.getMyDbConnection();
            preparedStatement = connection.prepareStatement("update customers set email=?,phone=? where customerid=?");
            preparedStatement.setString(1, cusemail);
            preparedStatement.setString(2, cusphone);
            preparedStatement.setInt(3, cusid);
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated == 1) {
                System.out.println("customer details updated successfully!");
            } else {
                throw new InvalidDataException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

    }

    public void calculateTotalOrders(int customerID) throws ClassNotFoundException {
        try {
            connection = MyDBConnection.getMyDbConnection();
            preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM orders WHERE CustomerID = ?");
            preparedStatement.setInt(1, customerID);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int totalOrders = resultSet.getInt(1);
                System.out.println("Total orders placed by customer: " + totalOrders);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    public void closeResources() {
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
