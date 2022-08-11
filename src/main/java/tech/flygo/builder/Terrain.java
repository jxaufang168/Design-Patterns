package tech.flygo.builder;

/**
 * @description: 游戏中的地形对象类
 * @author: flygo
 * @time: 2022/7/27 17:52
 */
public class Terrain {
  Wall w;
  Fort f;
  Mine m;
}

/**
 * @description: 墙对象类
 * @author: flygo
 * @time: 2022/7/27 17:53
 */
class Wall {
  int x, y, w, h;

  public Wall(int x, int y, int w, int h) {
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
  }
}

/**
 * @description: 暗堡对象类
 * @author: flygo
 * @time: 2022/7/27 17:53
 */
class Fort {
  int x, y, w, h;

  public Fort(int x, int y, int w, int h) {
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
  }
}

/**
 * @description: 地雷对象类
 * @author: flygo
 * @time: 2022/7/27 17:53
 */
class Mine {
  int x, y, w, h;

  public Mine(int x, int y, int w, int h) {
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
  }
}
