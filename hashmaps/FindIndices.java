import java.io.*;
import java.util.*;

//First and Last Indices of an Element in a Sorted Array
//CoderPro Coding Session 6
//Given a sorted array and an element, find the first and last indices 
//of the given element within the array.

//This solution is implemented in O(log(n)) time with respect to the number of elements in the given array
//because each recursive call prunes half of the array from the searchable indices.
//This solution is implemented in O(log(n)) space with respect to the number of elements in the given array
//because the recursive call stack is expected on average to create O(log(n)) calls
//before hitting the base case (finding the first or finding the last index of the element).
//An iterative solution would be better as it would offer O(1) space complexity.

class FindIndices {
    
  private static int[] findIndicesRecursive(int[] arr, int element){
    int[] indices = new int[2];
    
    //binary searches for first and last index
    indices[0] = search(arr, element, true);
    indices[1] = search(arr, element, false);
    
    return indices;
  }
  
  //helper function to set up the recursion
  private static int search(int[] arr, int element, boolean first){
    if (first) return searchFirst(arr, element, 0, arr.length - 1);
    else return searchLast(arr, element, 0, arr.length - 1);
  }
  
  
  private static int searchFirst(int[] arr, int element, int min, int max){
    //point at the mid (of the remaining elements in the search)
    int mid = min + (((max) - (min)) / 2);
    int value = arr[mid];

    //ask, is value at mid higher, lower, or equal to the element
    //if it is higher, the first index is between the min and the mid
    //set the value of max to the value of mid, recurse
    if (value > element){
      return searchFirst(arr, element, min, mid);
    }
    //if it is lower, the first index is between the mid and the max
    //set the value of the min to the value of mid, recurse
    if (value < element){
      return searchFirst(arr, element, mid, max);
    }
    
    //if it is equal, determine if we are at the first position
    //if we are, return the index
    //if we are not, the first index is between min and mid
    if (mid == 0 || arr[mid - 1] != element){
      return mid;
    }
    else return searchFirst(arr, element, min, mid);
  }
  
  private static int searchLast(int[] arr, int element, int min, int max){
    //point at the mid (of the remaining elements in the search)
    int mid = min + (((max) - (min)) / 2);
    int value = arr[mid];

    //ask, is this higher, lower, or equal to the element
    //if it is higher, the first index is between the min and the mid
    //set the value of max to the value of mid, recurse
    if (value > element){
      return searchLast(arr, element, min, mid);
    }
    //if it is lower, the first index is between the mid and the max
    //set the value of the min to the value of mid, recurse
    if (value < element){
      return searchLast(arr, element, mid, max);
    }
    
    //if it is equal, determine if we are at the last position
    //if we are, return the index
    //if we are not, the last index is between mid and max
    if (mid == arr.length - 1 || arr[mid + 1] != element){
      return mid;
    }
    else return searchLast(arr, element, mid + 1, max);
  }
  
  public static void main(String[] args) {    
    //Sorted array
    int[] arr = {1, 1, 2, 3, 3, 3, 4, 4, 13, 15, 20}; //[6, 7]
    //int[] arr = {1, 1, 2, 3, 3, 4, 4, 5, 13, 15, 20}; //[5, 6]
    //int[] arr = {1, 1, 2, 3, 4, 4, 5, 5, 13, 15, 20}; //[4, 5]
    //int[] arr = {4, 4, 5, 5, 6, 7, 8, 8, 13, 15, 20}; //[0, 1]
    //int[] arr = {4, 4, 5, 5, 6, 7, 8, 8, 13, 15};     //[0, 1]
    //int[] arr = {1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4};    //[9, 10]
    //int[] arr = {1, 2, 2, 2, 2, 3, 3, 3, 4, 4};       //[8, 9]
    
    //Given element
    int element = 4;
    
    int[] answer = findIndicesRecursive(arr, element);  
    
    System.out.print(Arrays.toString(answer)); 
  }
  
  
  
  
  
}