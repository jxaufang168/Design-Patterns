package tech.flygo.strategy.step2;

import java.util.Arrays;

/**
 * @description: 主方法
 * @author: flygo
 * @time: 2022/7/4 11:15
 */
public class StrategyMain {

  public static void main(String[] args) {
    //    int[] arr = {2, 4, 3, 6, 10, 1};
    //    Cat[] arr = {new Cat(3, 3), new Cat(5, 5), new Cat(1, 1)};

    Dog[] arr = {new Dog(5), new Dog(1), new Dog(3)};

    Sorter sorter = new Sorter();
    sorter.sort(arr);

    System.out.println(Arrays.toString(arr));
  }
}
