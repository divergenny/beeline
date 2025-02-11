package uz.divergenny.orderservice.controllers;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.divergenny.orderservice.models.Order;
import uz.divergenny.orderservice.service.OrderProducer;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping
    public String createOrder(@RequestBody @Valid Order order) {
        orderProducer.sendOrder(order);
        return "Заказ отправлен!";
    }
}
