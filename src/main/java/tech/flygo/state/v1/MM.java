package tech.flygo.state.v1;

/**
 * @description: 当增加新的状态时，非常不方便
 * @author: flygo
 * @time: 2022/8/6 21:58
 */
public class MM {
  String name;
  MMState state;

  /**
   * @description: MM的枚举状态
   * @author: flygo
   * @time: 2022/8/6 22:02
   */
  public enum MMState {
    HAPPY,
    SAD;
  }

  public void smile() {
    // switch case
    switch (state) {
      case HAPPY:
        break;
      case SAD:
        break;
    }
  }

  public void cry() {
    // switch case
    switch (state) {
      case HAPPY:
        break;
      case SAD:
        break;
    }
  }

  public void say() {
    // switch case
    switch (state) {
      case HAPPY:
        break;
      case SAD:
        break;
    }
  }
}
