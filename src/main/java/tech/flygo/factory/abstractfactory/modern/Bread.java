package tech.flygo.factory.abstractfactory.modern;

import tech.flygo.factory.abstractfactory.abstractf.AbstractFood;

/**
 * @description: 面包食物
 * @author: flygo
 * @time: 2022/7/5 11:18
 */
public class Bread extends AbstractFood {

  @Override
  public void printName() {
    System.out.println("Bread...");
  }
}
