
package shop.ShopManager.controller;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import shop.ShopManager.dto.BiggestSaleDTO;
import shop.ShopManager.model.Product;
import shop.ShopManager.model.Sale;
import shop.ShopManager.services.ISaleService;

@RestController
public class SaleController {
    
    @Autowired
    private ISaleService saleService;
    
    @PostMapping("/sales/create")
    public void saveSale(@RequestBody Sale newSale){
        saleService.saveSale(newSale);
    }
    
    @GetMapping("/sales/get")
    @ResponseBody
    public List<Sale> getAllSales(){
        return saleService.getAllSales();
    }
    
    @GetMapping("/sales/getone/{saleCode}")
    @ResponseBody
    public Sale getSale(@PathVariable Long saleCode){
        return saleService.getSale(saleCode);
    }
    
    @DeleteMapping("/sales/delete/{saleCode}")
    public void deleteSale(@PathVariable Long saleCode){
        saleService.deleteSale(saleCode);
    }
    
    @PutMapping("/sales/edit/{saleCode}")
    public void editSale(@PathVariable Long saleCode,
                         @RequestBody Sale editedSale){
        saleService.editSale(saleCode, editedSale);
    }
    
    @GetMapping("/sales/products")
    @ResponseBody
    public List<Product> getProductSale(@RequestParam Long saleCode){
        Sale sale = saleService.getSale(saleCode);
        
        if(sale != null){
            return sale.getProductList();
        }
        
        return Collections.emptyList();
    }
    
    @GetMapping("/sales/{date}")
    public String getTotalOfDay(@PathVariable LocalDate date){
        return saleService.getSalesDay(date);
    }
    
    @GetMapping("/sales/biggestSale")
    @ResponseBody
    public BiggestSaleDTO getBiggestSale(){
        return saleService.getBiggestSale();
    }
}
