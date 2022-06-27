package goals.learning.kafkatutorial.producer;

import java.time.ZonedDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {
  private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);

  @Autowired
  private KafkaTemplate<String, MyMessageEvent> kafkaTemplate;

  @Scheduled(fixedRate = 5000)
  public void reportCurrentTimeAndSmartcar() {
    var event = new MyMessageEvent(ZonedDateTime.now(), "Smartcar Azuga");
    kafkaTemplate.send("kafka-topic-smartcar", event);
    log.info("Sent smartcar value :{} at time : {}", event.getVal(), event.getTimestamp().toString());
  }


  @Scheduled(fixedRate = 5000)
  public void reportCurrentTimeAndSmartcar() {
    var event = new MyMessageEvent(ZonedDateTime.now(), "Smartcar Azuga");
    kafkaTemplate.send("kafka-topic-manual", event);
    log.info("Sent manual value :{} at time : {}", event.getVal(), event.getTimestamp().toString());
  }

}
