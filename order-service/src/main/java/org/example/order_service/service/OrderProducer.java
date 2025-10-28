package org.example.order_service.service;

import lombok.RequiredArgsConstructor;
import org.example.order_service.event.OrderCreatedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderProducer {

    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    public void sendOrderEvent(OrderCreatedEvent event) {
        kafkaTemplate.send("order-topic", event);
        System.out.println("📦 Sent order event to Kafka: " + event);
    }
}
