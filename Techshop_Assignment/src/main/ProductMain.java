package main;

import java.util.Scanner;
import dao.ProductDao;
import Entity.Products;
import exception.InvalidDataException;

public class ProductMain{
    Products product;
    Scanner sc = new Scanner(System.in);
    ProductDao productDao = new ProductDao();

    public void addProduct() throws Exception {
        product = new Products();

        System.out.println("Enter Product ID:");
        int productId = sc.nextInt();
        product.setProductID(productId);

        System.out.println("Enter Product Name:");
        String productName = sc.next();
        product.setProductName(productName);

        System.out.println("Enter Description:");
        String description = sc.next();
        product.setDescription(description);

        System.out.println("Enter Price:");
        int price = sc.nextInt();
        product.setPrice(price);

        System.out.println("Enter Category:");
        String category = sc.next();
        product.setCategory(category);

        try {
            productDao.insertProduct(product);
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }

        System.out.println("Product added successfully !!!");
    }

    public void viewProduct() throws ClassNotFoundException {
    	System.out.println("Enter Product ID:");
        int productId = sc.nextInt();
        productDao.getProductDetails(productId);
    }

    public void updateProduct() throws ClassNotFoundException {
        System.out.println("Enter Product ID to update price:");
        int productId = sc.nextInt();

        System.out.println("Enter the new Price:");
        int newPrice = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter new Description:");
        String newDescription= sc.nextLine();
        // You should call the method to update the price of the product in the database
        try {
            productDao.updateProductInfo(productId, newPrice,newDescription);
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }
    }

    public void available() throws ClassNotFoundException, InvalidDataException {
        System.out.println("Enter Product ID :");
        int productId = sc.nextInt();
        productDao.isProductInStock(productId);
    }

    public void searchProduct() throws ClassNotFoundException, InvalidDataException {
        System.out.println("Enter Product name or category :");
        String searchKey = sc.nextLine();
        productDao.searchProducts(searchKey);
    }
}
