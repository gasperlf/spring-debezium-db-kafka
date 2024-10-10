package com.learning.cdc.debezium.db.kafka.impl.kafka;

import com.learning.cdc.debezium.db.kafka.impl.deserializer.ProductMessageDeserializer;
import com.learning.cdc.debezium.db.kafka.impl.dto.ProductMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {


}
