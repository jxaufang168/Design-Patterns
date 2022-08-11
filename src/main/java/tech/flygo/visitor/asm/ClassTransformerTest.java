package tech.flygo.visitor.asm;

import org.objectweb.asm.*;

import java.io.File;
import java.io.FileOutputStream;

import static org.objectweb.asm.Opcodes.ASM4;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;

/**
 * @description: 在执行Tank执行move()方法之前，使用asm动态插入TimeProxy代理方法before()
 * @author: flygo
 * @time: 2022/7/27 16:42
 */
public class ClassTransformerTest {

  public static void main(String[] args) throws Exception {
    // 1、读取到Tank.class文件
    ClassReader cr =
        new ClassReader(
            ClassPrinter.class
                .getClassLoader()
                .getResourceAsStream("tech/flygo/visitor/asm/Tank.class"));
    ClassWriter cw = new ClassWriter(0);

    // 2、使用asm动态访问Tank.class文件，动态在Tank的方法中加入TimeProxy代理方法before()
    ClassVisitor cv =
        new ClassVisitor(ASM4, cw) {
          @Override
          public MethodVisitor visitMethod(
              int access, String name, String descriptor, String signature, String[] exceptions) {
            MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);
            return new MethodVisitor(ASM4, mv) {
              @Override
              public void visitCode() {
                visitMethodInsn(
                    INVOKESTATIC, "tech/flygo/visitor/asm/TimeProxy", "before", "()V", false);
                super.visitCode();
              }
            };
          }
        };

    // 3、重新接受动态插入的代理，获取字节流数组
    cr.accept(cv, 0);
    byte[] b2 = cw.toByteArray();

    // 4、使用自定义的类加载器加载TimeProxy，重新构造出Tank实例对象
    MyClassLoader cl = new MyClassLoader();
    cl.loadClass("tech.flygo.visitor.asm.TimeProxy");
    Class c2 = cl.defineClass("tech.flygo.visitor.asm.Tank", b2);
    c2.getConstructor().newInstance();

    // 5、把重新构造出来的Tank类输出到Tank_0.class中
    String path = (String) System.getProperties().get("user.dir");
    File f = new File(path + "/tech/flygo/visitor/asm/");
    f.mkdirs();

    // 6、把Tank_0.class保存到磁盘目录中
    FileOutputStream fos =
        new FileOutputStream(new File(path + "/tech/flygo/visitor/asm/Tank_0.class"));
    fos.write(b2);
    fos.close();
    fos.flush();
  }
}
