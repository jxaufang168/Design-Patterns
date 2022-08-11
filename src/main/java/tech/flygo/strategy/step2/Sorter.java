package tech.flygo.strategy.step2;

/**
 * @description: 排序对象
 * @author: flygo
 * @time: 2022/7/4 11:16
 */
public class Sorter {

  public void sort(Comparable[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      int minPos = i;
      for (int j = i + 1; j < arr.length; j++) {
        minPos = arr[j].compareTo(arr[minPos]) == -1 ? j : minPos;
      }
      swap(arr, i, minPos);
    }
  }

  static void swap(Comparable[] arr, int i, int j) {
    Comparable temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
