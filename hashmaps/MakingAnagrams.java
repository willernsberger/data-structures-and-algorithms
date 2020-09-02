import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// HackerRank practice problem Making Anagrams
// https://www.hackerrank.com/challenges/ctci-making-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings


public class MakingAnagrams {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        int count = 0;

        //create map
        //populate map from strings a and b...
            //by incrementing the value when we see it in a...
            //and decrementing the value when we see it in b
        //evaluate the map
            //the absolute value of the keys represent characters that need removed

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for(int i = 0; i < a.length(); i++){
            Character c = (Character)a.charAt(i);
            if (map.get(c) == null) map.put(c, (Integer)1);
            else map.put(c, map.get(c) + (Integer)1);
        }

        for(int i = 0; i < b.length(); i++){
            Character c = (Character)b.charAt(i);
            if (map.get(c) == null) map.put(c, (Integer)(-1));
            else map.put(c, map.get(c) + (Integer)(-1));
        }

        for(Integer i : map.values()){
            count += Math.abs(i.intValue());
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
