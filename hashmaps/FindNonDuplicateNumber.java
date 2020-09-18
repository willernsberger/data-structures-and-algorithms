import java.io.*;
import java.util.*;

//Daily Interview Pro Daily Problem Find the Non-Duplicate Number [9.18.2020]
//Given a list of numbers, find the single non-duplicate number.
//This solution has O(n) runtime with respect to the count of numbers in the list

class FindNonDuplicateNumber {

  public static void main(String[] args) {    
    //test cases 
    int[] numbers = {4, 4, 3, 3, 2, 2, 1}; //1
    //int[] numbers = {4, 3, 4, 3, 2, 1, 1, 5, 5}; //2
    //int[] numbers = {1, 3, 1}; //3  
    //int[] numbers = {1, 2, 3, 4, 1, 2, 3}; //4
    
    //create a Set
    Set<Integer> set = new HashSet<Integer>();
    //iterate across numbers, adding to the Set or removing
    for (int i = 0; i < numbers.length; i++){
      //check if numbers[i] is in the set
      //remove if it is
      //otherwise, add it
      if (set.contains((Integer)numbers[i])){
        set.remove((Integer)numbers[i]);
      } else {
        set.add((Integer)numbers[i]);
      }
    }
    //evaluate the Set
    Iterator<Integer> iterator = set.iterator();
    System.out.println(iterator.next());
  } 
}