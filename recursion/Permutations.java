import java.io.*;
import java.util.*;

//CoderPro Coding Session 8
//Given an array of numbers, return every permutation. 
//For example, [1, 2, 3] would return six permutations: 
//[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], and [3, 2, 1].
//This solution is implement in O(n!) time with respect to the number of numbers in the array
//with O(n) space requirement for the depth first traversal call stack and O(n!) space 
// requirement for the solution.

class Permutations {

  //helper function
  private static ArrayList<ArrayList<Integer>> permutations(ArrayList<Integer> numbers){
    //call traverse as the root in the traversal
    ArrayList<Integer> permutation = new ArrayList<Integer>();
    ArrayList<ArrayList<Integer>> combinations = new ArrayList<ArrayList<Integer>>();
    return traverse(numbers, permutation, combinations);
  }
  
  private static ArrayList<ArrayList<Integer>> traverse(ArrayList<Integer> numbers, ArrayList<Integer> permutation, ArrayList<ArrayList<Integer>> combinations){  
    //base case, empty set of numbers
    //create our combination, add it to the 2D array, return the 2D array
    if (numbers.size() == 0){
      combinations.add(permutation);
      return combinations;
    }
    //traverse each child number
    //child returns combinations
    //pass combinations to the next child
    for(int i = 0; i < numbers.size(); i++){
      ArrayList<Integer> childNumbers = new ArrayList<Integer>(numbers);
      childNumbers.remove(i);
      ArrayList<Integer> childPermutation =  new ArrayList<Integer>(permutation);
      childPermutation.add(numbers.get(i));  
      combinations = traverse(childNumbers, childPermutation, combinations);
    }
    //return combinations to the parent
    return combinations;
  }
  
  public static void main(String[] args) {
    //test array
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    numbers.add(0, (Integer) 3);
    numbers.add(0, (Integer) 2);
    numbers.add(0, (Integer) 1); 
    
    ArrayList<ArrayList<Integer>> combinations = permutations(numbers);
    System.out.print(combinations);
  }
}