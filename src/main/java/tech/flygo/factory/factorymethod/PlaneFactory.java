package tech.flygo.factory.factorymethod;

/**
 * @description: 飞机工程类
 * @author: flygo
 * @time: 2022/7/5 10:04
 */
public class PlaneFactory {

  Movable create() {
    return new Plane();
  }
}
