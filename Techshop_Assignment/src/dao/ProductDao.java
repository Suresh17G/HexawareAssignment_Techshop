package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import Collections.ProductsList;
import Entity.Products;
import exception.InsufficientStockException;
import exception.InvalidDataException;
import util.MyDBConnection;

public class ProductDao implements ProductInterface {
	Connection connection;
	Statement statement;
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	public void insertProduct(Products product) throws Exception {
		try {
			connection = MyDBConnection.getMyDbConnection();
			preparedStatement = connection.prepareStatement("insert into products values(?,?,?,?,?,?)");
			preparedStatement.setInt(1, product.getProductID());
			preparedStatement.setString(2, product.getProductName());
			preparedStatement.setString(3, product.getDescription());
			preparedStatement.setDouble(4, product.getPrice());
			preparedStatement.setString(5, product.getCategory());

			int noofrows = preparedStatement.executeUpdate();
			if (noofrows > 0) {
				System.out.println(noofrows + " product inserted successfully !!!");
				ProductsList.addProduct(product);
			} else {
				throw new InvalidDataException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}

	public void getProductDetails(int productID) throws ClassNotFoundException {
		try {
			connection = MyDBConnection.getMyDbConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM products where productID= ?");
			preparedStatement.setInt(1, productID);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				// Print details
				System.out.println("ProductID: " + resultSet.getInt(1));
				System.out.println("ProductName: " + resultSet.getString(2));
				System.out.println("Description: " + resultSet.getString(3));
				System.out.println("Price: " + resultSet.getInt(4));
				System.out.println("Category: " + resultSet.getString(5));
				System.out.println("--------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}

	public List<Products> getProductList() {
		return ProductsList.getAllProducts();
	}

	public void updateProductInfo(int productId, int newPrice, String newDescription)
			throws InvalidDataException, ClassNotFoundException {
		try {
			connection = MyDBConnection.getMyDbConnection();
			preparedStatement = connection
					.prepareStatement("update Products set Price=?,description= ? where ProductID=?");
			preparedStatement.setInt(1, newPrice);
			preparedStatement.setString(2, newDescription);
			preparedStatement.setInt(3, productId);
			int rowsUpdated = preparedStatement.executeUpdate();
			if (rowsUpdated == 1) {
				System.out.println("Product price updated successfully!");
			} else {
				System.out.println("Failed to update product price. Product not found.");
				throw new InvalidDataException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}

	public void isProductInStock(int productId) throws InvalidDataException, ClassNotFoundException {
		try {

			connection = MyDBConnection.getMyDbConnection();
			preparedStatement = connection
					.prepareStatement("SELECT sum(QuantityInStock) FROM Inventory where ProductID=?");
			preparedStatement.setInt(1, productId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				// Print details
				System.out.println("Product in Stock: " + resultSet.getInt(1));
			} else {
				throw new InsufficientStockException();
			}
		} catch (Exception e) {
			System.out.println(e);
			;
		} finally {
			closeResources();
		}
	}

	@Override
	public List<Products> searchProducts(String keyword) throws ClassNotFoundException {
		try {
			connection = MyDBConnection.getMyDbConnection();
			preparedStatement = connection
					.prepareStatement("SELECT * FROM Products WHERE ProductName LIKE ? OR Category LIKE ?");
			preparedStatement.setString(1, "%" + keyword + "%");
			preparedStatement.setString(2, "%" + keyword + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				// Print details
				System.out.println("ProductID: " + resultSet.getInt(1));
				System.out.println("ProductName: " + resultSet.getString(2));
				System.out.println("Description: " + resultSet.getString(3));
				System.out.println("Price: " + resultSet.getInt(4));
				System.out.println("Category: " + resultSet.getString(5));
				System.out.println("--------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
		return null;
	}

	public void closeResources() {
		try {
			if (resultSet != null)
				resultSet.close();
			if (statement != null)
				statement.close();
			if (preparedStatement != null)
				preparedStatement.close();
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
