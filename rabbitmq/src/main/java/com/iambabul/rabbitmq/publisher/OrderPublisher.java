package com.iambabul.rabbitmq.publisher;

import com.iambabul.rabbitmq.Constants;
import com.iambabul.rabbitmq.dto.Order;
import com.iambabul.rabbitmq.dto.OrderStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderPublisher {
    private final RabbitTemplate rabbitTemplate;

    @PostMapping("/{restaurantName}")
    public String bookOrder(@RequestBody Order order, @PathVariable String restaurantName) {
        try {
            order.setId(UUID.randomUUID().toString());
            String message = "Order placed successfully in ".concat(restaurantName);
            //restaurant service
            //payment service
            OrderStatus status = new OrderStatus(Constants.STATUS_PROCESS, message, order);
            rabbitTemplate.convertAndSend(Constants.EXCHANGE, Constants.ROUTING_KEY, status);
            return message;
        }
        catch (Exception ex) {
            log.error(ex.getMessage());
            throw ex;
        }
    }
}
