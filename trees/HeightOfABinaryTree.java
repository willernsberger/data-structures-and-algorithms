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

class Solution {

	public static int height(Node root) {

      	//check if there is an unevaluated left node
            //if there is, call recursion on the left node
                //when the recursion returns its height, update height
            //if there is not... do nothing
        //check if there is an unevaluated right node
            //if there is, call recursion on the right node
                //when the recursion returns its height, update height
            //if there is not... do nothing
        //return height

        int height = 0;
        if(root.left != null){
            int leftHeight = (height(root.left) +1);
            if (leftHeight > height) height = leftHeight;
        }
        if(root.right != null){
            int rightHeight = (height(root.right) +1);
            if (rightHeight > height) height = rightHeight;
        }
        
        return height;
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }	
}