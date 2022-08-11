package tech.flygo.factory.abstractfactory.modern;

import tech.flygo.factory.abstractfactory.abstractf.AbstractWeapon;

/**
 * @description: 武器AK47
 * @author: flygo
 * @time: 2022/7/5 11:19
 */
public class AK47 extends AbstractWeapon {

  @Override
  public void shoot() {
    System.out.println("AK47 shoot...");
  }
}
