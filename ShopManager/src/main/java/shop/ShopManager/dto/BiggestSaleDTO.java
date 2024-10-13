package shop.ShopManager.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BiggestSaleDTO {
    private Long saleCode;
    private Double total;
    private String clientName;
    private String clientSurname;

    public BiggestSaleDTO() {
    }

    public BiggestSaleDTO(Long saleCode, Double total, String clientName, String clientSurname) {
        this.saleCode = saleCode;
        this.total = total;
        this.clientName = clientName;
        this.clientSurname = clientSurname;
    }
 
    
}
