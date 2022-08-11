package tech.flygo.strategy.step1;

import java.util.Arrays;

/**
 * @description: 主方法
 * @author: flygo
 * @time: 2022/7/4 11:15
 */
public class StrategyMain {

  public static void main(String[] args) {
    Cat[] arr = {new Cat(3, 3), new Cat(5, 5), new Cat(1, 1)};

    Sorter sorter = new Sorter();
    sorter.sort(arr);

    System.out.println(Arrays.toString(arr));
  }
}
