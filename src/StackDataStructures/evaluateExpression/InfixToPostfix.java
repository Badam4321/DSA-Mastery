package StackDataStructures.evaluateExpression;
import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        String infix = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("Infix expression is " + infix);
        String postfix = infixT0Postfix(infix);
        //abcd^e-fgh*+^*+i-
        System.out.println("postfix expression is " +postfix);
    }

    private static String infixT0Postfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(char ch : infix.toCharArray()){
            if(isOperand(ch)){
                postfix.append(ch);
            } else if (ch == '(') {
                st.push(ch);
            }
            else if(ch == ')'){
                while (!st.isEmpty() && st.peek() != '(')
                    postfix.append(st.pop());
                st.pop();
            }
            else {
                while (!st.isEmpty() && getPrecedence(ch) <= getPrecedence(st.peek())) {
                    postfix.append(st.pop());
                }
                st.push(ch);
            }
        }
        while (!st.isEmpty()){
            postfix.append(st.pop());
        }
        return postfix.toString();

    }

    private static boolean isOperand(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
    }
    private static int getPrecedence(char ch){
        if(ch == '^')
            return 2;
        else if(ch == '*' || ch == '/')
            return 1;
        else if(ch == '+' || ch == '-')
            return 0;
        return -1;

    }
}
/*
Rules for converting from infix notation to postfix notation
1)Scan from left to right
2) if operand --> postfix exp
3) if '(' --> push into stack
4) if ')' --> pop the stack until '('
5)if operator --> precedence
i) new operator > top of the stack --> push new operator into stack
ii) if new operator <= top of the stack --> pop from the stack until found the greater precedence at the top of the stack.
6) repeat the expression is scanned
7) if stack is not empty , pop it from stack and placed into postfix.
 */
