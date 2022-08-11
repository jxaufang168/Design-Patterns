package tech.flygo.bridge.v4;

/**
 * @description: 男孩对象类
 * @author: flygo
 * @time: 2022/7/28 13:48
 */
public class GG {

  /**
   * description: 男孩子找女朋友 <br>
   * date: 2022/7/28 13:51 <br>
   * author: flygo <br>
   *
   * @param: mm
   * @return void
   */
  public void chase(MM mm) {
    // 男孩松礼物，相当于使用形容词修饰包装的礼物，如：温柔的礼物-书
    Gift gift = new WarmGift(new Book());
    give(mm, gift);
  }

  /**
   * description: 男孩子送礼物给女孩子 <br>
   * date: 2022/7/28 13:52 <br>
   * author: flygo <br>
   *
   * @param: mm
   * @param: gift
   * @return void
   */
  public void give(MM mm, Gift gift) {}
}
