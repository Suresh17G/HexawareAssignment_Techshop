package main;

import java.util.Scanner;
import exception.AuthorizationException;

public class MainModule {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to techshop");
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = sc.next();

        System.out.print("Enter password: ");
        String password = sc.next();

        try {
            if (username.equals("suresh") && password.equals("1234")) {
                boolean mainMenu = true;
                
                while (mainMenu) {
                    System.out.println("\nEnter your choice");
                    System.out.println("1. Customer module");
                    System.out.println("2. Product module");
                    System.out.println("3. Orders module");
                    System.out.println("4. OrderDetails module");
                    System.out.println("5. Inventory module");
                    System.out.println("6. Exit");
                    int choice1 = sc.nextInt();
                    
                    switch (choice1) {
                        case 1: {
                            CustomerMain customerInterface = new CustomerMain();
                            boolean customerMenu = true;
                            while (customerMenu) {
                                System.out.println("\nEnter your choice");
                                System.out.println("1. Customer Registration");
                                System.out.println("2. Customer Details");
                                System.out.println("3. Update Customer information");
                                System.out.println("4. Number of orders by customers");
                                System.out.println("5. Exit");
                                int choice2 = sc.nextInt();
                                
                                switch (choice2) {
                                    case 1: customerInterface.addCustomer(); break;
                                    case 2: customerInterface.viewCustomer(); break;
                                    case 3: customerInterface.custDetailupd(); break;
                                    case 4: customerInterface.numOfOrder(); break;
                                    case 5: customerMenu = false; break;
                                    default: System.out.println("Choose a proper choice"); break;
                                }
                            }
                        }
                        break;
                        
                        case 2: {
                            ProductMain productsInterface = new ProductMain();
                            boolean productMenu = true;
                            while (productMenu) {
                                System.out.println("\nEnter your choice");
                                System.out.println("1. Product Registration");
                                System.out.println("2. Product Details");
                                System.out.println("3. Product price update");
                                System.out.println("4. Is Product available");
                                System.out.println("5. Search product");
                                System.out.println("6. Exit");
                                int choice3 = sc.nextInt();
                                
                                switch (choice3) {
                                    case 1: productsInterface.addProduct(); break;
                                    case 2: productsInterface.viewProduct(); break;
                                    case 3: productsInterface.updateProduct(); break;
                                    case 4: productsInterface.available(); break;
                                    case 5: productsInterface.searchProduct(); break;
                                    case 6: productMenu = false; break;
                                    default: System.out.println("Choose a proper choice"); break;
                                }
                            }
                        }
                        break;
                        
                        case 3: {
                            OrderMain ordersInterface = new OrderMain();
                            boolean orderMenu = true;
                            while (orderMenu) {
                                System.out.println("\nEnter your choice");
                                System.out.println("1. Calculate the total amount of the order.");
                                System.out.println("2. Get Order Details");
                                System.out.println("3. Check Order Status");
                                System.out.println("4. Update Order Status");
                                System.out.println("5. Cancel Order");
                                System.out.println("6. Exit");
                                int choice4 = sc.nextInt();
                                
                                switch (choice4) {
                                    case 1: ordersInterface.CalculateTotalAmount(); break;
                                    case 2: ordersInterface.GetOrderDetails(); break;
                                    case 3: ordersInterface.orderstatus(); break;
                                    case 4: ordersInterface.updateOrderStatus(); break;
                                    case 5: ordersInterface.cancelOrder(); break;
                                    case 6: orderMenu = false; break;
                                    default: System.out.println("Choose a proper choice"); break;
                                }
                            }
                        }
                        break;
                        
                        case 4: {
                            OrderDetailsMain orderdetailsInterface = new OrderDetailsMain();
                            boolean orderDetailsMenu = true;
                            while (orderDetailsMenu) {
                                System.out.println("\nEnter your choice");
                                System.out.println("1. Calculate the subtotal for this order detail");
                                System.out.println("2. Get Order Detail Info");
                                System.out.println("3. Update Quantity");
                                System.out.println("4. Add Discount");
                                System.out.println("5. Exit");
                                int choice5 = sc.nextInt();
                                
                                switch (choice5) {
                                    case 1: orderdetailsInterface.CalculateSubtotal(); break;
                                    case 2: orderdetailsInterface.getOrderDetailInfo(); break;
                                    case 3: orderdetailsInterface.updateQuantity(); break;
                                    case 4: orderdetailsInterface.addDiscount(); break;
                                    case 5: orderDetailsMenu = false; break;
                                    default: System.out.println("Choose a proper choice"); break;
                                }
                            }
                        }
                        break;
                        
                        case 5: {
                            InventoryMain inventoryInterface = new InventoryMain();
                            boolean inventoryMenu = true;
                            while (inventoryMenu) {
                                System.out.println("\nEnter your choice");
                                System.out.println("1. Get Quantity In Stock");
                                System.out.println("2. Update Inventory");
                                System.out.println("3. Is Product Available");
                                System.out.println("4. Get Inventory Value");
                                System.out.println("5. Get Product");
                                System.out.println("6. Add specific quantity of a Product");
                                System.out.println("7. Remove specific quantity of a Product");
                                System.out.println("8. List Low Stock Products");
                                System.out.println("9. List Out Stock Products");
                                System.out.println("10. List All Products");
                                System.out.println("11. Exit");
                                int choice6 = sc.nextInt();
                                
                                switch (choice6) {
                                    case 1: inventoryInterface.GetQuantityInStock(); break;
                                    case 2: inventoryInterface.updateInventory(); break;
                                    case 3: inventoryInterface.isProductsAvailable(); break;
                                    case 4: inventoryInterface.getInventoryValue(); break;
                                    case 5: inventoryInterface.getProduct(); break;
                                    case 6: inventoryInterface.addInventory(); break;
                                    case 7: inventoryInterface.removeInventory(); break;
                                    case 8: inventoryInterface.listLowStockProducts(); break;
                                    case 9: inventoryInterface.listOutofStockProducts(); break;
                                    case 10: inventoryInterface.listAllProducts(); break;
                                    case 11: inventoryMenu = false; break;
                                    default: System.out.println("Choose a proper choice"); break;
                                }
                            }
                        }
                        break;
                        
                        case 6: {
                            mainMenu = false;
                            System.out.println("Thank you for using techshop!");
                        }
                        break;
                        
                        default: {
                            System.out.println("Choose a proper choice");
                        }
                    }
                }
                
            } else {
                throw new AuthorizationException();
            }
        } catch (AuthorizationException e) {
            System.out.println(e);
        } finally {
            sc.close();
        }
    }
}
