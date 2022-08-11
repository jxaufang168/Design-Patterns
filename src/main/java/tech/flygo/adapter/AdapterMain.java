package tech.flygo.adapter;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @description: adapter适配器模式
 * @author: flygo
 * @time: 2022/7/28 10:27
 */
public class AdapterMain {

  public static void main(String[] args) throws Exception {
    String path = (String) System.getProperties().get("user.dir");
    String fileName = path + "/src/main/resources/adapter_test.txt";

    FileInputStream fis = new FileInputStream(fileName);
    InputStreamReader isr = new InputStreamReader(fis);
    BufferedReader br = new BufferedReader(isr);

    String line;
    while ((line = br.readLine()) != null) {
      System.out.println(line);
    }

    br.close();
    isr.close();
    fis.close();
  }

  /**
   * description: 非adapter适配器模式命名的Adapter类写法对比 <br>
   * date: 2022/7/28 11:02 <br>
   * author: flygo <br>
   *
   * @return void
   */
  public void testAddWindowListener() {
    Frame frame = new Frame();

    frame.addWindowListener(
        new WindowListener() {
          @Override
          public void windowOpened(WindowEvent e) {}

          @Override
          public void windowClosing(WindowEvent e) {}

          @Override
          public void windowClosed(WindowEvent e) {}

          @Override
          public void windowIconified(WindowEvent e) {}

          @Override
          public void windowDeiconified(WindowEvent e) {}

          @Override
          public void windowActivated(WindowEvent e) {}

          @Override
          public void windowDeactivated(WindowEvent e) {}
        });
  }

  /**
   * description: 非adapter适配器模式命名的Adapter类写法对比 <br>
   * date: 2022/7/28 13:43 <br>
   * author: flygo <br>
   *
   * @return void
   */
  public void testAddWindowAdapter() {
    Frame frame = new Frame();

    frame.addWindowListener(
        new WindowAdapter() {
          @Override
          public void windowOpened(WindowEvent e) {
            super.windowOpened(e);
          }
        });
  }
}
