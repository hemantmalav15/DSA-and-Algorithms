import java.util.*;
public class Solution {
    public void insertIntoStack(Stack<Integer> s, int element){
        if(s.size() == 0 || s.peek() <= element){
            s.push(element);
            return;
        }
        int top = s.pop();
        insertIntoStack(s, element);
        s.push(top);
    }
	public Stack<Integer> sort(Stack<Integer> s)
	{
		if(s.size() == 0){
		    return new Stack<>();
		}
		int top = s.pop();
		Stack<Integer> sortRec = sort(s);
		insertIntoStack(sortRec, top);
		
		return sortRec;
	}
}
