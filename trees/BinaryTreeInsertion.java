import java.util.*;
import java.io.*;

class BinaryTreeInsertion {

	static class Node {
	    Node left;
	    Node right;
	    int data;
	    
	    public Node(int data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}
	
  	public static void preOrder(Node root ) {
      
    	if( root == null)
        	return;
      
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
     
    }

	public static Node insert(Node root,int data) {
        //evaluate root
        //if root is null, create a Node, set data, return the node
            //if data is greater, evaluate root.right
                //if there is no root.right, crate node as root.right 
                //if there is a root.right, call insert(root.right, data)
            //if data is lesser, evaluate root.left
                //if there is no root.left, create node as root.left
                //if there is  a root.left, call insert(root.left, data)

        if (root == null){
            Node mNode = new Node(data);
            return mNode;
        }
        if(data >= root.data){
            if(root.right == null){
                Node mNode = new Node(data);
                root.right = mNode;
            } 
            else if (root.right != null){
                insert(root.right, data);
            }
        }
        if(data < root.data){
            if(root.left == null){
                Node mNode = new Node(data);
                root.left = mNode;
            } 
            else if(root.left != null){
                insert(root.left, data);
            }
        }
    	return root;
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
      	preOrder(root);
    }	
}