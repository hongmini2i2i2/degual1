import java.util.Arrays;

public class MyQueue {

    int[] queue;
    int front, rear, size;

    public MyQueue(int n) {
        size = n;
        queue = new int[n];
        front = 0;
        rear = 1;
    }

    public  boolean isEmpty() {
        return (front + 1) % size == rear; //rear == 다음요소가삽입될인덱스
    }

    public boolean isFull() {
        return front == rear;
    }

    public void enqueue(int value) {
        if(isFull()) {
            System.out.println("Queue is full");
            return;
        } else {
            queue[rear] = value;
            rear = (rear + 1) % size;
        }
    }

    public int dequeue() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return -999;
        } else {
            front = (front + 1) % size;
            return queue[front];
        }
    }

    public void showQueue() {
        System.out.println(Arrays.toString(queue));
    }

    public static void main(String[] args) {
        int [] data= {3,5,4,1,7,2,9,8,6,0};


        MyQueue queue = new MyQueue(10);

        for (int i=0; i<data.length;i++) {
            queue.enqueue(data[i]);
            queue.showQueue();
        }

        for (int i=0; i<data.length;i++) {
            System.out.println(queue.dequeue());
        }
    }
}
