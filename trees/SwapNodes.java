import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class SwapNodes {

    static void swap(int[][] indexes, int node, int depth, int query){
        int left = indexes[node-1][0];
        int right = indexes[node-1][1];
        if(depth%query == 0){ //check for swap condition
            indexes[node-1][0] = right;
            indexes[node-1][1] = left;
        }
        if(left != -1){ //left child
            swap(indexes, left, depth +1, query);
        }
        if(right != -1){ //right child
            swap(indexes, right, depth +1, query);
        }
    }

    static void traverse(ArrayList<Integer> list, int[][] indexes, int node){
        int left = indexes[node-1][0];
        int right = indexes[node-1][1];
        if(left != -1){ //left child
            traverse(list, indexes, left);
        }
        list.add((Integer)node);
        if(right != -1){ //right child
            traverse(list, indexes, right);
        }
    }

    static int[][] swapNodes(int[][] indexes, int[] queries) {
        
        int[][] output = new int[queries.length][indexes.length];

        for(int q = 0; q < queries.length; q++){
            int root = 1;
            int depth = 1;
            int query = queries[q];
            swap(indexes, root, depth, query);
            ArrayList<Integer> list = new ArrayList<Integer>();
            traverse(list, indexes, root);
            int position = 0;
            for (Integer i : list){
                output[q][position] = i.intValue();
                position++;
            }
        }

        return output;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
