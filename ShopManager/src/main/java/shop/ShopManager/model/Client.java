
package shop.ShopManager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Client {
    
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Long clientId;
   private String name;
   private String surname;
   private String idNumber;

    public Client() {
    }

    public Client(Long clientId, String name, String surname, String idNumber) {
        this.clientId = clientId;
        this.name = name;
        this.surname = surname;
        this.idNumber = idNumber;
    }
   
   
}
