import java.util.*;

//Non dynamic programming solution.
//The recursive call stack gets quite deep with large n.
//Lots of repetition of work.
public class Fibonacci {

    public static int fibonacci(int n) {
        //Base cases
        if(n == 0) return 0;
        if(n == 1) return 1;

        //Recursion
        return fibonacci(n-1) + fibonacci(n-2);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}