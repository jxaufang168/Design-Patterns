package tech.flygo.state.thread;

/**
 * @description: 创建新建状态
 * @author: flygo
 * @time: 2022/8/7 22:01
 */
public class NewState extends ThreadState_ {

  private Thread_ thread;

  public NewState(Thread_ thread) {
    this.thread = thread;
  }

  @Override
  public void move(Action input) {
    if (input.msg.equals("start")) {
      thread.state = new RunningState(thread);
    }
  }

  @Override
  public void run() {}
}
