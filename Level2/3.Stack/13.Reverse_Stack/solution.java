import java.util.Stack;
class Solution
{ 
    static void insertAtBottom(Stack<Integer> s, int element){
        if(s.size() == 0){
            s.push(element);
            return;
        }
        
        int top = s.pop();
        insertAtBottom(s, element);
        s.push(top);
    }
    // reverse a stack recursively
    static void reverse(Stack<Integer> s)
    {
        if(s.size() == 0){
            return;
        }
        int top = s.pop();
        reverse(s);
        insertAtBottom(s, top);
    }
}