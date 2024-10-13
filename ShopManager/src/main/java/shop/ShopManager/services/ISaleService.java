
package shop.ShopManager.services;

import java.time.LocalDate;
import java.util.List;
import shop.ShopManager.dto.BiggestSaleDTO;
import shop.ShopManager.model.Product;
import shop.ShopManager.model.Sale;


public interface ISaleService {
    
    // Method for creating a sale:
    public void saveSale(Sale newSale);
    
    // Method for getting all the sales:
    public List<Sale> getAllSales();
    
    // Method for getting one sale:
    public Sale getSale(Long saleCode);
    
    // Method for deleting a sale:
    public void deleteSale(Long saleCode);
    
    // Method for editing a sale:
    public void editSale(Long saleCode, Sale editedSale);
    
    // Method for getting the products of a sale:
    public List<Product> getProductSale(Long saleCode);
    
    // Method for getting the sales of a day:
    public String getSalesDay(LocalDate date);
    
    // Method for getting the biggest sale:
    public BiggestSaleDTO getBiggestSale();
}
