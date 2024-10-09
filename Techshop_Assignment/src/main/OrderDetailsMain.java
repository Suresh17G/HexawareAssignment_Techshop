package main;

import java.util.Scanner;
import Entity.OrderDetails;
import dao.OrderdetailsDao;

public class OrderDetailsMain{
    OrderDetails orderDetails; 
    OrderdetailsDao orderdetailsDao = new OrderdetailsDao(); 
    Scanner sc = new Scanner(System.in);

    public void CalculateSubtotal() throws ClassNotFoundException {
        System.out.println("Enter the orderDetailID");
        int orderDetailID = sc.nextInt();
        orderdetailsDao.calculateSubtotal(orderDetailID);
    }

    public void getOrderDetailInfo() throws ClassNotFoundException {
        System.out.println("Enter OrderDetailID: ");
        int orderDetailID = sc.nextInt();

        orderdetailsDao.getOrderDetailInfo(orderDetailID);
    }

    public void updateQuantity() throws ClassNotFoundException {
        System.out.println("Enter OrderDetailID: ");
        int orderDetailID = sc.nextInt();

        System.out.println("Enter new Quantity: ");
        int newQuantity = sc.nextInt();

        orderdetailsDao.updateQuantity(orderDetailID, newQuantity);
    }

	
	public void addDiscount() throws ClassNotFoundException {
		System.out.println("Enter OrderDetailsID: ");
        int orderID = sc.nextInt();

        System.out.println("Enter Discount Percentage: ");
        double discountPercentage = sc.nextDouble();

        orderdetailsDao.addDiscount(orderID, discountPercentage);
		
	}
}
