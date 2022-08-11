package tech.flygo.proxy.v5;

import java.util.Random;

/**
 * @description: 问题：记录坦克的移动时间 <br>
 *     最简单的方法：修改源代码，记录时间 <br>
 *     问题2：如果无法修改源码。 使用代理的方式 <br>
 * @author: flygo
 * @time: 2022/7/22 10:30
 */
public class Tank implements Movable {

  @Override
  public void move() {
    System.out.println("tank moving......");
    try {
      Thread.sleep(new Random().nextInt(10000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    new TankTimeProxy(new Tank()).move();
  }
}

/**
 * @description: 时间代理
 * @author: flygo
 * @time: 2022/7/22 11:10
 */
class TankTimeProxy implements Movable {
  Tank tank;

  public TankTimeProxy(Tank tank) {
    this.tank = tank;
  }

  @Override
  public void move() {
    long start = System.currentTimeMillis();
    tank.move();
    long end = System.currentTimeMillis();
    System.out.println(end - start);
  }
}
/**
 * @description: 时间代理
 * @author: flygo
 * @time: 2022/7/22 11:10
 */
class TankLogProxy implements Movable {
  Tank tank;

  public TankLogProxy(Tank tank) {
    this.tank = tank;
  }

  @Override
  public void move() {
    System.out.println("start moving......");
    tank.move();
    System.out.println("stopped!!!");
  }
}

interface Movable {
  void move();
}
