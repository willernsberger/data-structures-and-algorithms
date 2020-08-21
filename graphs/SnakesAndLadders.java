import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SnakesAndLadders {

    // Complete the quickestWayUp function below.
    static int quickestWayUp(int[][] ladders, int[][] snakes) {
        int quickest = -1; //minimum number of rolls
        int sides = 6; //number of sides of the die
        int board = 100; //number of spaces on the board
        //HashMap of Ladders: bottom -> top
        HashMap<Integer, Integer> mLadders = new HashMap<Integer, Integer>();
        for (int i = 0; i < ladders.length; i++){
            mLadders.put((Integer)ladders[i][0], (Integer)ladders[i][1]);
        }
        //HashMap of Snakes: head -> tail
        HashMap<Integer, Integer> mSnakes = new HashMap<Integer, Integer>();
        for (int i = 0; i < snakes.length; i++){
            mSnakes.put((Integer)snakes[i][0], (Integer)snakes[i][1]);
        }
        //HashMap of the fewest rolls for a given position: position -> rolls
        HashMap<Integer, Integer> mQuickest = new HashMap<Integer, Integer>();
        //Queue of positions to be evaluated
        ArrayList<Integer> queue = new ArrayList<Integer>();

        //Add the starting position to the queue and traverse
        mQuickest.put((Integer)1, (Integer)0);
        queue.add((Integer)1);
        while (queue.size() > 0){
            Integer position = queue.remove(0);
            Integer rolls = mQuickest.get(position);
            System.out.print("Position: " + position + " ");
            System.out.println("Rolls: " + rolls);
            if (mSnakes.get(position) !=null){ // snake...
                Integer tail = mSnakes.get(position);
                if(mQuickest.get(tail) == null){
                    queue.add(tail);
                    mQuickest.put(tail, rolls);
                }
            } 
            else if (mLadders.get(position) != null){ // ladder...
                Integer top = mLadders.get(position);
                if(mQuickest.get(top) == null){
                    queue.add(top);
                    mQuickest.put(top, rolls);
                }
            } 
            else {
                for(int i = 1; i <= sides; i++){
                    if((position.intValue() + i) <= board){ //check for over rolling
                        if ((position.intValue() + i) == board){
                            if(mQuickest.get((Integer)board) == null){
                                mQuickest.put((Integer)board, rolls + (Integer)1);
                            }
                            else if(rolls + (Integer)1 < mQuickest.get((Integer)board)) {
                                mQuickest.put((Integer)board, rolls + (Integer)1);
                            }
                        }
                        else {
                            if(mQuickest.get(position + (Integer)i) == null){
                                queue.add(position + (Integer)i);
                                mQuickest.put(position + (Integer)i, rolls + (Integer)1);
                            }
                        }
                    } 
                }
            }
        }
        
        if(mQuickest.get((Integer)board) != null){
            quickest = mQuickest.get((Integer)board).intValue();
        }
        return quickest;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] ladders = new int[n][2];

            for (int i = 0; i < n; i++) {
                String[] laddersRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int laddersItem = Integer.parseInt(laddersRowItems[j]);
                    ladders[i][j] = laddersItem;
                }
            }

            int m = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] snakes = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] snakesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int snakesItem = Integer.parseInt(snakesRowItems[j]);
                    snakes[i][j] = snakesItem;
                }
            }

            int result = quickestWayUp(ladders, snakes);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
