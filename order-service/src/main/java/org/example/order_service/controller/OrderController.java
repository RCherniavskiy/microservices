package org.example.order_service.controller;

import lombok.RequiredArgsConstructor;
import org.example.order_service.event.OrderCreatedEvent;
import org.example.order_service.service.OrderProducer;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderProducer orderProducer;

    // GET-метод для теста через браузер
    @GetMapping
    public String createOrder(@RequestParam String product, @RequestParam Double price) {
        String orderId = UUID.randomUUID().toString();
        OrderCreatedEvent event = new OrderCreatedEvent(orderId, product, price);
        orderProducer.sendOrderEvent(event);
        return "✅ Order created with ID: " + orderId;
    }
}
