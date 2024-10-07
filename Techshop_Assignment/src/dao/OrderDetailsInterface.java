package dao;

public interface OrderDetailsInterface {

	void calculateSubtotal(int orderDetailID) throws ClassNotFoundException;
	void getOrderDetailInfo(int orderDetailID) throws ClassNotFoundException;
	void updateQuantity(int orderDetailID, int newQuantity) throws ClassNotFoundException;
	void addDiscount(int orderID, double discountPercentage) throws ClassNotFoundException;
	void closeResources();
}
