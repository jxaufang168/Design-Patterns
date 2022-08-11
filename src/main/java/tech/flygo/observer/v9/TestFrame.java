package tech.flygo.observer.v9;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @description: 简单的一个按钮点击小例子演示java原生使用的观察者模式
 * @author: flygo
 * @time: 2022/7/19 10:20
 */
public class TestFrame extends Frame {

  public void launch() {
    Button button = new Button("press me");
    button.addActionListener(new MyButtonActionListener());
    button.addActionListener(new MyButtonActionListener2());

    this.add(button);
    this.pack();

    this.addWindowListener(
        new WindowAdapter() {
          @Override
          public void windowClosing(WindowEvent e) {
            super.windowClosing(e);
            System.exit(0);
          }
        });
    this.setLocation(400, 400);
    this.setVisible(true);
  }

  public static void main(String[] args) {
    new TestFrame().launch();
  }
}

class MyButtonActionListener implements ActionListener {
  @Override
  public void actionPerformed(ActionEvent e) {
    ((Button) e.getSource()).setLabel("press me again!");
    System.out.println("button pressed!");
  }
}

class MyButtonActionListener2 implements ActionListener {
  @Override
  public void actionPerformed(ActionEvent e) {
    System.out.println("button pressed again!");
  }
}
