import java.io.*;
import java.util.*;

//CoderPro Coding Session 3 Ransom Note
//https://www.techseries.dev/products/coderpro/categories/1831147/posts/6231429
//runs in O(m + n) where m in the number of letters in the magazine and n is the number of letters in the note
//O(1) space complexity since m is the number of possible letters, which is bounded to a constant...
//the number of letters in the alphabet

public class RansomNote {
	  
	  private static boolean evaluate(Map<Character, Integer> map, Character[] note){
	    for (Character C : note){
	      if (map.get(C) != null && map.get(C) > Integer.valueOf(0)){
	        map.put(C, map.get(C) - 1); 
	      } else return false; 
	    }
	    return true;
	  }
	  
	  public static void main(String[] args) {    
	    //make a magazine and ransom note
	    Character[] magazine = {'R', 'A', 'N', 'S', 'O', 'M', 'N', 'O', 'T', 'E'};
	    Character[] note = {'R', 'A', 'N', 'S', 'O', 'M', 'N', 'O', 'T', 'E'};
	    //create a HashMap
	    Map<Character, Integer> map = new HashMap<Character, Integer>();
	    //add letter from the magazine array to the HashMap
	    for (int i = 0; i < magazine.length; i++){
	      if (map.get(magazine[i]) == null) {
	        map.put(magazine[i], Integer.valueOf(1));
	      }
	      else map.put(magazine[i], map.get(magazine[i]) + Integer.valueOf(1));
	    }
	    //check the HashMap against the ransom note array
	    System.out.println(evaluate(map, note));
	  } 
	}
