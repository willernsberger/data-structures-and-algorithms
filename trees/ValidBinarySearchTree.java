import java.io.*;
import java.util.*;

//CoderPro Coding Session Problem 22 Valid Binary Search Tree
//https://www.techseries.dev/products/coderpro/categories/1831147/posts/6231427
//Solution implemented in Java
//O(n) time complexity with respect to number of nodes in the tree...
//because each node has to be evaluated
//O(n) space complexity with respect to number of nodes in the tree...
//because the depth first traversal worse-case call stack depth scales with the number of nodes

class ValidBinarySearchTree {
  
  private static class Node{
    Double value;
    Node left;
    Node right;
    
    private Node(Double value){
      this.value = value;
    }
  }
  
  private static boolean evaluate(Node node){
    Double min = Double.NEGATIVE_INFINITY;
    Double max = Double.POSITIVE_INFINITY;
    return traversal(node, min, max);
  }
  
  private static boolean traversal(Node node, Double min, Double max){
    //traverse left
    //if a left descendant is false, return false
    if (node.left != null){
      if (traversal(node.left, min, node.value) == false) return false;
    }
    //traverse right
    //if a right descendant is false, return false
    if (node.right != null){
      if (traversal(node.right, node.value, max) == false) return false;
    }
    //evaluate this node's value against min and max
    return (node.value >= min && node.value <= max);
  }
  
  public static void main(String[] args) {
    //test tree for evaluating
    Node root = new Node(Double.valueOf(50));
    root.left = new Node(Double.valueOf(10));
    root.right = new Node(Double.valueOf(100));
    root.right.left = new Node(Double.valueOf(800));
    
    System.out.println(evaluate(root));
  }  
}




	