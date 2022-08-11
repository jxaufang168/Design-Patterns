package tech.flygo.factory.abstractfactory.modern;

import tech.flygo.factory.abstractfactory.abstractf.AbstractVehicle;

/**
 * @description: 汽车类
 * @author: flygo
 * @time: 2022/7/5 11:17
 */
public class Car extends AbstractVehicle {

  @Override
  public void go() {
    System.out.println("Car go...");
  }
}
