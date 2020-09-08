import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// A DFS solution to HackerRank practice problem Max Array Sum.
// Illustrates the issue with call stack overflow in a DFS.
// Will throw a call stack overflow error with a sufficiently large array length.
// https://www.hackerrank.com/challenges/max-array-sum/problem?h_l=interview&isFullScreen=false&playlist_slugs%5B%5D%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D%5B%5D=dynamic-programming

public class MaxArraySum {

    public static class Node{
        int pointer;
        int value;
        Node left;
        Node right;
    }

    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
        int max = 0;

        Node root = new Node();
        root.pointer = 0;
        root.value = 0;
        max = DFS(root, arr);

        return max;
    }

    static int DFS(Node node, int[] arr){
        int max = node.value;
        int rightValue = 0;
        int leftValue = 0;

        System.out.println("node.value: " + node.value);

        //if we are at a leaf, return the value
        if(node.pointer >= arr.length){
            return max;
        }
        //if we are not at a leaf, create and traverse left
            //create left
            node.left = new Node();
            node.left.pointer = node.pointer + 1;
            node.left.value = node.value;
            //traverse left
            leftValue = DFS(node.left, arr);

        //if we are not at a leaf, create and traverse right
            //create right
            node.right = new Node();
            node.right.pointer = node.pointer + 2;
            node.right.value = node.value + arr[node.pointer];
            //traverse right
            rightValue = DFS(node.right, arr);

        //if we are at a non-leaf, evalute and return the value
        if (rightValue > max) max = rightValue;
        if (leftValue > max) max = leftValue;
        return max;
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
