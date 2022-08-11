package tech.flygo.command;

/**
 * @description: Command命令模式测试类
 * @author: flygo
 * @time: 2022/7/28 15:19
 */
public class CommandMain {

  public static void main(String[] args) {
    Content content = new Content();

    Command insertCommand = new InsertCommand(content);
    insertCommand.doit();
    insertCommand.undo();

    Command copyCommand = new CopyCommand(content);
    copyCommand.doit();
    copyCommand.undo();

    Command deleteCommand = new DeleteCommand(content);
    deleteCommand.doit();
    deleteCommand.undo();

    System.out.println(content.msg);
  }
}
