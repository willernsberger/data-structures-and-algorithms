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

/* you only have to complete the function given below.  
Node is defined as  

class Node {
    int data;
    Node left;
    Node right;
}

*/

    public static void preOrder(Node root) {

        //print data
        //if there is a left child
            //print a space
            //evaluate the left child
        //if there is a right child
            //print a space
            //evaluate the right child

        System.out.print(root.data);
        if (root.left != null){
            System.out.print(' ');
            preOrder(root.left);
        }
        if (root.right !=null){
            System.out.print(' ');
            preOrder(root.right);

        }
    }

	public static Node insert(Node root, int data) {