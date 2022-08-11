package tech.flygo.observer.v5;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 观察者模式-v5版本(加入多个观察者，采用接口实现的方式)
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
  void actionOnWakeUp();
}

class Dad implements Observer {
  public void feed() {
    System.out.println("Dad feeding...");
  }

  @Override
  public void actionOnWakeUp() {
    feed();
  }
}

class Mum implements Observer {
  public void hug() {
    System.out.println("Mum hugging...");
  }

  @Override
  public void actionOnWakeUp() {
    hug();
  }
}

class Dog implements Observer {
  public void wang() {
    System.out.println("dog wang...");
  }

  @Override
  public void actionOnWakeUp() {
    wang();
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
    for (Observer o : observerList) {
      o.actionOnWakeUp();
    }
  }
}
