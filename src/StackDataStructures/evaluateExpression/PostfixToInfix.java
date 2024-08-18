package StackDataStructures.evaluateExpression;
import java.util.Stack;
public class PostfixToInfix {
    public static void main(String[] args) {
        String posfix = "ab*c+";
        System.out.println("postfix is  : " + posfix);
        System.out.println("Infix is : " + posfixToInfix(posfix));
    }

    private static String posfixToInfix(String exp) {
        Stack<String> st = new Stack<>();
        for(char ch : exp.toCharArray()){
            if(isOperand(ch)){
                st.push(ch+"");
            }
            else{
                String t1 = st.pop();
                String t2 = st.pop();
                String expression = "(" + t2 + ch + t1 + ")";
                st.push(expression);

            }

        }
        return st.pop();
    }
    static boolean isOperand(char ch){
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
    }
}
