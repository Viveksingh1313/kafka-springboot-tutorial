package goals.learning.kafkatutorial.producer;

import java.time.ZonedDateTime;

public class MyMessageEvent {

  private ZonedDateTime timestamp;

  private String val;


  private int counter;

  public MyMessageEvent(ZonedDateTime timestamp, String val, int counter) {
    this.timestamp = timestamp;
    this.val = val;
    this.counter = counter;
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

  public int getCounter() {
    return counter;
  }

  public void setCounter(int counter) {
    this.counter = counter;
  }
}
