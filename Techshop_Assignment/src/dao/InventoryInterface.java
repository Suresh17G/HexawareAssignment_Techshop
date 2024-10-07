package dao;

import exception.InvalidDataException;

public interface InventoryInterface {

	void getProduct(int inventoryID) throws ClassNotFoundException;
    int getQuantityInStock(int productID) throws ClassNotFoundException;
    void AddToInventory(int quantityinstock, int inventoryid) throws InvalidDataException, ClassNotFoundException;
    void RemoveFromInventory(int quantityinstock, int inventoryid) throws InvalidDataException, ClassNotFoundException;
    void updateStockQuantity(int quantityinstock, int inventoryid) throws InvalidDataException, ClassNotFoundException;
    boolean isProductAvailable(int productID, int quantityToCheck) throws ClassNotFoundException;
	double getInventoryValue() throws ClassNotFoundException;
	void listLowStockProducts(int threshold) throws ClassNotFoundException;
	void listOutOfStockProducts() throws ClassNotFoundException;	
	void listAllProducts() throws ClassNotFoundException;
    void closeResources();
}
