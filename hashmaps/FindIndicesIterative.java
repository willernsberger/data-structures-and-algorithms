import java.io.*;
import java.util.*;

class FindIndicesIterative {
    
  private static int[] findIndices(int[] arr, int element){
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
  
  private static int[] findIndicesIterative(int[] arr, int element){
    //create pointers
    int[] answer = new int[2];
    int min = 0;
    int max = arr.length - 1;
    int mid;
    int value;
    int first;
    int last;
    //find fist
    while(true){
      //find mid index among the searchable indices, and its value
      mid = min + (((max) - (min)) / 2);
      value = arr[mid];
      //compare its value with the element
      //if the mid value is greater set the min/max pointers and continue
      if(value > element){
        max = mid;
        continue;
      }
      //if the mid value is lesser set the min/max pointers and continue
      if(value < element){
        min = mid;
        continue;
      }
      //if the mid value is equal evaluate...
      if (mid == 0 || arr[mid - 1] != element){
        first = mid;
        break;
      } else {
        max = mid;
        continue;
      }
    }
    
    //find last
    while(true){
      //find mid index among the searchable indices, and its value
      mid = min + (((max) - (min)) / 2);
      value = arr[mid];
      //compare its value with the element
      //if the mid value is greater set the min/max pointers and continue
      if(value > element){
        max = mid;
        continue;
      }
      //if the mid value is lesser set the min/max pointers and continue
      if(value < element){
        min = mid;
        continue;
      }
      //if the mid value is equal evaluate...
      if (mid == arr.length - 1 || arr[mid + 1] != element){
        last = mid;
        break;
      } else {
        min = mid + 1;
        continue;
      }
    }
    answer[0] = first;
    answer[1] = last;
    return answer;
  }
  
  
  public static void main(String[] args) {  
    //given element
    int element = 4;
    //sorted array test cases
    int[] arr = {1, 1, 2, 3, 3, 3, 4, 4, 13, 15, 20}; //[6, 7]
    //int[] arr = {1, 1, 2, 3, 3, 4, 4, 5, 13, 15, 20}; //[5, 6]
    //int[] arr = {1, 1, 2, 3, 4, 4, 5, 5, 13, 15, 20}; //[4, 5]
    //int[] arr = {4, 4, 5, 5, 6, 7, 8, 8, 13, 15, 20}; //[0, 1]
    //int[] arr = {4, 4, 5, 5, 6, 7, 8, 8, 13, 15};     //[0, 1]
    //int[] arr = {1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4};    //[9, 10]
    //int[] arr = {1, 2, 2, 2, 2, 3, 3, 3, 4, 4};       //[8, 9]
    //run the solution
    //int[] answer = findIndicesRecursive(arr, element);  
    int[] answer = findIndicesIterative(arr, element);  
    
    System.out.print(Arrays.toString(answer)); 
  }
}