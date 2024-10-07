package Entity;

import java.util.Date;

import exception.InsufficientStockException;

public class Inventory {
	private int inventoryID;
	private Products product;
	private int quantityInStock;
	private Date lastStockUpdate;
	
	public Inventory(int inventoryID, Products product, int quantityInStock, Date
	lastStockUpdate) {
	this.inventoryID = inventoryID;
	this.product = product;
	this.quantityInStock = quantityInStock;
	this.lastStockUpdate = lastStockUpdate;
	}

    // Setters
	public void setInventoryID(int inventoryID) {
		this.inventoryID=inventoryID;
	}
	
	public void setProduct(Products product) {
		this.product=product;
	}
    public void setQuantityInStock(int quantityInStock) {
        if (quantityInStock < 0) {
        	System.out.println("Quantity in stock cannot be negative.");
        }
        this.quantityInStock = quantityInStock;
    }

    public void setLastStockUpdate(Date lastStockUpdate) {
        this.lastStockUpdate = lastStockUpdate;
    }
    // Getters
    
    public int getInventoryID() {
        return inventoryID;
    }
    
    public Date getLastStockUpdate() {
        return lastStockUpdate;
    }
    
    //Methods
	public Products GetProduct() {
	return this.product;
	}
	public int GetQuantityInStock() {
	return this.quantityInStock;
	}
}

