package dao;

import exception.InvalidDataException;

public interface OrdersInterface {
	
	double calculateTotalAmount(int orderId) throws InvalidDataException, ClassNotFoundException;
	void getOrderDetails(int orderId) throws InvalidDataException, ClassNotFoundException;
	void checkstatus(int orderid) throws ClassNotFoundException;
	void updateOrderStatus(int orderId, String newStatus) throws InvalidDataException, ClassNotFoundException;
	void cancelOrder(int orderId) throws InvalidDataException, ClassNotFoundException;
	void closeResources();

}
