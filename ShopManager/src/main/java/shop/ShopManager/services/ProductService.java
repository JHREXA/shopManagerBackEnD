
package shop.ShopManager.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.ShopManager.model.Product;
import shop.ShopManager.repository.IProductRepository;

@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductRepository productRepo;
    
    @Override
    public void saveProduct(Product newProduct) {
        productRepo.save(newProduct);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProduct(Long productCode) {
        return productRepo.findById(productCode).orElse(null);
    }

    @Override
    public void deleteProduct(Long productCode) {
        productRepo.deleteById(productCode);
    }


    @Override
    public void editProduct(Long productCode, Product editedProduct) {
        
        Product existingProduct = productRepo.findById(productCode).orElse(null);
        
        if(existingProduct != null){
            existingProduct.setName(editedProduct.getName());
            existingProduct.setBrand(editedProduct.getBrand());
            existingProduct.setPrice(editedProduct.getPrice());
            existingProduct.setQuantity(editedProduct.getQuantity());
            
            productRepo.save(existingProduct);
        }
    }

    @Override
    public List<Product> getProductsOutStock() {

        List<Product> productList = productRepo.findAll();
        List<Product> productOutStock = new ArrayList<>();
        
        for(Product product: productList){
            if(product.getStock() < 5){
                productOutStock.add(product);
            }
        }
        return productOutStock;
    }
    
}
