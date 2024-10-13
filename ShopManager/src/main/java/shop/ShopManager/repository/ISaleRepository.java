
package shop.ShopManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.ShopManager.model.Sale;

@Repository
public interface ISaleRepository extends JpaRepository<Sale,Long>{
    
}
