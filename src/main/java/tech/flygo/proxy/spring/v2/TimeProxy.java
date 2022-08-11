package tech.flygo.proxy.spring.v2;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @description: 代理对象
 * @author: flygo
 * @time: 2022/7/25 10:54
 */
@Aspect
public class TimeProxy {

  @Before("execution (void tech.flygo.proxy.spring.v2.Tank.move())")
  public void before() {
    System.out.println("before .." + System.currentTimeMillis());
  }

  @After("execution (void tech.flygo.proxy.spring.v2.Tank.move())")
  public void after() {
    System.out.println("after .." + System.currentTimeMillis());
  }
}
