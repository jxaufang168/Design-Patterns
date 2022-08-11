package tech.flygo.singleton;

/**
 * @description: 静态内部类的方式 <br>
 *     JVM保证单例，加载外部类时，不会加载内部类，这样可以实现懒加载
 * @author: flygo
 * @time: 2022/7/4 09:32
 */
public class SingletonManager07 {

  private SingletonManager07() {}

  private static final class SingletonManager07Holder {
    private static final SingletonManager07 INSTANCE = new SingletonManager07();
  }

  public static SingletonManager07 getInstance() {
    return SingletonManager07Holder.INSTANCE;
  }

  public static void main(String[] args) {
    for (int i = 0; i < 100; i++) {
      new Thread(
              () -> {
                System.out.println(SingletonManager07.getInstance().hashCode());
              })
          .start();
    }
  }
}
