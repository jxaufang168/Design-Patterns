package tech.flygo.cor.step8;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 责任链模式
 * @author: flygo
 * @time: 2022/7/18 09:51
 */
public class ServletMain {

  public static void main(String[] args) {
    Request request = new Request();
    request.str = "大家好:), <script> 欢迎访问 baidu.com，大家都是996";

    Response response = new Response();
    response.str = "response";

    FilterChain filterChain = new FilterChain();
    filterChain.add(new HTMLFilter()).add(new SensitiveFilter());

    filterChain.doFilter(request, response);

    System.out.println(request.str);
    System.out.println(response.str);
  }
}

class Request {
  String str;
}

class Response {
  String str;
}

interface Filter {
  boolean doFilter(Request request, Response response, FilterChain chain);
}

class HTMLFilter implements Filter {

  @Override
  public boolean doFilter(Request request, Response response, FilterChain chain) {
    request.str = request.str.replaceAll("<", "[").replaceAll(">", "]") + "----HTMLFilter";
    chain.doFilter(request, response);
    response.str += "----HTMLFilter";
    return true;
  }
}

class SensitiveFilter implements Filter {

  @Override
  public boolean doFilter(Request request, Response response, FilterChain chain) {
    request.str = request.str.replaceAll("996", "955") + "----SensitiveFilter";
    chain.doFilter(request, response);
    response.str += "----SensitiveFilter";
    return true;
  }
}

class FilterChain {
  List<Filter> filterList = new ArrayList<>();
  int index = 0;

  public FilterChain add(Filter filter) {
    filterList.add(filter);
    return this;
  }

  public boolean doFilter(Request request, Response response) {
    if (filterList.size() == index) {
      return false;
    }
    Filter f = filterList.get(index);
    index++;

    return f.doFilter(request, response, this);
  }
}
