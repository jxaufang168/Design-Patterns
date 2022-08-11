package tech.flygo.flyweight;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @description: 对象池模拟Flyweight享元模式
 * @author: flygo
 * @time: 2022/7/21 11:37
 */
public class BulletPool {

  List<Bullet> bulletList = new ArrayList<>();

  {
    for (int i = 0; i < 5; i++) {
      bulletList.add(new Bullet());
    }
  }

  public Bullet getBullet() {
    for (int i = 0; i < bulletList.size(); i++) {
      Bullet b = bulletList.get(i);
      if (!b.living) {
        return b;
      }
    }
    return new Bullet();
  }

  public static void main(String[] args) {
    BulletPool bp = new BulletPool();

    for (int i = 0; i < 10; i++) {
      Bullet bullet = bp.getBullet();
      System.out.println(bullet);
    }
  }
}

class Bullet {
  public UUID id = UUID.randomUUID();
  boolean living = true;

  @Override
  public String toString() {
    return "Bullet{" + "id=" + id + '}';
  }
}
