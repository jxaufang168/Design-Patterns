package tech.flygo.proxy.v2;

import java.util.Random;

/**
 * @description: 问题：记录坦克的移动时间<br>
 *     最简单的方法：修改源代码，记录时间
 * @author: flygo
 * @time: 2022/7/22 10:30
 */
public class Tank implements Movable {

  public static void main(String[] args) {
    Tank tank = new Tank();
    tank.move();
  }

  @Override
  public void move() {
    long start = System.currentTimeMillis();

    System.out.println("tank moving......");
    try {
      Thread.sleep(new Random().nextInt(10000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    long end = System.currentTimeMillis();

    System.out.println(end - start);
  }
}

interface Movable {
  void move();
}
