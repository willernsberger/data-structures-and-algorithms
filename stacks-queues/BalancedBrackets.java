import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BalancedBrackets {

    //create a stack
    //create a for loop to iterate across the expression
    //open bracket/brace/parens add to the stack
    //close bracket/brace/parens check the top,
        //remove the top if there is a match
        //return "NO" if it is not a match
    //close bracket/brace/parens without a mate return "NO"
    //exiting the for loop with an elemtent(s) return "NO"
    //exiting the for loop with an empty stack returns "YES" 
    public static String Balanced(String expression){
        Stack<String> stack = new Stack<String>();
        for(int i = 0;  i < expression.length(); i++){
            String c = expression.substring(i, i+1);
            if(c.equals("(") || c.equals("[") || c.equals("{")){ //open character
                stack.push(c); //add to the stack
            } else if (c.equals(")") || c.equals("]") || c.equals("}")) { //closing
                if (stack.isEmpty()){
                    return "NO";
                }
                else if (c.equals(")") && stack.peek().equals("(")){ //check for match
                    stack.pop();
                }
                else if (c.equals("]") && stack.peek().equals("[")){ //check for match
                    stack.pop();
                }
                else if (c.equals("}") && stack.peek().equals("{")){ //check for match
                    stack.pop();
                }
                else return "NO"; //return "NO" if no match
            }
        }
        if (!stack.empty()) return "NO"; //stack not empty return "NO"
        return "YES"; //stack empty return "YES"
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String expression = scanner.nextLine();





            System.out.println(Balanced(expression));
        }

        scanner.close();
    }
}
