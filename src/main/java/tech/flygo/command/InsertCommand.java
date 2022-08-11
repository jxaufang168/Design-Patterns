package tech.flygo.command;

/**
 * @description: 插入命令实现类
 * @author: flygo
 * @time: 2022/7/28 15:23
 */
public class InsertCommand extends Command {
  Content content;
  String strToInsert = "insert this content";

  public InsertCommand(Content content) {
    this.content = content;
  }

  @Override
  public void doit() {
    content.msg = content.msg + strToInsert;
  }

  @Override
  public void undo() {
    content.msg = content.msg.substring(0, content.msg.length() - strToInsert.length());
  }
}
