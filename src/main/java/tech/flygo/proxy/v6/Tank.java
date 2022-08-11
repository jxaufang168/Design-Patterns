package tech.flygo.proxy.v6;

import java.util.Random;

/**
 * @description: 问题：记录坦克的移动时间 <br>
 *     最简单的方法：修改源代码，记录时间 <br>
 *     问题2：如果无法修改源码。 使用代理的方式 <br>
 *     问题3：如何实现代理各种组合？Decorator(装饰模式)
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
    // 先打印日志—>再记录时间，静态代理
    new TankLogProxy(new TankTimeProxy(new Tank())).move();
  }
}

/**
 * @description: 时间代理
 * @author: flygo
 * @time: 2022/7/22 11:10
 */
class TankTimeProxy implements Movable {
  Movable m;

  public TankTimeProxy(Movable m) {
    this.m = m;
  }

  @Override
  public void move() {
    long start = System.currentTimeMillis();
    m.move();
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
  Movable m;

  public TankLogProxy(Movable m) {
    this.m = m;
  }

  @Override
  public void move() {
    System.out.println("start moving......");
    m.move();
    System.out.println("stopped!!!");
  }
}

interface Movable {
  void move();
}
