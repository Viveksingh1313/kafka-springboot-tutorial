package goals.learning.kafkatutorial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
  private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

  @KafkaListener(topics = "kafka-topic", containerFactory = "kafkaListenerContainerFactory")
  void listener(MyMessageEvent event) {
    log.info("Received message at: {} for the car : {} ", event.getTimestamp()
                                  .toString(), event.getVal());
  }

}
