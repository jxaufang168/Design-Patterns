package tech.flygo.factory.factorymethod;

/**
 * @description: 简单工厂方法
 * @author: flygo
 * @time: 2022/7/5 10:11
 */
public class SimpleVehicleFactory {

  public Car createCar() {
    return new Car();
  }

  public Plane createPlane() {
    return new Plane();
  }
}
