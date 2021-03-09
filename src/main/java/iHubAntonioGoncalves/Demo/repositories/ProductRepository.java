package iHubAntonioGoncalves.Demo.repositories;

import iHubAntonioGoncalves.Demo.models.OrderModel;
import iHubAntonioGoncalves.Demo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //TODO: Need to implement others
    //List<Product> findByOrderModel(OrderModel orderModel);

}
