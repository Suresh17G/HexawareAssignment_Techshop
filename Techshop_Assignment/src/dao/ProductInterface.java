package dao;

import java.util.List;
import Entity.Products;
import exception.InvalidDataException;

public interface ProductInterface {
    void insertProduct(Products product) throws Exception ;
    void getProductDetails(int productID) throws ClassNotFoundException;
    List<Products> getProductList();
    void updateProductInfo(int productId, int newPrice,String newDescription) throws InvalidDataException, ClassNotFoundException;
    void isProductInStock(int productId) throws InvalidDataException, ClassNotFoundException ;
    List<Products> searchProducts(String keyword) throws ClassNotFoundException;
    void closeResources();
}
