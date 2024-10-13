
package shop.ShopManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.ShopManager.model.Client;

@Repository
public interface IClientRepository extends JpaRepository<Client,Long>{
    
}
