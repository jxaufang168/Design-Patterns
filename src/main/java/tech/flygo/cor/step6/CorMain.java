package tech.flygo.cor.step6;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 责任链模式
 * @author: flygo
 * @time: 2022/7/18 09:51
 */
public class CorMain {

  public static void main(String[] args) {
    Msg msg = new Msg();
    msg.setMsg("大家好:), <script> 欢迎访问 baidu.com，大家都是996");

    FilterChain filterChain1 = new FilterChain();
    filterChain1.add(new HTMLFilter()).add(new SensitiveFilter());

    FilterChain filterChain2 = new FilterChain();
    filterChain2.add(new FaceFilter()).add(new URLFilter());

    filterChain1.add(filterChain2);

    filterChain1.doFilter(msg);

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

class FaceFilter implements Filter {

  @Override
  public void doFilter(Msg m) {
    // 处理msg
    String r = m.getMsg();
    r = r.replace(":)", "^v^");
    m.setMsg(r);
  }
}

class URLFilter implements Filter {

  @Override
  public void doFilter(Msg m) {
    // 处理msg
    String r = m.getMsg();
    r = r.replace("baidu.com", "https://www.baidu.com");
    m.setMsg(r);
  }
}

class FilterChain implements Filter {
  List<Filter> filterList = new ArrayList<>();

  public FilterChain add(Filter filter) {
    filterList.add(filter);
    return this;
  }

  @Override
  public void doFilter(Msg m) {
    for (Filter f : filterList) {
      f.doFilter(m);
    }
  }
}
