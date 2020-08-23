import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MigratoryBirds {

    // Complete the migratoryBirds function below.
    // O(n+k) where n is the number of sightings and k is number of different bird types
    static int migratoryBirds(List<Integer> sightings) {
        Integer type = (Integer)0;   // the bird type with the most sightings
        Integer count = (Integer)0;  // the number of sightings
        // Map bird type -> sightings 
        Map<Integer, Integer> birds = new HashMap<Integer, Integer>();
        for (Integer bird : sightings){
            if(birds.containsKey(bird)){
                birds.put(bird, birds.get(bird) + (Integer)1);
            } else {
                birds.put(bird, (Integer)1);
            }
        }
        // Evaluate our map to determine the bird type with the most sightings
        for (Integer bird : birds.keySet()){
            if (birds.get(bird) > count){
                type = bird;
                count = birds.get(bird);
            } else if (birds.get(bird) == count && bird < type){
                type = bird;
            }
        }
        return type.intValue();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
