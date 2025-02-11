package uz.divergenny.orderservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.divergenny.orderservice.models.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, String> {

}
