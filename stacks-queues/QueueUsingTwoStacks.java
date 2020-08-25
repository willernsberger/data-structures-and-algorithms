import java.io.*;
import java.util.*;

class Queue {
    Stack<Integer> head = new Stack<Integer>();
    Stack<Integer> tail = new Stack<Integer>();

    public Queue(Stack<Integer> head, Stack<Integer> tail){
        this.head = head;
        this.tail = tail;
    }

    public void enqueue(Integer e){
        tail.push(e);
    }

    public void dequeue(){
        if(head.empty()) rebalance();
        if(!head.empty()) head.pop();
    }

    private void rebalance(){
        while(!tail.empty())
            head.push(tail.pop());
    }

    public void print(){
            if(head.empty()) rebalance();
            System.out.println(head.peek());
    }
}

public class QueueUsingTwoStacks {

    public static void main(String[] args) {
        Stack<Integer> head = new Stack<Integer>();
        Stack<Integer> tail = new Stack<Integer>();
        Queue queue = new Queue(head, tail);
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        for(int q = 0; q < queries; q++){
            int type = scanner.nextInt();
            switch(type){
                case 1:
                    queue.enqueue(scanner.nextInt());
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.print();
                    break;
            }
        }
        scanner.close();



    }
}