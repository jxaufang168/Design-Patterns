package tech.flygo.singleton;

/**
 * @description: lazy loading 懒汉式加载，虽然达到了按需加载的目的，但带来了线程不安全的问题
 * @author: flygo
 * @time: 2022/7/4 09:32
 */
public class SingletonManager03 {
  public static SingletonManager03 INSTANCE;

  private SingletonManager03() {}

  public static SingletonManager03 getInstance() {
    if (INSTANCE == null) {
      try {
        Thread.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      INSTANCE = new SingletonManager03();
    }

    return INSTANCE;
  }

  public static void main(String[] args) {
    for (int i = 0; i < 100; i++) {
      new Thread(
              () -> {
                System.out.println(SingletonManager03.getInstance().hashCode());
              })
          .start();
    }
  }
}
