import java.io.*;
import java.util.*;

// DailyInterviewPro Problem Add two numbers as a linked list [9.10.2020]
// You are given two linked-lists representing two non-negative integers. 
// The digits are stored in reverse order and each of their nodes contain a single digit. 
// Add the two numbers and return it as a linked list.


public class LinkedListAddTwoNumbers {

	private static LinkedList<Integer> AddLists(LinkedList<Integer> first, LinkedList<Integer> second){
		LinkedList<Integer> result = new LinkedList<Integer>();
		Integer value = new Integer(0);
		Integer carry = new Integer(0);
		Integer digit = new Integer(0);
		
		if(first.isEmpty() == true && second.isEmpty() == true) {
			result.add(carry); 
			return result;
		}
		
		while(carry.equals((Integer)0) != true || first.isEmpty() != true || second.isEmpty() != true) {
			value = carry;
			carry = (Integer)0;
			if(first.isEmpty() != true) {
				value += first.remove();
			}
			if(second.isEmpty() != true) {
				value += second.remove();
			}
			digit = value%10;
			carry = value/10;
			
			result.add(digit);
			
		}

		return result;
	}
	
	
	// modified from the DailyInterViewPro Problem, the user provides input that is parsed into a LinkedList
	public static void main(String[] args) throws IOException {
		//scan the console input
		Scanner scanner = new Scanner(System.in);
        int firstInt = scanner.nextInt();
        int secondInt = scanner.nextInt();
        scanner.close();
        
		//parse the input arguments into a pair of LinkedList 
		LinkedList<Integer> first =  new LinkedList<Integer>();
		LinkedList<Integer> second =  new LinkedList<Integer>();        
        do {
        	first.add((Integer)firstInt%10);
        	firstInt = firstInt/10;
        } while(firstInt > 0);
        do {
        	second.add((Integer)secondInt%10);
        	secondInt = secondInt/10;
        } while(secondInt > 0);
		
		//call the function, returning a LinkedList
		LinkedList<Integer> result = AddLists(first, second); 
		
		//parse the LinkedList, print a number
		StringBuilder builder = new StringBuilder();
		while(result.size() > 0) {
			builder.append(result.remove().toString());
		}

		System.out.println(builder.toString());  // outputs in reverse order 58,642 -> 24685
		
	}
	
	
	
	
	
	
	
}
