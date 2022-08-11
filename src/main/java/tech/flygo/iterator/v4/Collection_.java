package tech.flygo.iterator.v4;

/**
 * @description: 容器接口
 * @author: flygo
 * @time: 2022/7/25 21:46
 */
public interface Collection_ {
  void add(Object o);

  int size();

  Iterator_ iterator();
}
