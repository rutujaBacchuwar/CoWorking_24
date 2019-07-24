package com.stackroute.bookingservice.config;

import com.stackroute.kafka.domain.Booking;
import com.stackroute.kafka.domain.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProducerConfiguration {

    @Value("${kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<String, Object>();
        // list of host:port pairs used for establishing the initial connections to the Kakfa cluster
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                JsonSerializer.class);

        return props;
    }

    @Bean
    public ProducerFactory<String, Booking> producerFactory() {
        return new DefaultKafkaProducerFactory<String, Booking>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<String, Booking> kafkaTemplate() {

        return new KafkaTemplate<String, Booking>(producerFactory());
    }

    @Bean
    public Producer producer() {
        return new Producer();
    }

    @Bean
    public Booking booking() {
        return new Booking();
    }


    @Bean
    public ProducerFactory<String, Booking> producerFactory1() {
        return new DefaultKafkaProducerFactory<String, Booking>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<String, Booking> kafkaTemplate1() {

        return new KafkaTemplate<String, Booking>(producerFactory1());
    }

}


