package tech.flygo.builder;

/**
 * @description: builder模式主测试类
 * @author: flygo
 * @time: 2022/7/27 17:52
 */
public class BuilderMain {

  public static void main(String[] args) {
    // 使用构造器构造游戏中的地形对象
    TerrainBuilder builder = new ComplexTerrainBuilder();
    Terrain terrain = builder.buildWall().buildFort().buildMine().build();
    System.out.println(terrain);

    // 使用构造器构造人对象
    Person person =
        new Person.PersonBuilder()
            .basicInfo(1000, "zhangsan", 20)
            .weight(60)
            .score(80)
            .loc(new Location("sz", "20"))
            .build();
    System.out.println(person);
  }
}
