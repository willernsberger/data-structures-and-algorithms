import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// HackerRank practice problem Mark and Toys
// https://www.hackerrank.com/challenges/mark-and-toys/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting&h_r=next-challenge&h_v=zen

public class MaximumToys {

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        int count = 0;
        PriorityQueue<Integer> cart = new PriorityQueue<>(Comparator.reverseOrder());

        // create an empty max heap representing a shopping cart
        // go through the toys in the prices array
        // if a toy can be bought, add it to the cart, decrease k, increment count
        // otherwise, figure out if it is cheaper than the priciest in cart
            // if it could be bought, evict priciest from the heap...
            // add to k the cost of priciest
            // add the new toy to the heap
            // decrease k for the cost of the new toy

        for(int i = 0; i < prices.length; i++){
            if(prices[i] <= k){
                cart.add((Integer)prices[i]);
                k -= prices[i];
                count++;
                System.out.println(k);
            }
            else if(cart.peek() != null && prices[i]  <= k + cart.peek().intValue() 
                    && prices[i] < cart.peek().intValue()){
                        k += cart.peek().intValue();
                        cart.remove();
                        k -= prices[i]; 
                        cart.add((Integer)prices[i]);
            }
        }

        return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
