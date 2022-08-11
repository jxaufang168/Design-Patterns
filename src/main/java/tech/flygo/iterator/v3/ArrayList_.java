package tech.flygo.iterator.v3;

/**
 * @description: 相比数组，这个容器不用考虑边界，可以动态扩展
 * @author: flygo
 * @time: 2022/7/25 21:48
 */
public class ArrayList_ implements Collection_ {

  Object[] objects = new Object[10];

  private int index;

  public void add(Object o) {
    if (index == objects.length) {
      Object[] newObjects = new Object[objects.length * 2];
      System.arraycopy(objects, 0, newObjects, 0, objects.length);
      objects = newObjects;
    }
    objects[index] = o;
    index++;
  }

  public int size() {
    return index;
  }
}
