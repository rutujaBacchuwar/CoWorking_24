package com.stackroute.userservice.configuration;
import java.util.HashMap;
import java.util.Map;
import com.stackroute.kafka.domain.Producer;
import com.stackroute.kafka.domain.Space;
import com.stackroute.kafka.domain.User;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class ProducerConfiguration {
    @Value("${kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<String,Object>();
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
    public ProducerFactory<String, User> producerFactory() {
        return new DefaultKafkaProducerFactory<String,User>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<String, User> kafkaTemplate() {

        return new KafkaTemplate<String,User>(producerFactory());
    }

    @Bean
    public Producer producer() {
        return new Producer();
    }




    @Bean
    public ProducerFactory<String, Space> producerFactory1() {
        return new DefaultKafkaProducerFactory<String,Space>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<String, Space> kafkaTemplate1() {

        return new KafkaTemplate<String,Space>(producerFactory1());
    }

    @Bean
    public ProducerFactory<String, Space> producerFactory2() {
        return new DefaultKafkaProducerFactory<String,Space>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<String, Space> kafkaTemplate2() {

        return new KafkaTemplate<String,Space>(producerFactory2());
    }


    @Bean
    public ProducerFactory<String, Space> producerFactory3() {
        return new DefaultKafkaProducerFactory<String,Space>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<String, Space> kafkaTemplate3() {

        return new KafkaTemplate<String,Space>(producerFactory3());
    }

    @Bean
    public ProducerFactory<String, Space> producerFactory4() {
        return new DefaultKafkaProducerFactory<String,Space>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<String, Space> kafkaTemplate4() {

        return new KafkaTemplate<String,Space>(producerFactory4());
    }

    @Bean
    public ProducerFactory<String, Space> producerFactory5() {
        return new DefaultKafkaProducerFactory<String,Space>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<String, Space> kafkaTemplate5() {

        return new KafkaTemplate<String,Space>(producerFactory5());
    }

    @Bean
    public ProducerFactory<String, Space> producerFactory6() {
        return new DefaultKafkaProducerFactory<String,Space>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<String, Space> kafkaTemplate6() {

        return new KafkaTemplate<String,Space>(producerFactory6());
    }
}