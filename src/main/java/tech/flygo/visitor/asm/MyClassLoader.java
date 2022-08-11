package tech.flygo.visitor.asm;

/**
 * @description: 自定义classLoader
 * @author: flygo
 * @time: 2022/7/27 16:29
 */
public class MyClassLoader extends ClassLoader {

  public Class defineClass(String name, byte[] b) {
    return defineClass(name, b, 0, b.length);
  }
}
