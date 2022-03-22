import java.io.*;
import java.util.*;

public class Main {

    // This function tells us that is it operator or not
    public static boolean isOperator(char ch) {
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            return true;
        }
        return false;
    }

    // This expression tells us the precedence of operator
    public static int precedence(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else {
            return 2;
        }
    }

    // This function solve the expression
    public static int solve(int a, int b, char optr) {
        if (optr == '+') {
            return a + b;
        } else if (optr == '-') {
            return a - b;
        } else if (optr == '*') {
            return a * b;
        } else if (optr == '/') {
            return a / b;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        Stack<Character> operator = new Stack<>();
        Stack<Integer> operand = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '(') {
                operator.push(ch);
            } else if (ch >= '0' && ch <= '9') {
                operand.push(ch - '0');
            } else if (ch == ')') {

                while (operator.peek() != '(') {
                    char optr = operator.pop(); // +-x/
                    int v2 = operand.pop();
                    int v1 = operand.pop();
                    int ans = solve(v1, v2, optr);
                    operand.push(ans);
                }
                operator.pop();
            } else if (isOperator(ch)) {
                while (operator.size() > 0 && operator.peek() != '(' && precedence(ch) <= precedence(operator.peek())) {
                    char optr = operator.pop(); // (+,-,x,/)
                    int v2 = operand.pop();
                    int v1 = operand.pop();
                    int ans = solve(v1, v2, optr);
                    operand.push(ans);
                }
                operator.push(ch);
            }
        }
        while (operator.size() != 0) {
            int b = operand.pop();
            int a = operand.pop();

            char ch = operator.pop();
            int ans = solve(a, b, ch);
            operand.push(ans);
        }
        System.out.println(operand.pop());
    }
}