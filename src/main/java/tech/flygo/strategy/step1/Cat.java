package tech.flygo.strategy.step1;

/**
 * @description: 猫对象
 * @author: flygo
 * @time: 2022/7/4 11:11
 */
public class Cat {

  private int height, weight;

  public Cat(int weight, int height) {
    this.weight = weight;
    this.height = height;
  }

  public int compareTo(Cat c) {
    if (this.weight < c.weight) return -1;
    else if (this.weight > c.weight) return 1;
    else return 0;
  }

  @Override
  public String toString() {
    return "Cat{" + "height=" + height + ", weight=" + weight + '}';
  }
}
