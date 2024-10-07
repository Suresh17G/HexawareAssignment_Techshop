package main;

import java.util.Scanner;
import dao.OrdersDao;
import Entity.Orders;
import exception.InvalidDataException;

public class OrderMain{
    Orders order; 
    Scanner sc = new Scanner(System.in);
    OrdersDao ordersDao = new OrdersDao(); 

    public void CalculateTotalAmount() throws ClassNotFoundException {
        System.out.println("Enter Order ID:");
        int orderId = sc.nextInt();

        try {
            double totalAmount = ordersDao.calculateTotalAmount(orderId);
            System.out.println("Total amount for Order ID " + orderId + ": $" + totalAmount);
        } catch (InvalidDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public void GetOrderDetails() throws ClassNotFoundException {
        System.out.println("Enter Order ID:");
        int orderId = sc.nextInt();

        try {
            ordersDao.getOrderDetails(orderId);
        } catch (InvalidDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public void orderstatus() throws ClassNotFoundException {
        System.out.println("Enter orderID to check status :");
        int orderid = sc.nextInt();
        ordersDao.checkstatus(orderid);
    }

    public void updateOrderStatus() throws ClassNotFoundException {
        System.out.println("Enter Order ID:");
        int orderId = sc.nextInt();

        System.out.println("Enter new status (e.g., processing, shipped):");
        sc.nextLine(); // Consume the newline character
        String newStatus = sc.nextLine();

        try {
            ordersDao.updateOrderStatus(orderId, newStatus);
        } catch (InvalidDataException e) {
            System.out.println(e.getMessage());
        }
    }

	
	public void cancelOrder() throws ClassNotFoundException {
		System.out.println("Enter Order ID:");
        int orderId = sc.nextInt();
		try {
			ordersDao.cancelOrder(orderId);
		} catch (InvalidDataException e) {
			
			System.out.println(e.getMessage());
		}
		
	}
}
