package StackDataStructures.evaluateExpression;
import java.util.Stack;
public class postToPre {
    public static void main(String[] args) {
        String postfix = "ABC/-AK/L-*";
        System.out.println("prefix is "+ posfixToInfix(postfix));
    }
    static String posfixToInfix(String exp) {
        // code here
        Stack<String> st = new Stack<>();
        for(char ch : exp.toCharArray()){
            if(isOperand(ch)){
                st.push(ch+"");
            }
            else{
                String t1 = st.pop();
                String t2 = st.pop();
                String expression = ch + t2 + t1;
                st.push(expression);

            }

        }
        return st.pop();

    }

    //Function to check if char is operand
    static boolean isOperand(char ch){
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
    }
}
