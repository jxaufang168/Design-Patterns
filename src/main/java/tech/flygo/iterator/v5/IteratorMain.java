package tech.flygo.iterator.v5;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @description: JDK自带的容器实现方法 <br>
 * @author: flygo
 * @time: 2022/7/25 17:16
 */
public class IteratorMain {

  public static void main(String[] args) {
    // 链表实现的容器
    Collection list = new LinkedList();
    // 数组实现的容器
    //     Collection list = new ArrayList();

    for (int i = 0; i < 15; i++) {
      list.add("s" + i);
    }
    System.out.println(list.size());
    Iterator iterator = list.iterator();
    while (iterator.hasNext()) {
      Object o = iterator.next();
      System.out.println(o);
    }
  }
}
