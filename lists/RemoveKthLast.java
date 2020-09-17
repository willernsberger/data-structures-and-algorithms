import java.io.*;
import java.util.*;

// CoderPro Coding Session Problem 21 Remove Kth Last Element From Linked List
// https://www.techseries.dev/products/coderpro/categories/1831147/posts/6190175
// Solution implemented in Java
// O(n) time complexity with respect to length of the Linked List
// Minimal space complexity, just a few assigned variables O(1)

class RemoveKthLastSolution {

  public static class Node{
    int value;
    Node next;

    public  Node(int value, Node next){
      this.value = value;
      this.next = next;
    }
  }
  
  public static void main(String[] args) {
    
    //create the linked list
    Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6, null))))));
    int k = 6;
    //call the helperfunction
    head = RemoveKthLast(head, k);
    
    while (head != null){
        System.out.println(head.value);
        head = head.next;
    }
  }
  
  private static Node RemoveKthLast(Node head, int k){  
    //can't remove an element if k <1 
    if (k < 1){
      return head;
    }
    
    //create a pointer for traversing the linked list
    Node current = head;
    int length = 0;
    //count the number of elements in the linked list
    while(current != null){
      length++;
      current = current.next;
    }
    //you can't remove an element if the linked list is empty
    if (length == 0){
      return head;
    }
    //you can't remove kth element from last if k is larger than the lenght of the list
    if (k > length){
      return head;
    }
    //remove the first element if k is the lenght of the list
    if (k == length){
      return head.next;
    }
    current = head;
    
    int position = 1;
    while(true){
      //evaluate if the pointer preceding the kth last
      if(position == length - k){
        current.next = current.next.next;
        return head;
      }   
      //otherwise increment position and traverse the pointer
      position ++;
      current = current.next;
    }
  }
}
