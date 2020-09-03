import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// HackerRank practice prbolem MaxMin 
// https://www.hackerrank.com/challenges/angry-children/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms

public class Fairness {

    // Complete the maxMin function below.
    static int maxMin(int k, int[] arr) {

        // sort arr
        // look at the first element and element k, calculate fairness
        // look at the second elelemnt and element k+1, calculate fairness
        // etc.
        // memo the lowest fairness as we traverse arr

        Arrays.sort(arr);
        int lowest = arr[k-1] - arr[0];
        for(int i = 0; i <= arr.length - k; i++){
            int fairness = arr[(i+k-1)] - arr[i];
            if (fairness < lowest) lowest = fairness;
        }

        return lowest;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        int result = maxMin(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
