
package shop.ShopManager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long productCode;
    private String name;
    private String brand;
    private Double price;
    private Double quantity;
    private Double stock;
    @ManyToMany(mappedBy = "productList")
    @JsonIgnore
    private List<Sale> saleList;

    public Product() {
    }

    public Product(Long productCode, String name, String brand, Double price, Double quantity, Double stock, List<Sale> saleList) {
        this.productCode = productCode;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.stock = stock;
        this.saleList = saleList;
    }

    
    
    
    
}
