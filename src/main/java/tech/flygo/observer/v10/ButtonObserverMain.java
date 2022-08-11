package tech.flygo.observer.v10;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 模拟Java原生awt button观察者模式-钩子函数(hook)、回调(callback)、observer
 * @author: flygo
 * @time: 2022/7/19 11:09
 */
public class ButtonObserverMain {

  public static void main(String[] args) {
    Button button = new Button();
    button.addActionListener(new MyActionEventListener());
    button.addActionListener(new MyActionEventListener2());

    button.addActionListener(
        (e) -> {
          System.out.println("This is lambda listener!");
        });

    button.buttonPressed();
  }
}

interface ActionListener {
  void actionPerformed(ActionEvent e);
}

class ActionEvent {
  long when;
  Object source;

  public ActionEvent(long when, Object source) {
    this.when = when;
    this.source = source;
  }

  public long getWhen() {
    return when;
  }

  public Object getSource() {
    return source;
  }
}

class Button {
  private List<ActionListener> listenerList = new ArrayList<>();

  public void buttonPressed() {
    ActionEvent event = new ActionEvent(System.currentTimeMillis(), this);
    for (ActionListener listener : listenerList) {
      listener.actionPerformed(event);
    }
  }

  public void addActionListener(ActionListener listener) {
    this.listenerList.add(listener);
  }
}

class MyActionEventListener implements ActionListener {

  @Override
  public void actionPerformed(ActionEvent e) {
    System.out.println("button pressed!");
  }
}

class MyActionEventListener2 implements ActionListener {

  @Override
  public void actionPerformed(ActionEvent e) {
    System.out.println("button pressed again!");
  }
}
