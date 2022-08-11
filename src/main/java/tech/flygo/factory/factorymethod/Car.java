package tech.flygo.factory.factorymethod;

/**
 * @description: 汽车对象
 * @author: flygo
 * @time: 2022/7/5 10:00
 */
public class Car implements Movable {

  @Override
  public void go() {
    System.out.println("Car go...");
  }
}
