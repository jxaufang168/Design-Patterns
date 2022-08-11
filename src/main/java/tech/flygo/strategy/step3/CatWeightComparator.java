package tech.flygo.strategy.step3;

/**
 * @description: 猫按体重比较
 * @author: flygo
 * @time: 2022/7/4 16:29
 */
public class CatWeightComparator implements Comparator<Cat> {

  @Override
  public int compare(Cat o1, Cat o2) {
    if (o1.getWeight() > o2.getWeight()) return -1;
    else if (o1.getWeight() < o2.getWeight()) return 1;
    else return 0;
  }
}
