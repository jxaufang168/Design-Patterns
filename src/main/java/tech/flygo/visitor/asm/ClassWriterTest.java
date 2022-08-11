package tech.flygo.visitor.asm;

import org.objectweb.asm.ClassWriter;

import static org.objectweb.asm.Opcodes.*;

/**
 * @description: 使用asm自定义动态生成class类
 * @author: flygo
 * @time: 2022/7/27 16:28
 */
public class ClassWriterTest {

  public static void main(String[] args) {
    ClassWriter cw = new ClassWriter(0);
    cw.visit(
        V1_5,
        ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE,
        "pkg/Comparable",
        null,
        "java/lang/Object",
        null);
    cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "LESS", "I", null, -1).visitEnd();
    cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "EQUAL", "I", null, 0).visitEnd();
    cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "GREATER", "I", null, 1).visitEnd();
    cw.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "compareTo", "(Ljava/lang/Object;)I", null, null)
        .visitEnd();
    cw.visitEnd();
    byte[] b = cw.toByteArray();

    MyClassLoader myClassLoader = new MyClassLoader();
    Class c = myClassLoader.defineClass("pkg.Comparable", b);
    System.out.println(c.getMethods()[0].getName());
  }
}
