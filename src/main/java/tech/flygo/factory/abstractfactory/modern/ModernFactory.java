package tech.flygo.factory.abstractfactory.modern;

import tech.flygo.factory.abstractfactory.abstractf.AbstractFactory;
import tech.flygo.factory.abstractfactory.abstractf.AbstractFood;
import tech.flygo.factory.abstractfactory.abstractf.AbstractVehicle;
import tech.flygo.factory.abstractfactory.abstractf.AbstractWeapon;

/**
 * @description: 现代工厂类
 * @author: flygo
 * @time: 2022/7/5 11:16
 */
public class ModernFactory extends AbstractFactory {

  @Override
  public AbstractFood createFood() {
    return new Bread();
  }

  @Override
  public AbstractVehicle createVehicle() {
    return new Car();
  }

  @Override
  public AbstractWeapon createWeapon() {
    return new AK47();
  }
}
