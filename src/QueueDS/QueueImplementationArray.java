package QueueDS;
class Queue{
    int[] arr;
    int front , rear , currentSize , size;
    Queue(int size){
        arr = new int[size];
        front = -1;
        rear = -1;
        this.size = size;
        this.currentSize = 0;
    }
    void push(int x){
        if(currentSize == size){
            System.out.println("Queue is Full");
        }
        if(currentSize == 0){
            front = 0 ;
            rear = 0;
        }
        else{
            rear = (rear + 1) % size;
        }
        arr[rear] = x;
        currentSize++;

    }
    int pop(){
        if(currentSize == 0){
            System.out.println("Queue Empty\nExiting...");
            System.exit(1);
        }
        int temp = arr[front];
        if(currentSize == 1){
            front = -1;
            rear = -1;
        }
        else{
            front = (front + 1) % size;
        }
        currentSize--;
        return temp;


    }
    int top(){
        if(currentSize == 0){
            System.out.println("Queue Empty\nExiting...");
            System.exit(1);
        }
        return arr[front];

    }
    int getSize(){
        return currentSize;

    }
}
public class QueueImplementationArray {
    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.push(10);
        queue.push(20);
        queue.push(30);
        System.out.println(queue.pop());
        System.out.println(queue.top());
        System.out.println(queue.getSize());

    }
}
