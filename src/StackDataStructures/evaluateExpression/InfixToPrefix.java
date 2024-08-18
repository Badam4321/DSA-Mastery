package StackDataStructures.evaluateExpression;
import java.util.Stack;

public class InfixToPrefix {

    // Function to return precedence of operators
    static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // Function to convert infix to postfix
    static String infixToPostfix(String infix) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            // If the character is an operand, add it to output
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }
            // If the character is '(', push it to stack
            else if (c == '(') {
                stack.push(c);
            }
            // If the character is ')', pop and output from the stack until an '(' is encountered
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            }
            else { // an operator is encountered
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop all the operators from the stack
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    // Function to reverse the given expression
    static String reverse(String expression) {
        StringBuilder reversed = new StringBuilder(expression).reverse();
        for (int i = 0; i < reversed.length(); i++) {
            if (reversed.charAt(i) == '(') {
                reversed.setCharAt(i, ')');
            } else if (reversed.charAt(i) == ')') {
                reversed.setCharAt(i, '(');
            }
        }
        return reversed.toString();
    }

    // Function to convert infix to prefix
    static String infixToPrefix(String infix) {
        // Step 1: Reverse the infix expression
        String reversedInfix = reverse(infix);

        // Step 2: Convert the reversed infix expression to postfix
        String postfix = infixToPostfix(reversedInfix);

        // Step 3: Reverse the postfix expression
        String prefix = new StringBuilder(postfix).reverse().toString();

        return prefix;
    }

    public static void main(String[] args) {
        String infix = "(A-B/C)*(A/K-L)";
        System.out.println("Infix Expression: " + infix);
        System.out.println("Prefix Expression: " + infixToPrefix(infix));
    }

}
