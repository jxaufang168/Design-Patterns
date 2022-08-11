package tech.flygo.iterator.v6;

/**
 * @description: 容器接口
 * @author: flygo
 * @time: 2022/7/25 21:46
 */
public interface Collection_<E> {
  void add(E o);

  int size();

  Iterator_<E> iterator();
}
