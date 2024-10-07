package main;

import java.util.Scanner;
import dao.InventoryDao;
import Entity.Inventory;
import exception.InvalidDataException;

public class InventoryMain{
    Inventory inventory; 
    InventoryDao inventoryDao = new InventoryDao(); 
    Scanner sc = new Scanner(System.in);

    public void GetQuantityInStock() throws ClassNotFoundException {
        System.out.println("Enter ProductID: ");
        int productID = sc.nextInt();
        System.out.println("Quantity in Stock: " + inventoryDao.getQuantityInStock(productID));
    }

    public void updateInventory() {
        System.out.println("Enter InventoryID to update inventory stock :");
        int inventoryid = sc.nextInt();
        System.out.println("Enter new inventory stock :");
        int quantityinstock = sc.nextInt();
        try {
            inventoryDao.updateStockQuantity(quantityinstock, inventoryid);
        } catch (InvalidDataException | ClassNotFoundException e) {
        	System.out.println(e.getMessage());
        }
    }
    public void addInventory() {
        System.out.println("Enter InventoryID :");
        int inventoryid = sc.nextInt();
        System.out.println("Enter inventory stock to add :");
        int quantityinstock = sc.nextInt();
        try {
            inventoryDao.AddToInventory(quantityinstock, inventoryid);
        } catch (InvalidDataException | ClassNotFoundException e) {
        	System.out.println(e.getMessage());
        }
    }
    public void removeInventory() {
        System.out.println("Enter InventoryID to update inventory stock :");
        int inventoryid = sc.nextInt();
        System.out.println("Enter inventory stock to remove:");
        int quantityinstock = sc.nextInt();
        try {
            inventoryDao.RemoveFromInventory(quantityinstock, inventoryid);
        } catch (InvalidDataException | ClassNotFoundException e) {
        	System.out.println(e.getMessage());
        }
    }
    public void isProductsAvailable() {
        System.out.println("Enter ProductID: ");
        int productID = sc.nextInt();

        System.out.println("Enter Quantity to Check: ");
        int quantityToCheck = sc.nextInt();

        boolean available=false;
		try {
			available = inventoryDao.isProductAvailable(productID, quantityToCheck);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

        displayAvailabilityResult(available);
    }

    private void displayAvailabilityResult(boolean available) {
        if (available) {
            System.out.println("Product is available in the specified quantity.");
        } else {
            System.out.println("Product is not available in the specified quantity.");
        }
    }

	public void getInventoryValue() {
		 double inventoryValue=0;
		try {
			inventoryValue = inventoryDao.getInventoryValue();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	     System.out.println("Total Inventory Value: $" + inventoryValue);
		
	}

	
	public void getProduct() {
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter Inventory ID: ");
        int inventoryID = sc.nextInt();
        try {
			inventoryDao.getProduct(inventoryID);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
        
		
	}

	
	public void listLowStockProducts() {
		System.out.println("Enter the threshold value: ");
        int threshold = sc.nextInt();
        try {
			inventoryDao.listLowStockProducts(threshold);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	public void listOutofStockProducts() {
        try {
			inventoryDao.listOutOfStockProducts();;
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	public void listAllProducts() {
        try {
			inventoryDao.listAllProducts();;
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
