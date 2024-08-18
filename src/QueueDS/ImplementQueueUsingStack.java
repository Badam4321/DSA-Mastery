package QueueDS;
import java.util.Stack;

class Queue1 {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    void push(int x) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    int pop() {
        if (!s1.isEmpty())
            return s1.pop();
        return -1;  // Return -1 if queue is empty
    }

    int top() {
        return s1.peek();
    }

    int getSize() {
        return s1.size();
    }
}

public class ImplementQueueUsingStack {
    public static void main(String[] args) {
        Queue1 q = new Queue1();
        q.push(10);
        q.push(20);
        q.push(30);
        System.out.println(q.pop());  // Should print 10
        q.push(40);
        System.out.println(q.top());  // Should print 20
        System.out.println(q.getSize());  // Should print 3
    }
}

/*
s1 -> s2
x -> s1
s2 -> s1
 */
