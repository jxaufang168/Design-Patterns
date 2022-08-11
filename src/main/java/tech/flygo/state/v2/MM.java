package tech.flygo.state.v2;

/**
 * @description: MM对象类
 * @author: flygo
 * @time: 2022/8/6 22:07
 */
public class MM {
  String name;
  MMState state = new MMHappyState();

  public void smile() {
    state.smile();
  }

  public void cry() {
    state.cry();
  }

  public void say() {
    state.say();
  }
}
