
package shop.ShopManager.services;

import java.util.List;
import shop.ShopManager.model.Product;


public interface IProductService {
    // Method for creating a new product:
    public void saveProduct(Product newProduct);
    
    // Method for getting all the products:
    public List<Product> getAllProducts();
    
    // Method for getting one product through its id:
    public Product getProduct(Long productCode);
    
    // Method for deleting one product:
    public void deleteProduct(Long productCode);
    
    // Method for editing one product:
    public void editProduct(Long productCode, Product editedProduct);
    
    // Method for getting all the products out of stock (quantity < 5):
    public List<Product> getProductsOutStock();
    
}
