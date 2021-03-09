package i.ub.antonio.goncalves.demo.repositories;

import i.ub.antonio.goncalves.demo.models.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderModel, Long> {
    List<OrderModel> findByDeleted(Boolean isDeleted);

}
