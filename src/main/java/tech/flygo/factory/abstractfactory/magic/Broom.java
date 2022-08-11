package tech.flygo.factory.abstractfactory.magic;

import tech.flygo.factory.abstractfactory.abstractf.AbstractVehicle;

/**
 * @description: 魔法扫帚
 * @author: flygo
 * @time: 2022/7/5 11:11
 */
public class Broom extends AbstractVehicle {

  @Override
  public void go() {
    System.out.println("Broom go...");
  }
}
