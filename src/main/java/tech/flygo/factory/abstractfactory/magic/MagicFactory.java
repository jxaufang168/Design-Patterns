package tech.flygo.factory.abstractfactory.magic;

import tech.flygo.factory.abstractfactory.abstractf.AbstractFactory;
import tech.flygo.factory.abstractfactory.abstractf.AbstractFood;
import tech.flygo.factory.abstractfactory.abstractf.AbstractVehicle;
import tech.flygo.factory.abstractfactory.abstractf.AbstractWeapon;

/**
 * @description: 魔法工厂类
 * @author: flygo
 * @time: 2022/7/5 11:07
 */
public class MagicFactory extends AbstractFactory {

  @Override
  public AbstractFood createFood() {
    return new MashRoom();
  }

  @Override
  public AbstractVehicle createVehicle() {
    return new Broom();
  }

  @Override
  public AbstractWeapon createWeapon() {
    return new MagicStick();
  }
}
