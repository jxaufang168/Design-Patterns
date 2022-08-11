package tech.flygo.memento;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: memento备忘录模式
 * @author: flygo
 * @time: 2022/7/28 22:25
 */
public class MementoMain {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    // 把实例化的对象快照存储到磁盘中
    save();

    System.out.println("----把磁盘中存储的快照信息重新读取出来----");

    // 把磁盘中存储的快照信息重新读取出来
    load();
  }

  /**
   * description: 把实例化的对象快照存储到磁盘中 <br>
   * date: 2022/7/28 22:29 <br>
   * author: flygo <br>
   *
   * @return void
   */
  public static void save() throws IOException {
    Tank tank1 = new Tank(1001, "tank-1");

    List<Tank> tanks = new ArrayList<>();
    tanks.add(new Tank(1002, "tank-2"));
    tanks.add(new Tank(1003, "tank-3"));

    GameModel gameModel = new GameModel(tanks);

    System.out.println("tank1 >>> " + tank1);
    System.out.println("gameModel >>> " + gameModel);

    String path = (String) System.getProperties().get("user.dir");
    path += "/src/main/resources/tank.data";

    File file = new File(path);

    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
    oos.writeObject(tank1);
    oos.writeObject(gameModel);

    oos.close();
  }

  /**
   * description: 把磁盘中存储的快照信息重新读取出来 <br>
   * date: 2022/7/28 22:30 <br>
   * author: flygo <br>
   *
   * @return void
   */
  public static void load() throws IOException, ClassNotFoundException {
    String path = (String) System.getProperties().get("user.dir");
    path += "/src/main/resources/tank.data";
    File file = new File(path);

    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
    Tank tank1 = (Tank) ois.readObject();
    GameModel gameModel = (GameModel) ois.readObject();

    System.out.println("tank1 >>> " + tank1);
    System.out.println("gameModel >>> " + gameModel);

    ois.close();
  }
}

/**
 * @description: 坦克对象类
 * @author: flygo
 * @time: 2022/7/28 22:27
 */
class Tank implements Serializable {
  int id = 0;
  String name = "";

  public Tank(int id, String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public String toString() {
    return "Tank{" + "id=" + id + ", name='" + name + '\'' + '}';
  }
}

/**
 * @description: 游戏对象类
 * @author: flygo
 * @time: 2022/7/28 22:26
 */
class GameModel implements Serializable {
  List<Tank> tanks = new ArrayList<>();

  public GameModel(List<Tank> tanks) {
    this.tanks = tanks;
  }

  @Override
  public String toString() {
    return "GameModel{" + "tanks=" + tanks + '}';
  }
}
