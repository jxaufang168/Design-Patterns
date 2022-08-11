package tech.flygo.builder;

/**
 * @description: 游戏中的地形对象构造器接口
 * @author: flygo
 * @time: 2022/7/27 22:09
 */
public interface TerrainBuilder {
  TerrainBuilder buildWall();

  TerrainBuilder buildFort();

  TerrainBuilder buildMine();

  Terrain build();
}
