package com.reef.demo_store.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

@Configuration
public class RabbitMQConfiguration {
    @Value("${spring.rabbitmq.durable: true}")
    private boolean durable;

    @Value("${spring.rabbitmq.send-order-queue: market.orders}")
    private String orderQueueName;

    @Bean
    public Queue orderQueue() {
        return new Queue(orderQueueName, durable);
    }
}
