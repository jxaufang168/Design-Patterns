package tech.flygo.cor.step2;

/**
 * @description: 责任链模式
 * @author: flygo
 * @time: 2022/7/18 09:51
 */
public class CorMain {

  public static void main(String[] args) {
    Msg msg = new Msg();
    msg.setMsg("大家好:), <script> 欢迎访问 baidu.com，大家都是996");

    // 处理msg
    new HTMLFilter().doFilter(msg);
    new SensitiveFilter().doFilter(msg);

    System.out.println(msg);
  }
}

class Msg {
  String name;
  String msg;

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  @Override
  public String toString() {
    return "Msg{" + "msg='" + msg + '\'' + '}';
  }
}

interface Filter {
  void doFilter(Msg m);
}

class HTMLFilter implements Filter {

  @Override
  public void doFilter(Msg m) {
    String r = m.getMsg();
    r = r.replace('<', '[');
    r = r.replace('>', ']');
    m.setMsg(r);
  }
}

class SensitiveFilter implements Filter {

  @Override
  public void doFilter(Msg m) {
    // 处理msg
    String r = m.getMsg();

    r = r.replaceAll("996", "955");
    m.setMsg(r);
  }
}
