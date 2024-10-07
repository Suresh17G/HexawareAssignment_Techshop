package Entity;

import Collections.ProductsList;

public class Products {
	private int productID;
	private String productName;
	private String description;
	private double price;
	private String category;

	public Products(int productID, String productName, String description, double price, Inventory inventory)
			throws Exception {
		this.productID = productID;
		this.productName = productName;
		this.description = description;
		this.price = price;
		ProductsList.addProduct(this);
	}

	public Products() {
		// TODO Auto-generated constructor stub
	}

	// Getters and Setters (with validation)
	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price >= 0) {
			this.price = price; // Ensure non-negative price
		} else {
			System.out.println("Price must be non-negative");
		}
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
