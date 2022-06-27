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

  int i = 0 ,j = 0;

  @Scheduled(fixedRate = 10000)
  public void reportCurrentTimeAndSmartcar() {
    var event = new MyMessageEvent(ZonedDateTime.now(), "Smartcar Azuga", i++);
    kafkaTemplate.send("kafka-topic-smartcar-2", event);
    log.info("Sent smartcar value :{} at time : {} Counter : {}", event.getVal(), event.getTimestamp().toString(), event.getCounter());
  }


  @Scheduled(fixedRate = 10000)
  public void reportCurrentTimeAndManual() {
    var event = new MyMessageEvent(ZonedDateTime.now(), "Manual Azuga", j++);
    kafkaTemplate.send("kafka-topic-manual-2", event);
    log.info("Sent manual value :{} at time : {} Counter : {}", event.getVal(), event.getTimestamp().toString(), event.getCounter());
  }

}
