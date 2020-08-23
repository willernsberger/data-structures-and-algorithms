import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class IceCreamParlor {

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        int sunny = -1;
        int johnny = -1;
        int remainder;
        Map<Integer, List<Integer>> mCostIndex = createCostMap(cost);  
        

        // Iterate across the flavors array...
        // Subtract the flavor's price from money to find a remainder.
        // Check the HashMap to see if there is a flavor with a price that matches
        // the remainder.
        for(sunny = 0; sunny < cost.length; sunny++){
            remainder = money - cost[sunny];
            if (mCostIndex.get((Integer)remainder) != null){
                johnny = mCostIndex.get((Integer)remainder).get(0).intValue();
                if (sunny != johnny) break;
                if (mCostIndex.get((Integer)remainder).size() > 1){
                    johnny = mCostIndex.get((Integer)remainder).get(1).intValue();
                    break;
                }
            }
        }
        sunny++;
        johnny++;
        if (sunny < johnny) System.out.println(sunny + " " + johnny);
        else System.out.println(johnny + " " + sunny);  
    }

    private static Map<Integer, List<Integer>> createCostMap(int[] menu){
        Map<Integer, List<Integer>> mCostIndex = new HashMap<Integer, List<Integer>>();
        for (int flavor = 0; flavor < menu.length; flavor++){
            int price = menu[flavor];
            if (mCostIndex.get((Integer)price) == null){ //start a list at that price
                List<Integer> list = new LinkedList<Integer>();
                list.add((Integer)flavor);
                mCostIndex.put((Integer)price, list);
            } else { //add to the list
                List<Integer> list = mCostIndex.get((Integer)price);
                list.add((Integer)flavor);
                mCostIndex.put((Integer)price, list);
            }
        }
        return mCostIndex;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
