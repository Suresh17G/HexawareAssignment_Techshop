package Collections;

import Entity.Inventory;
import dao.InventoryDao;

import java.util.HashMap;
import java.util.Map;

public class InventoryManagement {
	private static InventoryDao inventoryMethod=new InventoryDao();
    private static Map<Integer, Inventory> inventoryMap= new HashMap<>();

    public static void addProductToInventory(Inventory inventory) {
        inventoryMap.put(inventory.GetProduct().getProductID(), inventory);
    }

    public static void updateInventoryQuantity(int productID, int quantity) throws Exception {
        Inventory inventory = inventoryMap.get(productID);
        if (inventory != null) {
        	inventoryMethod.AddToInventory(quantity,inventory.getInventoryID());
        } else {
            throw new Exception("Product not found in inventory.");
        }
    }
    
    public static Inventory getInventoryByProductID(int productID) {
        return inventoryMap.get(productID);
    }
    
    public static void updateInventoryOnOrder(int productID, int quantity) throws Exception {
        Inventory inventory = inventoryMap.get(productID);
        if (inventory != null && inventory.GetQuantityInStock() >= quantity) {
        	inventoryMethod.RemoveFromInventory(quantity,inventory.getInventoryID());
        } else {
            throw new Exception("Insufficient stock for product ID: " + productID);
        }
    }

}
