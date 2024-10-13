
package shop.ShopManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.ShopManager.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {
    
}
