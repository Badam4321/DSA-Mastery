package StackDataStructures.evaluateExpression;
import java.util.Stack;
public class PrefixToPostfix {
    public static void main(String[] args) {
        String prefix = "*-A/BC-/AKL";
        System.out.println(preToPost(prefix));
    }
    static String preToPost(String exp) {
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
                String expression =   t1 + t2 + ch ;
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
