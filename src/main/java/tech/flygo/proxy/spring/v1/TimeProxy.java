package tech.flygo.proxy.spring.v1;

/**
 * @description: 代理对象
 * @author: flygo
 * @time: 2022/7/25 10:54
 */
public class TimeProxy {

  public void before() {
    System.out.println("before .." + System.currentTimeMillis());
  }

  public void after() {
    System.out.println("after .." + System.currentTimeMillis());
  }
}
