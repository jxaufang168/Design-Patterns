package tech.flygo.iterator.v6;

/**
 * @description: 相比数组，这个容器不用考虑边界，可以动态扩展
 * @author: flygo
 * @time: 2022/7/25 21:48
 */
public class ArrayList_<E> implements Collection_<E> {

  E[] objects = (E[]) new Object[10];

  private int index;

  public void add(E o) {
    if (index == objects.length) {
      E[] newObjects = (E[]) new Object[objects.length * 2];
      System.arraycopy(objects, 0, newObjects, 0, objects.length);
      objects = newObjects;
    }
    objects[index] = o;
    index++;
  }

  public int size() {
    return index;
  }

  @Override
  public Iterator_<E> iterator() {
    return new ArrayListIterator();
  }

  private class ArrayListIterator<E> implements Iterator_<E> {
    private int currentIndex;

    @Override
    public boolean hasNext() {
      if (currentIndex >= index) {
        return false;
      }
      return true;
    }

    @Override
    public E next() {
      E o = (E) objects[currentIndex];
      currentIndex++;
      return o;
    }
  }
}
