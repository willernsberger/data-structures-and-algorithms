import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        for (int q = 0; q < queries; q++){
            int type = scanner.nextInt();
            switch(type){
                case 1:
                    heap.add((Integer)scanner.nextInt());
                    break;
                case 2:
                    heap.remove((Integer)scanner.nextInt());
                    break;
                case 3:
                    System.out.println(heap.peek());
                    break;
            }
        }
        scanner.close();
    }
}