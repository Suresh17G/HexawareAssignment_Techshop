package Entity;

import java.util.Date;
import Collections.OrdersList;

public class Orders {
	private int orderID;
	private Customers customer;
	private Date orderDate;
	private double totalAmount;
	private String status;
	
	public Orders(int orderID, Customers customer, Date orderDate, double
	totalAmount) {
	this.orderID = orderID;
	this.customer = customer;
	this.orderDate = orderDate;
	this.totalAmount = totalAmount;
	this.status = "Processing";
	OrdersList.addOrder(this);
	}

    // Getters and Setters
    public int getOrderID() {
        return orderID;
    }
    public void setorderID(int orderID) {
        this.orderID = orderID;
    }
    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public Date getOrderDate() {
        return this.orderDate;
    }
    
    public void setOrderDate(Date orderDate) {
        this.orderDate=orderDate;
    }
    public double getTotalAmount() {
        return this.totalAmount;
    }
    public void setTotalAmount(double totalAmount) {
        this.totalAmount=totalAmount;
    }
    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status=status;
    }
	
}
