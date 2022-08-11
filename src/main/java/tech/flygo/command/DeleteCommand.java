package tech.flygo.command;

/**
 * @description: 删除命令实现类
 * @author: flygo
 * @time: 2022/7/28 15:21
 */
public class DeleteCommand extends Command {
  Content content;
  String deleted;

  public DeleteCommand(Content content) {
    this.content = content;
  }

  @Override
  public void doit() {
    deleted = content.msg.substring(0, 5);
    content.msg = content.msg.substring(5, content.msg.length());
  }

  @Override
  public void undo() {
    content.msg = deleted + content.msg;
  }
}
