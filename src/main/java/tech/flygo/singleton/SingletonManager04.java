package tech.flygo.singleton;

/**
 * @description: lazy loading 懒汉式加载，虽然达到了按需加载的目的，但带来了线程不安全的问题 <br>
 *     通过synchronized加锁的方式解决，同时效率下降了
 * @author: flygo
 * @time: 2022/7/4 09:32
 */
public class SingletonManager04 {
  public static SingletonManager04 INSTANCE;

  private SingletonManager04() {}

  public static synchronized SingletonManager04 getInstance() {
    if (INSTANCE == null) {
      try {
        Thread.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      INSTANCE = new SingletonManager04();
    }

    return INSTANCE;
  }

  public static void main(String[] args) {
    for (int i = 0; i < 100; i++) {
      new Thread(
              () -> {
                System.out.println(SingletonManager04.getInstance().hashCode());
              })
          .start();
    }
  }
}
