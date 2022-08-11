package tech.flygo.command;

/**
 * @description: 复制命令实现类
 * @author: flygo
 * @time: 2022/7/28 15:19
 */
public class CopyCommand extends Command {
  Content content;

  public CopyCommand(Content content) {
    this.content = content;
  }

  @Override
  public void doit() {
    content.msg = content.msg + content.msg;
  }

  @Override
  public void undo() {
    content.msg = content.msg.substring(0, content.msg.length() / 2);
  }
}
