
package shop.ShopManager.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.ShopManager.dto.BiggestSaleDTO;
import shop.ShopManager.model.Product;
import shop.ShopManager.model.Sale;
import shop.ShopManager.repository.ISaleRepository;

@Service
public class SaleService implements ISaleService{

    @Autowired
    private ISaleRepository saleRepo;
    
    @Override
    public void saveSale(Sale newSale) {
        saleRepo.save(newSale);
    }

    @Override
    public List<Sale> getAllSales() {
        return saleRepo.findAll();
    }

    @Override
    public Sale getSale(Long saleCode) {
        return saleRepo.findById(saleCode).orElse(null);
    }

    @Override
    public void deleteSale(Long saleCode) {
        saleRepo.deleteById(saleCode);
    }

    @Override
    public void editSale(Long saleCode, Sale editedSale) {
        Sale existingSale = this.getSale(saleCode);
        
        if(existingSale != null){
            existingSale.setDate(editedSale.getDate());
            existingSale.setProductList(editedSale.getProductList());
            existingSale.setClient(editedSale.getClient());
            
            double total = 0.0;
            
            for(Product product: existingSale.getProductList()){
                total += product.getPrice() * product.getQuantity();
                
                
                product.setStock(product.getStock() - product.getQuantity()); 
                if(product.getStock() <= 0){
                    product.setStock(0.0);
                }
                
            }
            existingSale.setTotal(total);
            
            this.saveSale(existingSale);
        }
    } 

    @Override
    public List<Product> getProductSale(Long saleCode) {
        Sale sale = saleRepo.findById(saleCode).orElse(null);
        
        if (sale != null){
            return sale.getProductList();
        }
        
        return Collections.emptyList();
        
    }

    @Override
    public String getSalesDay(LocalDate date) {
        List<Sale> sales = this.getAllSales();
        List<Sale> salesDay = new ArrayList<>();
        
        for(Sale sale: sales){
            if(sale.getDate().equals(date)){
                salesDay.add(sale);
            }
        }
        
       double total = 0.0;
       
       for(Sale sale: salesDay){
           total += sale.getTotal();
       }
       
       return "The total amount of the day is " + total + 
               " and the quantity of sales is " + salesDay.size();
    }

    @Override
    public BiggestSaleDTO getBiggestSale() {
        List<Sale> saleList = this.getAllSales();
        
         Sale biggestSale = saleList.stream()
        .max(Comparator.comparingDouble(Sale::getTotal))
        .orElse(null); 
        
        
    BiggestSaleDTO biggestSaleDTO = new BiggestSaleDTO();

    if (biggestSale != null) { 
        biggestSaleDTO.setSaleCode(biggestSale.getSaleCode());
        biggestSaleDTO.setTotal(biggestSale.getTotal());
        biggestSaleDTO.setClientName(biggestSale.getClient().getName());
        biggestSaleDTO.setClientSurname(biggestSale.getClient().getSurname());
    }

    return biggestSaleDTO;
    }
}
