import java.io.*;
import java.util.*;

public class CorrectnessAndTheLoopInvariant {

    public static void insertionSort(int[] A){
        for(int i = 1; i < A.length; i++){


            //value = A[i];
            //compare value with A[0], swap if value is lower
            //compare with next element in the array, swap if value is lower etc...
            //eventually, compare A[i] with value and swap if value is lower.

            //int value
            //j = i
            //compare A[j] with A[j-1]
            //if A[j-1] <= A[j], done with this iteration... increment i
            //if A[j-1] > A[j], swap values of A[j] and A[j-1] using value as a temp
                //decrement j, if out of elements done with this iteration... increment i



            int value = A[i];
            int j = i - 1; 
            while(j >= 0 && A[j] > value){ 
                A[j + 1] = A[j];
                j = j - 1; 
            }
            A[j + 1] = value;
        }

        printArray(A);
    }


    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt();
        }
        insertionSort(ar);
    }
}

