package tech.flygo.singleton;

/**
 * @description: 不仅可以解决多线程同步，还可以解决反序列化问题 <br>
 * @author: flygo
 * @time: 2022/7/4 09:32
 */
public enum SingletonManager08 {
  INSTANCE;

  public static void main(String[] args) {
    for (int i = 0; i < 100; i++) {
      new Thread(
              () -> {
                System.out.println(SingletonManager08.INSTANCE.hashCode());
              })
          .start();
    }
  }
}
