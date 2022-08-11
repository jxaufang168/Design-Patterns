package tech.flygo.observer.v2;

/**
 * @description: 观察者模式-v2版本(面向对象的傻等)
 * @author: flygo
 * @time: 2022/7/18 16:57
 */
public class ObserverMain {

  public static void main(String[] args) {
    Child child = new Child();

    while (!child.isCry()) {
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Observing......");
    }
  }
}

class Child {
  private boolean cry = false;

  public boolean isCry() {
    return cry;
  }

  public void setCry(boolean cry) {
    this.cry = cry;
  }

  public void wakeUp() {
    System.out.println("Waked Up!Crying.......");
    cry = true;
  }
}
