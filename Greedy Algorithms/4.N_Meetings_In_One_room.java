import java.util.*;
class Solution 
{
    static class Pair implements Comparable<Pair>{
        int start;
        int end;
        
        public Pair(int start, int end){
            this.start = start;
            this.end = end;
        }
        public int compareTo(Pair other){
            if(this.end == other.end){
                return other.start - this.start;
            }
            else{
                return this.end - other.end;
            }
        }
    }
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        Pair p[] = new Pair[n];
        for(int i = 0; i < n; i++){
            p[i] = new Pair(start[i], end[i]);
        }
        Arrays.sort(p);
        
        int count = 1;
        int endPoint = p[0].end;
        for(int i = 1; i < n; i++){
            if(p[i].start > endPoint){
                endPoint = p[i].end;
                count++;
            }
        }
        return count;
    }
}
