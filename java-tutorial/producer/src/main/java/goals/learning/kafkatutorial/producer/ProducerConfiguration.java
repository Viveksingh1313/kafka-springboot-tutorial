package goals.learning.kafkatutorial.producer;

import java.util.HashMap;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class ProducerConfiguration {

  @Bean
  public ProducerFactory<String, MyMessageEvent> producerFactory() {
    var props = new HashMap<String, Object>();
    // where your kafka runs
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    // serializing key
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    // serializing value
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
    props.put(ConsumerConfig.GROUP_ID_CONFIG, "kafkaTutorial-1");
    return new DefaultKafkaProducerFactory<>(props);
  }

  @Bean
  public KafkaTemplate<String, MyMessageEvent> kafkaTemplate() {
    return new KafkaTemplate<>(producerFactory());
  }


  // creating topics
  // remember KafkaAdmin is responsible for creating these topics
  // we don't do any configuration. We just provide names for our topics and springboot
  // automatically configures it.
  // check this for more info https://reflectoring.io/spring-boot-kafka/ush
  @Bean
  public NewTopic timestampTopicSmartcar() {
    return TopicBuilder.name("kafka-topic-smartcar-2")
                       .build();
  }


  @Bean
  public NewTopic timestampTopicManual() {
    return TopicBuilder.name("kafka-topic-manual-2")
            .build();
  }

}
