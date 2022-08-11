package tech.flygo.observer.v4;

/**
 * @description: 观察者模式-v4版本(加入多个观察者)
 * @author: flygo
 * @time: 2022/7/18 16:57
 */
public class ObserverMain {

  public static void main(String[] args) {
    Child child = new Child();
    child.wakeUp();
  }
}

class Dad {
  public void feed() {
    System.out.println("Dad feeding...");
  }
}

class Mum {
  public void hug() {
    System.out.println("Mum hugging...");
  }
}

class Dog {
  public void wang() {
    System.out.println("dog wang...");
  }
}

class Child {
  private boolean cry = false;
  private Dad dad = new Dad();
  private Mum mum = new Mum();
  private Dog dog = new Dog();

  public boolean isCry() {
    return cry;
  }

  public void setCry(boolean cry) {
    this.cry = cry;
  }

  public void wakeUp() {
    cry = true;
    dad.feed();
    mum.hug();
    dog.wang();
  }
}
