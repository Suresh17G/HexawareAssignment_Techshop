package Entity;

import exception.IncompleteOrderException;
import exception.InvalidDataException;

public class OrderDetails {
	private int orderDetailID;
	private Orders order;
	private Products product;
	private int quantity;

	public OrderDetails(int orderDetailID, Orders order, Products product, int quantity) throws Exception {
		if (order == null || product == null || quantity <= 0) {
			try {
				throw new IncompleteOrderException();
			} catch (IncompleteOrderException ide) {
				System.out.println(ide);
			}
		}

		this.orderDetailID = orderDetailID;
		this.order = order;
		this.product = product;
		this.quantity = quantity;
	}

	// Getters
	public int getOrderDetailID() {
		return orderDetailID;
	}
	
	public void setOrderDetailID(int orderDetailID) {
		this.orderDetailID=orderDetailID;
	}
	public Orders getOrder() {
		return order;
	}
	
	public void setOrder(Orders order) {
		this.order=order;
	}
	public Products getProduct() {
		return product;
	}
	
	public void setProduct(Products product) {
		this.product=product;
	}
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if (quantity > 0) {
			this.quantity = quantity;
		} else {
			try {
				throw new InvalidDataException();
			} catch (InvalidDataException ide) {
				System.out.println("Quantity must be a positive integer.");
			}
		}
	}
}
