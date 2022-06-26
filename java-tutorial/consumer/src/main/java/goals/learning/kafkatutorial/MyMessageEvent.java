package goals.learning.kafkatutorial;

import java.time.ZonedDateTime;

public class MyMessageEvent {

  private ZonedDateTime timestamp;

  private String val;

  public MyMessageEvent() {}

  public ZonedDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(ZonedDateTime timestamp, String val) {
    this.timestamp = timestamp;
  }

  public String getVal() {
    return val;
  }

  public void setVal(String val) {
    this.val = val;
  }

}
