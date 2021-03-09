package i.ub.antonio.goncalves.demo.repositories;

import i.ub.antonio.goncalves.demo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //TODO: Need to implement others
    //List<Product> findByOrderModel(OrderModel orderModel);

}
