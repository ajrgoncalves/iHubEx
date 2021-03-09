package i.ub.antonio.goncalves.demo.repositories;

import i.ub.antonio.goncalves.demo.models.OrderModel;
import i.ub.antonio.goncalves.demo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //TODO: Need to implement others
    //List<Product> findByOrderModel(OrderModel orderModel);
    List<Product> findByDeleted(Boolean isDeleted);

}
