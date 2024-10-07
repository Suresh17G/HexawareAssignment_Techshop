package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import exception.InvalidDataException;
import util.MyDBConnection;

public class OrdersDao implements OrdersInterface{
	Connection connection;
	Statement statement;
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	public double calculateTotalAmount(int orderId) throws InvalidDataException, ClassNotFoundException {
		double totalAmount = 0;

		try {
			connection = MyDBConnection.getMyDbConnection();
			preparedStatement = connection.prepareStatement(
					"SELECT SUM(orderdetails.quantity * products.price) AS total_amount FROM orderdetails inner join products on orderdetails.productid=products.productid WHERE orderid = ?");
			preparedStatement.setInt(1, orderId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				totalAmount = resultSet.getDouble(1);
			} else {
				throw new InvalidDataException();
			}
		} catch (SQLException e) {
			System.out.println("Order not found with ID: " + orderId);
		} finally {
			closeResources();
		}

		return totalAmount;
	}

	public void getOrderDetails(int orderId) throws InvalidDataException, ClassNotFoundException {
		try {
			connection = MyDBConnection.getMyDbConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM orderdetails WHERE orderid = ?");
			preparedStatement.setInt(1, orderId);
			resultSet = preparedStatement.executeQuery();

			if (!resultSet.isBeforeFirst()) {
				throw new InvalidDataException();
			}

			while (resultSet.next()) {
				int productId = resultSet.getInt("productid");
				int quantity = resultSet.getInt("quantity");

				System.out.println("Product ID: " + productId + ", Quantity: " + quantity);
			}
		} catch (SQLException e) {
			System.out.println("No order details found for Order ID: " + orderId);
		} finally {
			closeResources();
		}
	}

	public void checkstatus(int orderid) throws ClassNotFoundException {
		try {
			connection = MyDBConnection.getMyDbConnection();
			preparedStatement = connection.prepareStatement("select status from orders where orderid=?");
			preparedStatement.setInt(1, orderid);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String status = resultSet.getString("status");
				System.out.println("Order Status: " + status);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}

	}

	public void updateOrderStatus(int orderId, String newStatus) throws InvalidDataException, ClassNotFoundException {
		try {
			connection = MyDBConnection.getMyDbConnection();
			preparedStatement = connection.prepareStatement("UPDATE orders SET status = ? WHERE orderid = ?");
			preparedStatement.setString(1, newStatus);
			preparedStatement.setInt(2, orderId);

			int rowsUpdated = preparedStatement.executeUpdate();

			if (rowsUpdated > 0) {
				System.out.println("Order status updated successfully!");
			} else {
				throw new InvalidDataException();
			}
		} catch (SQLException e) {
			System.out.println("No order found with ID: " + orderId);
		} finally {
			closeResources();
		}
	}

	public void cancelOrder(int orderId) throws InvalidDataException, ClassNotFoundException {
		try {
			connection = MyDBConnection.getMyDbConnection();
			preparedStatement = connection.prepareStatement("DELETE FROM orders WHERE orderid = ?");
			preparedStatement.setInt(1, orderId);

			int rowsDeleted = preparedStatement.executeUpdate();
			if (rowsDeleted <= 0) {
				throw new InvalidDataException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
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
