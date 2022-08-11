package tech.flygo.singleton;

/**
 * @description: 单例实现方式一: 饿汉式 <br>
 *     类加载到内存后，就实例化一个单例，JVM保证线程安全 <br>
 *     简单实用，推荐使用。<br>
 *     唯一缺点: 不管用到与否，类装载时就完成加载。
 * @author: flygo
 * @time: 2022/5/27 22:17
 */
public class SingletonManager01 {

  private static final SingletonManager01 INSTANCE = new SingletonManager01();

  private SingletonManager01() {}

  public static SingletonManager01 getInstance() {
    return INSTANCE;
  }

  public static void main(String[] args) {
    SingletonManager01 singletonManager01 = SingletonManager01.getInstance();
    SingletonManager01 singletonManager011 = SingletonManager01.getInstance();

    System.out.println(singletonManager01 == singletonManager011);
  }
}
