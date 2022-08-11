package tech.flygo.prototype.v1;

/**
 * @description: Prototype原型模式 - 浅拷贝
 * @author: flygo
 * @time: 2022/7/28 16:45
 */
public class PrototypeMain {

  public static void main(String[] args) throws CloneNotSupportedException {
    Person p1 = new Person();
    // 浅克隆
    Person p2 = (Person) p1.clone();

    System.out.println("p2 >>> p2.age: " + p2.age + ", p2.score: " + p2.score);
    System.out.println("p2.loc >>> " + p2.loc);

    // 浅克隆：克隆后的对象p2中的loc对象引用类型，在内存中p1和p2的loc指向的是同一个对象内存地址
    System.out.println("p1.loc == p2.loc >>> " + (p1.loc == p2.loc));

    // 浅克隆：修改了p1的loc街道信息，p2的loc街道信息也同时修改了
    p1.loc.street = "sz";
    System.out.println("p1.loc >>> " + p1.loc);
    System.out.println("p2.loc >>> " + p2.loc);
    System.out.println(p1);
    System.out.println(p2);
  }
}

/**
 * @description: 人对象
 * @author: flygo
 * @time: 2022/7/28 16:48
 */
class Person implements Cloneable {
  int age = 20;
  int score = 90;

  Location loc = new Location("bj", 22);

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}

/**
 * @description: 地址类
 * @author: flygo
 * @time: 2022/7/28 16:48
 */
class Location {
  String street;
  int roomNo;

  public Location(String street, int roomNo) {
    this.street = street;
    this.roomNo = roomNo;
  }

  @Override
  public String toString() {
    return "Location{" + "street='" + street + '\'' + ", roomNo=" + roomNo + '}';
  }
}
