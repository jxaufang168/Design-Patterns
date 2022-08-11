package tech.flygo.iterator.v6;

/**
 * @description: 相比数组，这个容器不用考虑边界，可以动态扩展
 * @author: flygo
 * @time: 2022/7/25 21:46
 */
public class LinkedList_<E> implements Collection_<E> {

  Node<E> head = null;
  Node<E> tail = null;

  private int size;

  public void add(E o) {
    Node<E> n = new Node<>(o);
    n.next = null;
    if (head == null) {
      head = n;
      tail = n;
    }
    tail.next = n;
    tail = n;
    size++;
  }

  private class Node<E> {
    private E o;
    Node<E> next;

    public Node(E o) {
      this.o = o;
    }
  }

  public int size() {
    return size;
  }

  @Override
  public Iterator_<E> iterator() {
    return new LinkedListIterator();
  }

  private class LinkedListIterator implements Iterator_ {
    private Node currentNode;
    private int currentIndex;

    @Override
    public boolean hasNext() {
      if (currentNode == null) {
        currentNode = head;
      }

      if (currentIndex == 0) {
        return true;
      } else if (size > 1 && currentNode.next != null) {
        currentNode = currentNode.next;
        return true;
      }

      return false;
    }

    @Override
    public E next() {
      E o = (E) currentNode.o;
      currentIndex++;
      return o;
    }
  }
}
