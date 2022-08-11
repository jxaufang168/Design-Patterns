package tech.flygo.iterator.v1;

/**
 * @description: 构建一个容器，动态扩展添加对象
 * @author: flygo
 * @time: 2022/7/25 17:16
 */
public class IteratorMain {

  public static void main(String[] args) {
    ArrayList_ list = new ArrayList_();
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
class ArrayList_ {
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
