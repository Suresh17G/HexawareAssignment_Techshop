package dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import exception.InvalidDataException;
import util.MyDBConnection;

public class InventoryDao implements InventoryInterface {
    Connection connection;
    Statement statement;
    PreparedStatement preparedStatement; 
    ResultSet resultSet; 

	public void getProduct(int inventoryID) throws ClassNotFoundException {
		try {
	        connection = MyDBConnection.getMyDbConnection();
	        preparedStatement = connection.prepareStatement(
	            "SELECT products.ProductID, products.ProductName, products.Price " +
	            "FROM inventory " +
	            "INNER JOIN products ON inventory.ProductID = products.ProductID " +
	            "WHERE inventory.InventoryID = ?"
	        );
	        preparedStatement.setInt(1, inventoryID);
	        resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {
	            int productID = resultSet.getInt("ProductID");
	            String productName = resultSet.getString("ProductName");
	            double price = resultSet.getDouble("Price");

	            System.out.println("ProductID: " + productID);
	            System.out.println("ProductName: " + productName);
	            System.out.println("Price: " + price);
	        } else {
	            System.out.println("Product not found for InventoryID: " + inventoryID);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        closeResources();
	    }
		
	}
    public int getQuantityInStock(int productID) throws ClassNotFoundException {
        int quantityInStock = 0;
        try {
            connection = MyDBConnection.getMyDbConnection();
            preparedStatement = connection.prepareStatement("SELECT sum(QuantityInStock) FROM inventory WHERE ProductID = ?");
            preparedStatement.setInt(1, productID);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                quantityInStock = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return quantityInStock;
    }

    public void AddToInventory(int quantityinstock, int inventoryid) throws InvalidDataException, ClassNotFoundException {
        try {
            connection = MyDBConnection.getMyDbConnection();
            preparedStatement = connection.prepareStatement("update inventory set quantityinstock=quantityinstock+ ? where inventoryid=?");
            preparedStatement.setInt(1, quantityinstock);
            preparedStatement.setInt(2, inventoryid);
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("inventory stock updated successfully!");
            } else {
                throw new InvalidDataException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    public void RemoveFromInventory(int quantityinstock, int inventoryid) throws InvalidDataException, ClassNotFoundException {
        try {
            connection = MyDBConnection.getMyDbConnection();
            preparedStatement = connection.prepareStatement("update inventory set quantityinstock=quantityinstock- ? where inventoryid=?");
            preparedStatement.setInt(1, quantityinstock);
            preparedStatement.setInt(2, inventoryid);
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("inventory stock updated successfully!");
            } else {
                throw new InvalidDataException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }
    public void updateStockQuantity(int quantityinstock, int inventoryid) throws InvalidDataException, ClassNotFoundException {
        try {
            connection = MyDBConnection.getMyDbConnection();
            preparedStatement = connection.prepareStatement("update inventory set quantityinstock=? where inventoryid=?");
            preparedStatement.setInt(1, quantityinstock);
            preparedStatement.setInt(2, inventoryid);
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("inventory stock updated successfully!");
            } else {
                throw new InvalidDataException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    public boolean isProductAvailable(int productID, int quantityToCheck) throws ClassNotFoundException {
        boolean available = false;
        try {
            connection = MyDBConnection.getMyDbConnection();
            preparedStatement = connection.prepareStatement("SELECT QuantityInStock FROM inventory WHERE ProductID = ?");
            preparedStatement.setInt(1, productID);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int quantityInStock = resultSet.getInt("QuantityInStock");
                available = quantityInStock >= quantityToCheck;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return available;
    }


	public double getInventoryValue() throws ClassNotFoundException {
		 double inventoryValue = 0.0;

	        try {
	            connection = MyDBConnection.getMyDbConnection();
	            preparedStatement = connection.prepareStatement("SELECT sum(inventory.QuantityInStock * products.Price) as TotalValue FROM inventory INNER JOIN products ON inventory.ProductID = products.ProductID");

	            resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                

	            	inventoryValue = resultSet.getDouble("TotalValue");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            closeResources();
	        }

	        return inventoryValue;
	    
		}



	public void listLowStockProducts(int threshold) throws ClassNotFoundException {
		try {
            connection = MyDBConnection.getMyDbConnection();
            preparedStatement = connection.prepareStatement(
                "SELECT InventoryID, ProductID, QuantityInStock " +
                "FROM inventory " +
                "WHERE QuantityInStock < ?"
            );
            preparedStatement.setInt(1, threshold);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int inventoryID = resultSet.getInt("InventoryID");
                int productID = resultSet.getInt("ProductID");
                int quantityInStock = resultSet.getInt("QuantityInStock");

                System.out.println("InventoryID: " + inventoryID);
                System.out.println("ProductID: " + productID);
                System.out.println("QuantityInStock: " + quantityInStock);
                System.out.println("--------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
		
	}

	public void listOutOfStockProducts() throws ClassNotFoundException {
		try {
            connection = MyDBConnection.getMyDbConnection();
            preparedStatement = connection.prepareStatement(
                "SELECT InventoryID, ProductID, QuantityInStock " +
                "FROM inventory " +
                "WHERE QuantityInStock =0"
            );
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int inventoryID = resultSet.getInt("InventoryID");
                int productID = resultSet.getInt("ProductID");
                int quantityInStock = resultSet.getInt("QuantityInStock");

                System.out.println("InventoryID: " + inventoryID);
                System.out.println("ProductID: " + productID);
                System.out.println("QuantityInStock: " + quantityInStock);
                System.out.println("--------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
		
	}
	
	public void listAllProducts() throws ClassNotFoundException {
		try {
            connection = MyDBConnection.getMyDbConnection();
            preparedStatement = connection.prepareStatement("SELECT InventoryID, ProductID, QuantityInStock,lastStockUpdate FROM inventory ");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int inventoryID = resultSet.getInt("InventoryID");
                int productID = resultSet.getInt("ProductID");
                int quantityInStock = resultSet.getInt("QuantityInStock");
                Date lastStockUpdate= resultSet.getDate("lastStockUpdate");

                System.out.println("InventoryID: " + inventoryID);
                System.out.println("ProductID: " + productID);
                System.out.println("QuantityInStock: " + quantityInStock);
                System.out.println("lastStockUpdate: " + lastStockUpdate);
                System.out.println("--------------");
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
