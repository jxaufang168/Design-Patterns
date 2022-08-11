package tech.flygo.factory.factorymethod;

/**
 * @description: 飞机对象
 * @author: flygo
 * @time: 2022/7/5 10:01
 */
public class Plane implements Movable {

  @Override
  public void go() {
    System.out.println("plane go...");
  }
}
