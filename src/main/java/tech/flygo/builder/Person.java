package tech.flygo.builder;

/**
 * @description: 人对象类
 * @author: flygo
 * @time: 2022/7/27 21:55
 */
public class Person {
  int id;
  String name;
  int age;
  double weight;
  int score;
  Location location;

  /**
   * @description: 人静态构造类
   * @author: flygo
   * @time: 2022/7/27 21:59
   */
  public static class PersonBuilder {
    Person p = new Person();

    public PersonBuilder basicInfo(int id, String name, int age) {
      p.id = id;
      p.name = name;
      p.age = age;
      return this;
    }

    public PersonBuilder weight(double weight) {
      p.weight = weight;
      return this;
    }

    public PersonBuilder score(int score) {
      p.score = score;
      return this;
    }

    public PersonBuilder loc(Location location) {
      p.location = location;
      return this;
    }

    public Person build() {
      return p;
    }
  }
}

/**
 * @description: 地址信息
 * @author: flygo
 * @time: 2022/7/27 21:58
 */
class Location {
  String street;
  String roomNo;

  public Location(String street, String roomNo) {
    this.street = street;
    this.roomNo = roomNo;
  }
}
