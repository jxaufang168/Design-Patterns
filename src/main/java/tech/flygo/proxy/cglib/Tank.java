package tech.flygo.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * @description: clib实现动态代理不需要接口
 * @author: flygo
 * @time: 2022/7/22 10:30
 */
public class Tank {

  public void move() {
    System.out.println("tank moving......");
    try {
      Thread.sleep(new Random().nextInt(10000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(Tank.class);
    enhancer.setCallback(new TimeMethodInterceptor());
    Tank tank = (Tank) enhancer.create();
    tank.move();
  }
}

class TimeMethodInterceptor implements MethodInterceptor {

  private void before() {
    System.out.println("method start......");
  }

  private void after() {
    System.out.println("method end......");
  }

  @Override
  public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
      throws Throwable {
    System.out.println(o.getClass().getSuperclass().getName());
    before();
    Object result = methodProxy.invokeSuper(o, objects);
    after();
    return result;
  }
}
