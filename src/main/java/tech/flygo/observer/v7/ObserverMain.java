package tech.flygo.observer.v7;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 观察者模式-v5版本(加入多个观察者，增加事件对象且事件对象增加事件源)
 * @author: flygo
 * @time: 2022/7/18 16:57
 */
public class ObserverMain {

  public static void main(String[] args) {
    Child child = new Child();
    child.wakeUp();
  }
}

interface Observer {
  void actionOnWakeUp(WakeUpEvent event);
}

class Dad implements Observer {
  public void feed() {
    System.out.println("Dad feeding...");
  }

  @Override
  public void actionOnWakeUp(WakeUpEvent event) {
    feed();
  }
}

class Mum implements Observer {
  public void hug() {
    System.out.println("Mum hugging...");
  }

  @Override
  public void actionOnWakeUp(WakeUpEvent event) {
    hug();
  }
}

class Dog implements Observer {
  public void wang() {
    System.out.println("dog wang...");
  }

  @Override
  public void actionOnWakeUp(WakeUpEvent event) {
    wang();
  }
}

class WakeUpEvent {
  long timestamp;
  String loc;
  Child child;

  public WakeUpEvent(long timestamp, String loc, Child child) {
    this.timestamp = timestamp;
    this.loc = loc;
    this.child = child;
  }
}

class Child {
  private boolean cry = false;
  private List<Observer> observerList = new ArrayList<>();

  {
    observerList.add(new Dad());
    observerList.add(new Mum());
    observerList.add(new Dog());
  }

  public boolean isCry() {
    return cry;
  }

  public void setCry(boolean cry) {
    this.cry = cry;
  }

  public void wakeUp() {
    cry = true;
    WakeUpEvent event = new WakeUpEvent(System.currentTimeMillis(), "bed", this);
    for (Observer o : observerList) {
      o.actionOnWakeUp(event);
    }
  }
}
