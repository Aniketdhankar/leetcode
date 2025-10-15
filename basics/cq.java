
import java.util.*;

class Cq {
    int[] q;
    int front, rear, size;

    Cq(int size) {
        this.size = size;
        q = new int[size];
        front = rear = -1;
    }

    boolean isFull() {
        return (rear + 1) % size == front;
    }

    boolean isEmpty() {
        return front == -1;
    }

    void enqueue(int val) {
        if (isFull()) {
            System.out.println("Queue Full");
            return;
        }
        else if (front == -1) {
        		
        	front = 0;
        }else {
        rear = (rear + 1) % size;
        q[rear] = val;
        System.out.println(val + " inserted");
    }
    }

    void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return;
        }
        System.out.println(q[front] + " removed");
        if (front == rear) {
        	front = rear = -1; 
        }
        else front = (front + 1) % size;
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return;
        }

System.out.print("Queue: ");
        int i = front;
        while (true) {
            System.out.print(q[i] + " ");
            if (i == rear) break;
            i = (i + 1) % size;
        }
        System.out.println();
    }
}