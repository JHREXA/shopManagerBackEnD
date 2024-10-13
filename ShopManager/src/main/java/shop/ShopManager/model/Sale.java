
package shop.ShopManager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Sale {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long saleCode;
    private LocalDate date;
    private Double total;
    @ManyToMany
    @JoinTable(
            name = "sale_product",
            joinColumns = @JoinColumn(name = "saleCode"),
            inverseJoinColumns = @JoinColumn(name = "productCode")
    )
    private List<Product> productList;
    @OneToOne
    @JoinColumn(name = "clientId",
                referencedColumnName = "clientId")
    private Client client;

    public Sale() {
    }

    public Sale(Long saleCode, LocalDate date, Double total, List<Product> productList, Client client) {
        this.saleCode = saleCode;
        this.date = date;
        this.total = total;
        this.productList = productList;
        this.client = client;
    }
    
    
}
