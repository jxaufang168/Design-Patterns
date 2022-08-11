package tech.flygo.iterator.v6;

/**
 * @description: 容器的通用遍历接口
 * @author: flygo
 * @time: 2022/7/25 22:10
 */
public interface Iterator_<E> {

  boolean hasNext();

  E next();
}
