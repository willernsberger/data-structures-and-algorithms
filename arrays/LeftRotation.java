import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LeftRotation {

    // Completed rotLeft function.  O(n)
    static int[] rotLeft(int[] a, int d) {
        int rotation = d%a.length;
        int[] b = new int[a.length];
        //System.out.println("rotation: " + rotation);
        for (int index = 0; index < a.length; index++){
            System.out.println("a index: " + index);
            if (index - rotation >= 0){
                b[index - rotation] = a[index];
                System.out.println("b index: " + (index - rotation));
            } 
            else{
                int overflow = rotation - index;
                b[a.length - overflow] = a[index];
                System.out.println("b index: " + (a.length - 1 - overflow));
            }
        }
        return b;
    }

    // First attempt.  O(d*n)
    // Less performant because it performs the assignment operation loop
    // within a rotation loop.
    /*static int[] rotLeft(int[] a, int d) {
        int temp;
        for (int i = 0; i < d; i++){
            System.out.println("i: " + i);
            temp = a[0];
            for(int j = 0; j < a.length - 1; j++){
                System.out.println("j: " + j);
                System.out.println("a[j]: " + a[j]);
                a[j] = a[j+1];
            }
            a[a.length - 1] = temp;
        }
        return a;
    } */


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

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
