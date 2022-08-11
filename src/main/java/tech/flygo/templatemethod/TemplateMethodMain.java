package tech.flygo.templatemethod;

/**
 * @description: TemplateMethod 模板方法
 * @author: flygo
 * @time: 2022/7/29 22:37
 */
public class TemplateMethodMain {
  public static void main(String[] args) {
    Father father = new Child();
    father.method();
  }
}

/**
 * @description: 父类方法
 * @author: flygo
 * @time: 2022/7/29 22:39
 */
abstract class Father {
  public void method() {
    // 调用模板方法
    option1();
    option2();
  }

  /**
   * description: 模板方法1 <br>
   * date: 2022/7/29 22:40 <br>
   * author: flygo <br>
   *
   * @return void
   */
  abstract void option1();

  /**
   * description: 模板方法2 <br>
   * date: 2022/7/29 22:40 <br>
   * author: flygo <br>
   *
   * @return void
   */
  abstract void option2();
}

/**
 * @description: 子类实现父类模板方法
 * @author: flygo
 * @time: 2022/7/29 22:41
 */
class Child extends Father {

  @Override
  void option1() {
    System.out.println("option1");
  }

  @Override
  void option2() {
    System.out.println("option2");
  }
}
