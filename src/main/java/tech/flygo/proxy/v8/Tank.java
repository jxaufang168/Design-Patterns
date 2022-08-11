package tech.flygo.proxy.v8;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * @description: 问题：记录坦克的移动时间 <br>
 *     最简单的方法：修改源代码，记录时间 <br>
 *     问题2：如果无法修改源码。 使用代理的方式 <br>
 *     问题3：如何实现代理各种组合？Decorator(装饰模式) <br>
 *     如果想让LogProxy可以重用，不仅可以代理Tank，还可以代理任何其他类型的代理 Object <br>
 *     日志很多地方都需要用到，如何处理这问题？<br>
 *     分离代理行为和代理对象，使用jdk的动态代理
 *     <p>v8: 横切代码和业务逻辑代码分离
 * @author: flygo
 * @time: 2022/7/22 10:30
 */
public class Tank implements Movable {

  @Override
  public void move() {
    System.out.println("tank moving......");
    try {
      Thread.sleep(new Random().nextInt(10000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    Tank tank = new Tank();

    //    System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");

    // reflection 通过二进制字节码分析类的属性和方法
    // 使用匿名内部类的形式
    /*
        Movable m =
            (Movable)
                Proxy.newProxyInstance(
                    Tank.class.getClassLoader(),
                    new Class[] {Movable.class},
                    new InvocationHandler() {
                      @Override
                      public Object invoke(Object proxy, Method method, Object[] args)
                          throws Throwable {
                        System.out.println("method " + method.getName() + " start......");
                        Object o = method.invoke(tank, args);
                        System.out.println("method " + method.getName() + " end!");
                        return o;
                      }
                    });
    */
    Movable m =
        (Movable)
            Proxy.newProxyInstance(
                Tank.class.getClassLoader(), new Class[] {Movable.class}, new LogHandler(tank));

    m.move();
  }
}

class LogHandler implements InvocationHandler {
  Movable m;

  public LogHandler(Movable m) {
    this.m = m;
  }

  private void before() {
    System.out.println("method start......");
  }

  private void after() {
    System.out.println("method end......");
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    before();
    Object o = method.invoke(m, args);
    after();
    return o;
  }
}

interface Movable {
  void move();
}
