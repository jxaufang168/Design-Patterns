package tech.flygo.iterator.v3;

/**
 * @description: 相比数组，这个容器不用考虑边界，可以动态扩展
 * @author: flygo
 * @time: 2022/7/25 21:46
 */
public class LinkedList_ implements Collection_ {

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
