package tech.flygo.factory.abstractfactory.magic;

import tech.flygo.factory.abstractfactory.abstractf.AbstractWeapon;

/**
 * @description: 魔法棒
 * @author: flygo
 * @time: 2022/7/5 11:15
 */
public class MagicStick extends AbstractWeapon {

  @Override
  public void shoot() {
    System.out.println("MagicStick shoot...");
  }
}
