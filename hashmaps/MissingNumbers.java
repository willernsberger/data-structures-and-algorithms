import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    //Complete the nums function below.
    static int[] nums(int[] missing, int[] original) {
        //TreeMap: number -> count of that number
        TreeMap<Integer, Integer> mNumbers = new TreeMap<Integer, Integer>();

        //iterate through original, populating the TreeMap
        for (int i : original){
            if(mNumbers.get((Integer)i) == null){
                mNumbers.put((Integer)i, (Integer)1);
            } else {
                mNumbers.put((Integer)i, mNumbers.get((Integer)i) + (Integer)1);
            }
        }

        //iterate through missing, decrementing the TreeMap
        for (int i : missing){
            mNumbers.put((Integer)i, mNumbers.get((Integer)i) - (Integer)1);
        }

        //iterate through the TreeMap and add to the output array
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : mNumbers.entrySet()){
            if(entry.getValue() > 0){
                list.add(entry.getKey());
            }
        }
        int[] nums = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            nums[i] = list.get(i).intValue();
        }
        return nums;

 
 
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

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] brr = new int[m];

        String[] brrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrItems[i]);
            brr[i] = brrItem;
        }

        int[] result = nums(arr, brr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
