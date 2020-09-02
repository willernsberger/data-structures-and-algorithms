import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// HackerRank practice problem Sorting: Bubble Sort 
// https://www.hackerrank.com/challenges/ctci-bubble-sort/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting

public class CountBubbleSortSwaps {

    // Complete the countSwaps function below.
    static void countSwaps(int[] a) {

        int swaps = 0;

        //do this n times where n is the number of elements in the array...
            //compare value at a[0] and a[1]
            //swap if a[0] is greater than a[1]
            //compare value at [1] and [2]...
            //swap if... etc.

        for(int i = 0; i < a.length-1; i++){
            for(int j = 0; j < a.length-1; j++){
                if (a[j] > a[j+1]){
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                    swaps++;
                } 
            }
        }

        System.out.println("Array is sorted in " + swaps + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length-1]);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        countSwaps(a);

        scanner.close();
    }
}
