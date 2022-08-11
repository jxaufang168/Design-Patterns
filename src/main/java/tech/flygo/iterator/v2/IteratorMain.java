package tech.flygo.iterator.v2;

/**
 * @description: 构建一个容器，动态扩展添加对象<br>
 *     使用链表来实现一个容器
 * @author: flygo
 * @time: 2022/7/25 17:16
 */
public class IteratorMain {

  public static void main(String[] args) {
    LinkedList_ list = new LinkedList_();
    for (int i = 0; i < 15; i++) {
      list.add("s" + i);
    }
    System.out.println(list.size());
  }
}

/**
 * @description: 相比数组，这个容器不用考虑边界，可以动态扩展
 * @author: flygo
 * @time: 2022/7/25 17:19
 */
class LinkedList_ {
  Node head = null;
  Node tail = null;

  private int size;

  public void add(Object o) {
    Node n = new Node(o);
    n.next = null;
    if (head == null) {
      head = n;
      tail = n;
    }
    tail.next = n;
    tail = n;
    size++;
  }

  private class Node {
    private Object o;
    Node next;

    public Node(Object o) {
      this.o = o;
    }
  }

  public int size() {
    return size;
  }
}
