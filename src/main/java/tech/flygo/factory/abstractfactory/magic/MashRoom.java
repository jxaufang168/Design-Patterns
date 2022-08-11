package tech.flygo.factory.abstractfactory.magic;

import tech.flygo.factory.abstractfactory.abstractf.AbstractFood;

/**
 * @description: 魔法蘑菇食物
 * @author: flygo
 * @time: 2022/7/5 11:13
 */
public class MashRoom extends AbstractFood {

  @Override
  public void printName() {
    System.out.println("MashRoom food...");
  }
}
