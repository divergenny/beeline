package uz.divergenny.orderservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import uz.divergenny.orderservice.models.Order;
import uz.divergenny.orderservice.models.OrderEntity;
import uz.divergenny.orderservice.repo.OrderRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderConsumer {

    private final OrderRepository orderRepository;

    @Async("orderExecutor")
    @KafkaListener(topics = "orders", groupId = "order-processing-group")
    public void processOrder(Order order) {
        log.info("Обрабатываем заказ: " + order);
        try {
            OrderEntity orderEntity = new OrderEntity(order.getOrderId(), order.getCustomerName(), order.getAmount());
            orderRepository.save(orderEntity);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Ошибка обработки заказа: " + order.getOrderId());
        }
        log.info("Заказ обработан: " + order.getOrderId());
    }
}
