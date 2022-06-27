package goals.learning.kafkatutorial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
  private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

  @KafkaListener(topics = "kafka-topic-smartcar-2", containerFactory = "kafkaListenerContainerFactory")
  void listenerSmartcar(MyMessageEvent event) {
    log.info("Smartcar message received at: {} for the car : {} Counter : {}", event.getTimestamp(), event.getVal(), event.getCounter());
  }


  @KafkaListener(topics = "kafka-topic-manual-2", containerFactory = "kafkaListenerContainerFactory")
  void listenerManual(MyMessageEvent event) {
    log.info("Manual message received at: {} for the car : {} Counter : {}", event.getTimestamp(), event.getVal(), event.getCounter());
  }

}
