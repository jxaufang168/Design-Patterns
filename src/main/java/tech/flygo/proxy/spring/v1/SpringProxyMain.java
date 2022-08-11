package tech.flygo.proxy.spring.v1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: spring aop动态代理-配置文件的方式
 * @author: flygo
 * @time: 2022/7/25 10:53
 */
public class SpringProxyMain {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
    Tank tank = (Tank) context.getBean("tank");
    tank.move();
  }
}
