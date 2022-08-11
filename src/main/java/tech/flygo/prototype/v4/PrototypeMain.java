package tech.flygo.prototype.v4;

/**
 * @description: Prototype原型模式 - String类型需要进一步深克隆？StringBuilder需要
 * @author: flygo
 * @time: 2022/7/28 16:45
 */
public class PrototypeMain {

  public static void main(String[] args) throws CloneNotSupportedException {
    Person p1 = new Person();
    // 深克隆
    Person p2 = (Person) p1.clone();

    System.out.println("p2 >>> p2.age: " + p2.age + ", p2.score: " + p2.score);
    System.out.println("p2.loc >>> " + p2.loc);

    // 深克隆：克隆后的对象p2中的loc对象引用类型，在内存中p1和p2的loc指向的是不同一个对象内存地址
    System.out.println("p1.loc == p2.loc >>> " + (p1.loc == p2.loc));

    // 深克隆：修改了p1的loc街道信息，p2的loc街道信息不会被修改
    p1.loc.street.reverse();
    System.out.println("p1.loc >>> " + p1.loc);
    System.out.println("p2.loc >>> " + p2.loc);
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

  Location loc = new Location(new StringBuilder("bj"), 22);

  @Override
  protected Object clone() throws CloneNotSupportedException {
    Person p = (Person) super.clone();
    p.loc = (Location) loc.clone();
    return p;
  }
}

/**
 * @description: 地址类
 * @author: flygo
 * @time: 2022/7/28 16:48
 */
class Location implements Cloneable {
  StringBuilder street;
  int roomNo;

  public Location(StringBuilder street, int roomNo) {
    this.street = street;
    this.roomNo = roomNo;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  @Override
  public String toString() {
    return "Location{" + "street='" + street + '\'' + ", roomNo=" + roomNo + '}';
  }
}
