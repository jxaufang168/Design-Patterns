package tech.flygo.flyweight;

/**
 * @description: Java String 中的享元模式
 * @author: flygo
 * @time: 2022/7/21 11:32
 */
public class TestString {

  public static void main(String[] args) {
    String s1 = "abc";
    String s2 = "abc";

    String s3 = new String("abc");
    String s4 = new String("abc");

    System.out.println(s1 == s2); // true
    System.out.println(s1 == s3); // false
    System.out.println(s3 == s4); // false
    System.out.println(s3.intern() == s1); // true
    System.out.println(s3.intern() == s4.intern()); // true
  }
}
