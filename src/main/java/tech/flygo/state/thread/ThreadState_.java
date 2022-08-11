package tech.flygo.state.thread;

/**
 * @description: 线程状态抽象类
 * @author: flygo
 * @time: 2022/8/7 21:57
 */
public abstract class ThreadState_ {

  /**
   * description: 根据输入的动作进行状态的迁移 <br>
   * date: 2022/8/7 21:59 <br>
   * author: flygo <br>
   *
   * @param: input
   * @return void
   */
  public abstract void move(Action input);

  /**
   * description: 线程执行的方法 <br>
   * date: 2022/8/7 22:05 <br>
   * author: flygo <br>
   *
   * @return void
   */
  public abstract void run();
}
