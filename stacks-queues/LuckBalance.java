import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// HackerRank practice problem Luck Balance
// https://www.hackerrank.com/challenges/luck-balance/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms&h_r=next-challenge&h_v=zen
public class LuckBalance {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {

        // create a min heap
        // iterate across the contests
            // if a contest is unimportant, just add its value to luck
            // fill the heap with the first few "important" contests...
                // increasing luck as we add losses to the heap
            // once the heap is filled, we evaluate each "important" contest
                // if the evaluated "important" contest has higher value
                // than the smallest in the heap..
                    // evict the smallest loss from the heap...
                    // add the luck of the evicted contest (twice)...
                    // subtract the luck of the new contest
        
        int luck = 0;
        PriorityQueue<Integer> losses = new PriorityQueue<Integer>();
        for(int i = 0; i < contests.length; i++){
            if (contests[i][1] == 0){
                luck += contests[i][0];
            }
            else if(k == 0){
                luck -= contests[i][0];
            }
            else if(losses.size() < k){
                losses.add((Integer)contests[i][0]);
                luck += contests[i][0];
            } 
            else if(losses.peek() < contests[i][0]){
                int evicted = losses.remove().intValue();
                luck -= 2*evicted;
                losses.add((Integer)contests[i][0]);
                luck += contests[i][0];
            }
            else if(losses.peek() >= contests[i][0]){
                luck -= contests[i][0];
            }
        }

        return luck;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
