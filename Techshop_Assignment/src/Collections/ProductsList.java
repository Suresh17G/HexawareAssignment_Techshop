package Collections;
import java.util.List;

import Entity.Products;

import java.util.ArrayList;

public class ProductsList {
	private static List<Products> productList = new ArrayList<>();
	
    public static void addProduct(Products product) throws Exception {
        for (Products p : productList) {
            if (p.getProductID() == product.getProductID()) {
                throw new Exception("Duplicate product ID");
            }
        }
        productList.add(product);
    }

    public static void updateProduct(Products updatedProduct) throws Exception {
        for (Products p : productList) {
            if (p.getProductID() == updatedProduct.getProductID()) {
                // Update product details
            	p=updatedProduct;
            	
                return;
            }
        }
        throw new Exception("Product not found");
    }

    public static void removeProduct(int productID) throws Exception {
        for (Products p : productList) {
            if (p.getProductID() == productID) {
                productList.remove(p);
                return;
            }
        }
        throw new Exception("Product not found");
    }

    public static List<Products> getAllProducts() {
        return productList;
    }

 // Search for products by name
    public List<Products> searchProductsByName(String name) {
        List<Products> foundProducts = new ArrayList<>();
        for (Products product : productList) {
            if (product.getProductName().toLowerCase().contains(name.toLowerCase())) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

}
