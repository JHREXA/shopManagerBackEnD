
package shop.ShopManager.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import shop.ShopManager.model.Product;
import shop.ShopManager.services.IProductService;


@RestController
public class ProductController {
    
    @Autowired
    private IProductService productService;
    
    @PostMapping("/products/create")
    public void saveProduct(@RequestBody Product newProduct){
        productService.saveProduct(newProduct);
    }
    
    @GetMapping("/products/get")
    @ResponseBody
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    
    @GetMapping("/products/getone/{productCode}")
    @ResponseBody
    public Product getProduct(@PathVariable Long productCode){
        return productService.getProduct(productCode);
    }
    
    @DeleteMapping("/products/delete/{productCode}")
    public void deleteProduct(@PathVariable Long productCode){
        productService.deleteProduct(productCode);
    }
    
    @PutMapping("/products/edit/{productCode}")
    public void editProduct(@PathVariable Long productCode, @RequestBody Product editedProduct){
        productService.editProduct(productCode, editedProduct);
    }
    
    @GetMapping("/products/outStock")
    public List<Product> getProductsOutOfStock(){
        return productService.getProductsOutStock();
    }
}
