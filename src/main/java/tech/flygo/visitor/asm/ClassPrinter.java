package tech.flygo.visitor.asm;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;

import java.io.IOException;

import static org.objectweb.asm.Opcodes.ASM4;

/**
 * @description: 自定输出class的内容
 * @author: flygo
 * @time: 2022/7/27 15:19
 */
public class ClassPrinter extends ClassVisitor {

  public ClassPrinter() {
    super(ASM4);
  }

  @Override
  public void visit(
      int version,
      int access,
      String name,
      String signature,
      String superName,
      String[] interfaces) {
    System.out.println(name + " extends " + superName + "{");
  }

  @Override
  public FieldVisitor visitField(
      int access, String name, String descriptor, String signature, Object value) {
    System.out.println("    " + name);
    return null;
  }

  @Override
  public MethodVisitor visitMethod(
      int access, String name, String descriptor, String signature, String[] exceptions) {
    System.out.println("    " + name + "()");
    return null;
  }

  @Override
  public void visitEnd() {
    System.out.println("}");
  }

  public static void main(String[] args) throws IOException {
    ClassPrinter cp = new ClassPrinter();

    ClassReader cr =
        new ClassReader(
            ClassPrinter.class
                .getClassLoader()
                .getResourceAsStream("tech/flygo/visitor/asm/T1.class"));

    cr.accept(cp, 0);
  }
}
