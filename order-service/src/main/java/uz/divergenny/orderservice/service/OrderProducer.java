package uz.divergenny.orderservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import uz.divergenny.orderservice.models.Order;

@Service
@Slf4j
public class OrderProducer {
    private final KafkaTemplate<String, Order> kafkaTemplate;

    public OrderProducer(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrder(Order order) {
        kafkaTemplate.send("orders", order.getOrderId(), order);
        log.info("Отправлен заказ: " + order);
    }
}
