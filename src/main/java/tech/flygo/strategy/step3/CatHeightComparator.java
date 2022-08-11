package tech.flygo.strategy.step3;

/**
 * @description: 猫按高比较
 * @author: flygo
 * @time: 2022/7/4 16:29
 */
public class CatHeightComparator implements Comparator<Cat> {

  @Override
  public int compare(Cat o1, Cat o2) {
    if (o1.getHeight() < o2.getHeight()) return -1;
    else if (o1.getHeight() > o2.getHeight()) return 1;
    else return 0;
  }
}
