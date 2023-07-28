import java.util.Stack;

public class Main {

    public int minAddToMakeValid(String s) {
        // use stack
        Stack<Character> stack = new Stack<>();
        int count = 0;
        
        // run a loop till strings length
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            //if opening bracket comes put it into stack
            if(ch == '('){
                stack.push(ch);
            }
            //if closing bracket comes there can be 2 cases
            else{
            // 1. if stack is empty that means for this parentheses we have to add one closing ')'
                if(stack.size() == 0){
                    count++;
                }
                // 2. stack not empty that means top of stack contains '(' and closing parantheses
                // comes so remove opening bcoz it is valid 
                else{
                    stack.pop();
                }
            }
        }
        // consider a case where all the opening parentheses are there so we have to add size of 
        // stack bcoz all opening parantheses will be in the stack
        count += stack.size();
        return count;
    }
}
