package iHubAntonioGoncalves.Demo.repositories;

import iHubAntonioGoncalves.Demo.models.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderModel, Long> {
}
