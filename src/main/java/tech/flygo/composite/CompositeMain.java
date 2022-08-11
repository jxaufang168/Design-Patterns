package tech.flygo.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: composite组合模式
 * @author: flygo
 * @time: 2022/7/20 14:05
 */
public class CompositeMain {

  public static void main(String[] args) {
    BranchNode root = new BranchNode("root");

    BranchNode chapter1 = new BranchNode("chapter1");
    BranchNode chapter2 = new BranchNode("chapter2");

    Node r1 = new LeafNode("r1");
    Node c11 = new LeafNode("c11");
    Node c12 = new LeafNode("c12");

    BranchNode b21 = new BranchNode("section21");
    Node c211 = new LeafNode("c211");
    Node c212 = new LeafNode("c212");

    root.add(chapter1).add(chapter2).add(r1);
    chapter1.add(c11).add(c12);
    chapter2.add(b21);
    b21.add(c211).add(c212);

    tree(root, 0);
  }

  private static void tree(Node node, int depth) {
    for (int i = 0; i < depth; i++) {
      System.out.print("--");
    }
    node.print();

    if (node instanceof BranchNode) {
      for (Node n : ((BranchNode) node).nodes) {
        tree(n, depth + 1);
      }
    }
  }
}

abstract class Node {
  public abstract void print();
}

/**
 * @description: 叶子节点-不能有子节点
 * @author: flygo
 * @time: 2022/7/20 14:10
 */
class LeafNode extends Node {
  String content;

  public LeafNode(String content) {
    this.content = content;
  }

  @Override
  public void print() {
    System.out.println(content);
  }
}

/**
 * @description: 子节点-可以有子节点和叶子节点
 * @author: flygo
 * @time: 2022/7/20 14:10
 */
class BranchNode extends Node {

  // 子节点可以有子节点和叶子节点
  List<Node> nodes = new ArrayList<>();

  String name;

  public BranchNode(String name) {
    this.name = name;
  }

  @Override
  public void print() {
    System.out.println(name);
  }

  public BranchNode add(Node node) {
    this.nodes.add(node);
    return this;
  }
}
