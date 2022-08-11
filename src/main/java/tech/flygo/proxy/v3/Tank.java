package tech.flygo.proxy.v3;

import java.util.Random;

/**
 * @description: 问题：记录坦克的移动时间 <br>
 *     最简单的方法：修改源代码，记录时间 <br>
 *     问题2：如果无法修改源码。使用继承的方式？
 * @author: flygo
 * @time: 2022/7/22 10:30
 */
public class Tank implements Movable {

  public static void main(String[] args) {
    new Tank2().move();
  }

  @Override
  public void move() {
    System.out.println("tank moving......");
    try {
      Thread.sleep(new Random().nextInt(10000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class Tank2 extends Tank {
  @Override
  public void move() {
    long start = System.currentTimeMillis();
    super.move();
    long end = System.currentTimeMillis();
    System.out.println(end - start);
  }
}

interface Movable {
  void move();
}
