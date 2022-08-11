package tech.flygo.proxy.v1;

import java.util.Random;

/**
 * @description: 问题：记录坦克的移动时间
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
    System.out.println("tank moving......");
    try {
      Thread.sleep(new Random().nextInt(10000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

interface Movable {
  void move();
}
