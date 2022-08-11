package tech.flygo.command;

/**
 * @description: 命令抽象类
 * @author: flygo
 * @time: 2022/7/28 15:17
 */
public abstract class Command {
  public abstract void doit();

  public abstract void undo();
}
