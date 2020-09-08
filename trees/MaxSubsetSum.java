import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

//A BFS solution to HackerRank practice problem Max Array Sum.
//Will fail to meet HackRank time limits with a sufficiently large array length.
//https://www.hackerrank.com/challenges/max-array-sum/problem

public class MaxSubsetSum {

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

        Node node;

        //create a queue
        List<Node> list = new ArrayList<Node>();
        list.add(root);
        while(list.isEmpty() != true){
            //remove the first element in the queue
            node = list.remove(0);

            //if a leaf, evaluate for max and continue
            if(node.pointer >= arr.length){
                if(node.value > max) max = node.value;
                //System.out.println("node.value: " + node.value);
                continue;
            }
            //create, then add left child to queue
            node.left = new Node();
            node.left.pointer = node.pointer +1;
            node.left.value = node.value;
            list.add(node.left);
            //create, then add right child to queue
            node.right = new Node();
            node.right.pointer = node.pointer + 2;
            node.right.value = node.value + arr[node.pointer];
            list.add(node.right);
        }

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
