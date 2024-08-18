package StackDataStructures.monotonic;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class PrevAndNextGreator {
    public static void main(String[] args) {
        int[] arr = {10 , 4 , 2 , 20 , 40 , 12 , 30};
        int[] prev = prveGreator(arr);
        int[] next = nextGreator(arr);
        System.out.println(Arrays.toString(prev));
        System.out.println(Arrays.toString(next));
    }

    private static int[] nextGreator(int[] arr) {
        int n = arr.length;
        int[] prev = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1 ; i >= 0 ; i--){
            while (!st.isEmpty() && st.peek() <= arr[i])
                st.pop();
            prev[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }
        return prev;


    }

    private static int[] prveGreator(int[] arr) {
        int n = arr.length;
        int[] prev = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            while (!st.isEmpty() && st.peek() <= arr[i])
                st.pop();
            prev[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }
        return prev;
    }

}
