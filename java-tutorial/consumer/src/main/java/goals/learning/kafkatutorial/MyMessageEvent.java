package goals.learning.kafkatutorial;

import java.time.ZonedDateTime;

public class MyMessageEvent {

  private ZonedDateTime timestamp;

  private String val;

  private int counter;

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

  public int getCounter() {
    return counter;
  }

  public void setCounter(int counter) {
    this.counter = counter;
  }

}
