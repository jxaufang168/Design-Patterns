package tech.flygo.iterator.v3;

/**
 * @description: 构建一个容器，动态扩展添加对象<br>
 *     使用链表来实现一个容器
 * @author: flygo
 * @time: 2022/7/25 17:16
 */
public class IteratorMain {

  public static void main(String[] args) {
    // 链表实现的容器
    Collection_ list = new LinkedList_();
    // 数组实现的容器
    //    Collection_ list = new ArrayList_();

    for (int i = 0; i < 15; i++) {
      list.add("s" + i);
    }
    System.out.println(list.size());
  }
}
