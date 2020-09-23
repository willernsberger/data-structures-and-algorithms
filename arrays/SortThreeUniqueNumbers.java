import java.io.*;
import java.util.*;

//Sorting a List With Three Unique Numbers
//Given a list composed entirely of three unique numbers, sort the list.

//One solution involves using a HashHap.  Scan the list, filling a HashMap 
//with key/value pairs of the number and count of times that number appears
//in the list.  Then repopulate this list from the HashMap.

class SortThreeUniqueNumbers {

  private static int[] sortThreeNumbers(int[] arr){
    //make a treemap from the values in the given array
    TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
    for (int i : arr){
      if (map.containsKey((Integer)i)){
        map.put((Integer)i, map.get((Integer)i) + 1);
      }
      else {
        map.put((Integer)i, (Integer)1);
      } 
    }
    //repopulate the given array from the entries in the treemap
    int pointer = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()){
      Integer key = entry.getKey();
      Integer value = entry.getValue();
      for(int i = 0; i < value; i++){
        arr[pointer] = key.intValue();
        pointer ++;
      }
    }
    return arr;
  }
  
  public static void main(String[] args) {
    //test array
    int[] arr = {1, 2, 3, 1, 2, 3, 1, 2, 3, 2, 2, 3, 3, 1, 1, 2};
    //call the solution, display the result
    int[] solution = sortThreeNumbers(arr);
    System.out.println(Arrays.toString(solution));
  }
}