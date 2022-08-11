package tech.flygo.singleton;

/**
 * @description: lazy loading 懒汉式加载，虽然达到了按需加载的目的，但带来了线程不安全的问题 <br>
 *     通过synchronized加锁的方式解决，同时效率下降了
 * @author: flygo
 * @time: 2022/7/4 09:32
 */
public class SingletonManager05 {
  public static SingletonManager05 INSTANCE;

  private SingletonManager05() {}

  public static SingletonManager05 getInstance() {
    if (INSTANCE == null) {
      // 妄图通过减少同步代码块的方式提供效率，然后并不行
      synchronized (SingletonManager05.class) {
        try {
          Thread.sleep(1);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        INSTANCE = new SingletonManager05();
      }
    }

    return INSTANCE;
  }

  public static void main(String[] args) {
    for (int i = 0; i < 100; i++) {
      new Thread(
              () -> {
                System.out.println(SingletonManager05.getInstance().hashCode());
              })
          .start();
    }
  }
}
