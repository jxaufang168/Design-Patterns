package tech.flygo.proxy.spring.v2;

import java.util.Random;

/**
 * @description: 被代理对象
 * @author: flygo
 * @time: 2022/7/25 10:53
 */
public class Tank {

  public void move() {
    System.out.println("tank moving......");
    try {
      Thread.sleep(new Random().nextInt(10000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
