package com.learning.cdc.debezium.db.kafka.impl.kafka;

import com.learning.cdc.debezium.db.kafka.impl.dto.ProductMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumer {

    @KafkaListener(topics = "product.public.product", groupId = "my-group_3")
    public void consume(ProductMessage productMessage) {
        log.info("Consumed message {}", productMessage);
        if(productMessage.getOperation().equals("c")) {
            log.info("New product received with id {}", productMessage.getAfter().getId());
        }

        if(productMessage.getOperation().equals("u")) {
            log.info("Product with id {} received was updated", productMessage.getAfter().getId());
        }

        if(productMessage.getOperation().equals("d")) {
            log.info("Product received with id {} was deleted", productMessage.getAfter().getId());
        }
    }
}
