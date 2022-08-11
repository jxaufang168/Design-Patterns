package tech.flygo.singleton;

/**
 * @description: 同第一种方式一样,静态语句块实现
 * @author: flygo
 * @time: 2022/5/27 22:24
 */
public class SingletonManager02 {

  private static final SingletonManager02 INSTANCE;

  private SingletonManager02() {}

  static {
    INSTANCE = new SingletonManager02();
  }

  public static SingletonManager02 getInstance() {
    return INSTANCE;
  }

  public static void main(String[] args) {
    SingletonManager02 singletonManager02 = SingletonManager02.getInstance();
    SingletonManager02 singletonManager021 = SingletonManager02.getInstance();

    System.out.println(singletonManager02 == singletonManager021);
  }
}
