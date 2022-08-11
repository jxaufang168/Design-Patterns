package tech.flygo.factory.abstractfactory;

import tech.flygo.factory.abstractfactory.abstractf.AbstractFactory;
import tech.flygo.factory.abstractfactory.abstractf.AbstractFood;
import tech.flygo.factory.abstractfactory.abstractf.AbstractVehicle;
import tech.flygo.factory.abstractfactory.abstractf.AbstractWeapon;
import tech.flygo.factory.abstractfactory.magic.MagicFactory;

/**
 * @description: 抽象工厂方法主方法类
 * @author: flygo
 * @time: 2022/7/5 11:03
 */
public class AbstractFactoryMain {

  public static void main(String[] args) {

    System.out.println("-------生成一组产品族(魔法)-------");
    // 生成一组产品族(魔法)
    AbstractFactory magicFactory = new MagicFactory();

    AbstractFood food1 = magicFactory.createFood();
    food1.printName();

    AbstractWeapon weapon1 = magicFactory.createWeapon();
    weapon1.shoot();

    AbstractVehicle vehicle1 = magicFactory.createVehicle();
    vehicle1.go();

    System.out.println("-------生成一组产品族(现代)-------");
    // 生成一组产品族(现代)
    AbstractFactory modernFactory = new MagicFactory();

    AbstractFood food2 = modernFactory.createFood();
    food2.printName();

    AbstractWeapon weapon2 = modernFactory.createWeapon();
    weapon2.shoot();

    AbstractVehicle vehicle2 = modernFactory.createVehicle();
    vehicle2.go();
  }
}
