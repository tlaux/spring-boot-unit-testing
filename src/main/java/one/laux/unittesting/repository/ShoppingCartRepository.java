package one.laux.unittesting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import one.laux.unittesting.entity.ShoppingCartItem;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCartItem, Long> {

}
