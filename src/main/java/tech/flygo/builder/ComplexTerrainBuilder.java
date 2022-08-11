package tech.flygo.builder;

/**
 * @description: 游戏中的地形对象构造器实现
 * @author: flygo
 * @time: 2022/7/27 22:11
 */
public class ComplexTerrainBuilder implements TerrainBuilder {
  Terrain terrain = new Terrain();

  @Override
  public TerrainBuilder buildWall() {
    terrain.w = new Wall(10, 10, 50, 50);
    return this;
  }

  @Override
  public TerrainBuilder buildFort() {
    terrain.f = new Fort(20, 20, 60, 60);
    return this;
  }

  @Override
  public TerrainBuilder buildMine() {
    terrain.m = new Mine(30, 30, 70, 70);
    return this;
  }

  @Override
  public Terrain build() {
    return terrain;
  }
}
