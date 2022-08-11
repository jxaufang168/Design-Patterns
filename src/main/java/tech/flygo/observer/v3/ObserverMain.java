package tech.flygo.observer.v3;

/**
 * @description: 观察者模式-v3版本(加入观察者)
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

class Child {
  private boolean cry = false;
  private Dad dad = new Dad();

  public boolean isCry() {
    return cry;
  }

  public void setCry(boolean cry) {
    this.cry = cry;
  }

  public void wakeUp() {
    cry = true;
    dad.feed();
  }
}
