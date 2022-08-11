package tech.flygo.strategy.step3;

/**
 * @description: 比较器接口
 * @author: flygo
 * @time: 2022/7/4 16:26
 */
@FunctionalInterface
public interface Comparator<T> {

  int compare(T o1, T o2);
}
