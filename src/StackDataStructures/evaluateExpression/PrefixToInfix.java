package StackDataStructures.evaluateExpression;
import java.util.Stack;

public class PrefixToInfix {
    public static void main(String[] args) {
        String prefix = "*-A/BC-/AKL";
        System.out.println("prefix is : " + prefix);
        System.out.println("infix is : " + preToInfix(prefix));

    }
    static String preToInfix(String exp) {
        // code here
        Stack<String> st = new Stack<>();
        for(int i = exp.length() -1 ; i >= 0 ; i--){
            char ch = exp.charAt(i);
            if(isOperand(ch)){
                st.push(ch+"");
            }
            else{
                String t1 = st.pop();
                String t2 = st.pop();
                String expression = "(" + t1 + ch + t2 + ")";
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
