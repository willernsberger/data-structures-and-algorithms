import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class InsertionSortPart1 {

    // Complete the insertionSort1 function below.
    static void insertionSort1(int n, int[] arr) {

        int index = arr.length -1;
        int value = arr[index];
        while (index >= 0){
            if(index == 0){
                arr[index] = value;
                printTheArray(arr);
                break;  
            }
            if(value < arr[index-1]){
                arr[index] = arr[index-1];
                printTheArray(arr);
                index--;
            } else {
                arr[index] = value;
                printTheArray(arr);
                break;
            }
        }
    }

    static void printTheArray(int[] arr){
        String s = new String();
        for (int i = 0; i < arr.length; i++){
            s += arr[i];
            s += " ";
        }
        s.trim();
        System.out.println(s);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        insertionSort1(n, arr);

        scanner.close();
    }
}
