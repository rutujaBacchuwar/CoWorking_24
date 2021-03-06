package com.stackroute.userservice.configuration;

import com.stackroute.kafka.domain.Booking;
import com.stackroute.kafka.domain.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class ConsumerConfiguration {
    private static String BOOTSTRAP_SERVERS_CONFIG;
    private static String KEY_DESERIALIZER_CLASS_CONFIG;
    private static String VALUE_DESERIALIZER_CLASS_CONFIG;
    private static String GROUP_ID_CONFIG;

    @Value("${kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean

    public Map<String, Object> consumerConfigs() {
        JsonDeserializer<Booking> deserializer = new JsonDeserializer<Booking>(Booking.class);
        deserializer.setRemoveTypeHeaders(false);
        deserializer.addTrustedPackages("*");
        deserializer.setUseTypeMapperForKey(true);


        Map<String, Object> props = new HashMap<String, Object>();
        // list of host:port pairs used for establishing the initial connections to the Kafka cluster
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapServers);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                JsonDeserializer.class);
        // allows a pool of processes to divide the work of consuming and processing records
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "helloworld");


        return props;
    }


    @Bean
    public ConsumerFactory<String, Booking> consumerFactory() {
        return new DefaultKafkaConsumerFactory<String,Booking>(consumerConfigs(), new StringDeserializer(), new JsonDeserializer<Booking>(Booking.class));
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, Booking>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Booking> factory =
                new ConcurrentKafkaListenerContainerFactory<String, Booking>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    @Bean
    public Consumer consumespace() {

        return new Consumer();
    }

    @Bean
    public Booking consum() {
        return new Booking();
    }

}
