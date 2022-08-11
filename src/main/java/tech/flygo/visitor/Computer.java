package tech.flygo.visitor;

/**
 * @description: visitor访问者模式
 * @author: flygo
 * @time: 2022/7/27 11:13
 */
public class Computer {
  ComputerPart cpu = new CPU();
  ComputerPart memory = new Memory();
  ComputerPart board = new Board();

  public void accept(Visitor visitor) {
    this.cpu.accept(visitor);
    this.memory.accept(visitor);
    this.board.accept(visitor);
  }

  public static void main(String[] args) {
    Computer computer = new Computer();

    // 个人访问者
    PersonalVisitor p = new PersonalVisitor();
    computer.accept(p);
    System.out.println("PersonalVisitor >>>> totalPrice: " + p.totalPrice);

    // 企业大客户访问者
    CorpVisitor c = new CorpVisitor();
    computer.accept(c);
    System.out.println("CorpVisitor >>>> totalPrice: " + c.totalPrice);
  }
}

/**
 * @description: 电脑组成部分抽象类
 * @author: flygo
 * @time: 2022/7/27 11:17
 */
abstract class ComputerPart {
  abstract void accept(Visitor visitor);

  abstract double getPrice();
}

/**
 * @description: CPU
 * @author: flygo
 * @time: 2022/7/27 11:17
 */
class CPU extends ComputerPart {
  @Override
  void accept(Visitor visitor) {
    visitor.visitCPU(this);
  }

  @Override
  double getPrice() {
    return 500;
  }
}

/**
 * @description: 内存
 * @author: flygo
 * @time: 2022/7/27 11:18
 */
class Memory extends ComputerPart {
  @Override
  void accept(Visitor visitor) {
    visitor.visitMemory(this);
  }

  @Override
  double getPrice() {
    return 300;
  }
}

/**
 * @description: 主板
 * @author: flygo
 * @time: 2022/7/27 11:20
 */
class Board extends ComputerPart {
  @Override
  void accept(Visitor visitor) {
    visitor.visitBoard(this);
  }

  @Override
  double getPrice() {
    return 0;
  }
}

/**
 * @description: 访问者抽象接口
 * @author: flygo
 * @time: 2022/7/27 11:19
 */
interface Visitor {
  void visitCPU(CPU cpu);

  void visitMemory(Memory memory);

  void visitBoard(Board board);
}

/**
 * @description: 个人访问者
 * @author: flygo
 * @time: 2022/7/27 11:21
 */
class PersonalVisitor implements Visitor {
  double totalPrice = 0.0;

  @Override
  public void visitCPU(CPU cpu) {
    totalPrice += cpu.getPrice() * 0.9;
  }

  @Override
  public void visitMemory(Memory memory) {
    totalPrice += memory.getPrice() * 0.85;
  }

  @Override
  public void visitBoard(Board board) {
    totalPrice += board.getPrice() * 0.95;
  }
}

/**
 * @description: 企业大客户
 * @author: flygo
 * @time: 2022/7/27 11:23
 */
class CorpVisitor implements Visitor {
  double totalPrice = 0.0;

  @Override
  public void visitCPU(CPU cpu) {
    totalPrice += cpu.getPrice() * 0.65;
  }

  @Override
  public void visitMemory(Memory memory) {
    totalPrice += memory.getPrice() + 0.75;
  }

  @Override
  public void visitBoard(Board board) {
    totalPrice += board.getPrice() + 0.75;
  }
}
