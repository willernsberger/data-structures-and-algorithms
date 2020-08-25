import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class PostOrderTraversal {

    public static void postOrder(Node root) {

        //if there is a left child...
            //evaluate left, calling postOrder on the left child
            //add a space
        //if there is a right child...
            //evaluate right, calling postOrder on the right child
            //add a space
        //print once you have no unevaluated children

        if (root.left != null){
            postOrder(root.left);
            System.out.print(' ');
        }
        if (root.right !=null){
            postOrder(root.right);
            System.out.print(' ');
        }
        System.out.print(root.data);


    }

	public static Node insert(Node root, int data) {