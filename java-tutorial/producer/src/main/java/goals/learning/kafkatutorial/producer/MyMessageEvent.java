package goals.learning.kafkatutorial.producer;

import java.time.ZonedDateTime;

public class MyMessageEvent {

  private ZonedDateTime timestamp;

  private String val;

  public MyMessageEvent(ZonedDateTime timestamp, String val) {
    this.timestamp = timestamp;
    this.val = val;
  }

  public ZonedDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(ZonedDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public String getVal() {
    return val;
  }

  public void setVal(String val) {
    this.val = val;
  }

}
