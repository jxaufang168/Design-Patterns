package tech.flygo.strategy.step3;

import java.util.Arrays;

/**
 * @description: 主方法
 * @author: flygo
 * @time: 2022/7/4 11:15
 */
public class StrategyMain {

  public static void main(String[] args) {
    method2();
  }

  private static void method2() {
    Cat[] arr = {new Cat(3, 3), new Cat(5, 5), new Cat(1, 1)};

    Sorter<Cat> sorter = new Sorter();

    //    CatHeightComparator comparator = new CatHeightComparator();
    CatWeightComparator comparator = new CatWeightComparator();

    sorter.sort(
        arr,
        (o1, o2) -> {
          if (o1.getHeight() < o2.getHeight()) return -1;
          else if (o1.getHeight() > o2.getHeight()) return 1;
          else return 0;
        });

    System.out.println(Arrays.toString(arr));
  }

  private static void method1() {
    Cat[] arr = {new Cat(3, 3), new Cat(5, 5), new Cat(1, 1)};

    Sorter<Cat> sorter = new Sorter();

    //    CatHeightComparator comparator = new CatHeightComparator();
    CatWeightComparator comparator = new CatWeightComparator();

    sorter.sort(arr, comparator);

    System.out.println(Arrays.toString(arr));
  }
}
