package tech.flygo.factory.abstractfactory.abstractf;

/**
 * @description: 抽象工程方法
 * @author: flygo
 * @time: 2022/7/5 11:02
 */
public abstract class AbstractFactory {

  public abstract AbstractFood createFood();

  public abstract AbstractVehicle createVehicle();

  public abstract AbstractWeapon createWeapon();
}
