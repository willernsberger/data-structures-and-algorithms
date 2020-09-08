import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

//An iterative solution to HackerRank practice problem Max Array Sum.
//Linear time with respect to size of the array.
//https://www.hackerrank.com/challenges/max-array-sum/problem

public class IterativeMaxSubsetSum {

    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
        int max = 0;

        for(int i = 0; i < arr.length; i++){
            // base cases, no upstream non-adjacent elements
            if(i == 0 || i == 1){
                arr[i] = evaluate(0, arr[i]);
                max = evaluate(max, arr[i]);
                continue;
            }

            // grow the subset sum by finding the closest upstream non-adjacent,
            // and adding this element to it (or not)
            arr[i] = evaluate(arr[i-2], arr[i] + arr[i-2]);

            //evaluate max
            max = evaluate(max, arr[i]);

            //adjust the subset sums
            arr[i-1] = evaluate(arr[i-1], arr[i-2]);
        }

        return max;
    }

    static int evaluate(int A, int B){
        if(A > B) return A;
        return B;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
