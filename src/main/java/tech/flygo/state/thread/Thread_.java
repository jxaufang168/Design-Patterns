package tech.flygo.state.thread;

/**
 * @description: 线程对象类
 * @author: flygo
 * @time: 2022/8/7 21:59
 */
public class Thread_ {

  ThreadState_ state;

  void move(Action action) {
    state.move(action);
  }

  void run() {
    state.run();
  }
}
