package tech.flygo.factory.factorymethod;

/**
 * @description: 汽车工厂类
 * @author: flygo
 * @time: 2022/7/5 10:03
 */
public class CarFactory {

  Movable create() {
    return new Car();
  }
}
