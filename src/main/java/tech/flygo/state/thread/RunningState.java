package tech.flygo.state.thread;

/**
 * @description: 运行状态
 * @author: flygo
 * @time: 2022/8/7 22:01
 */
public class RunningState extends ThreadState_ {

  private Thread_ thread;

  public RunningState(Thread_ thread) {
    this.thread = thread;
  }

  @Override
  public void move(Action input) {
    // 根据传入的动作，转换成其他状态
  }

  @Override
  public void run() {}
}
