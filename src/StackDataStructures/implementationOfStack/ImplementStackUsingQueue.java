package StackDataStructures.implementationOfStack;

import java.util.LinkedList;
import java.util.Queue;

class stack{
    Queue<Integer> q = new LinkedList<>();
    void push(int x){
        q.add(x);
        for(int i = 0 ; i < q.size() - 1 ; i++){
            q.add(q.poll());
        }
    }
    int pop(){
        return q.poll();
    }
    int top(){
        return q.peek();
    }
    int size(){
        return q.size();
    }

}
public class ImplementStackUsingQueue {
    public static void main(String[] args) {
        stack st = new stack();
        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println(st.pop());

    }
}
/*
push(): Insert the element in the stack.
pop(): Remove and return the topmost element of the stack.
top(): Return the topmost element of the stack
size(): Return the size of the stack

Take a single queue.
push(x): Push the element in the queue.
Use a for loop of size()-1, remove element from queue and again push back to the queue, hence the most recent element becomes the most former element and vice versa.
pop(): remove the element from the queue.
top(): show the element at the top of the queue.
size(): size of the current queue.
 */
