package tech.flygo.factory.factorymethod;

/**
 * @description: 主方法
 * @author: flygo
 * @time: 2022/7/5 10:01
 */
public class FactoryMain {

  public static void main(String[] args) {
    Movable carMovable = new CarFactory().create();
    carMovable.go();

    Movable planeMovable = new PlaneFactory().create();
    planeMovable.go();
  }
}
