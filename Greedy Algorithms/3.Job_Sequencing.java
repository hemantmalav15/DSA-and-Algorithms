import java.util.*;
class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        PriorityQueue<Job> pq = new PriorityQueue<>((a,b)->{
            if(a.profit == b.profit){
                return b.deadline - a.deadline;
            }
            else{
                return b.profit - a.profit;
            }
        });
        int maxdeadLine = 0;
        for(int i = 0; i < n; i++){
            pq.add(arr[i]);
            maxdeadLine = Math.max(maxdeadLine, arr[i].deadline);
        }
        boolean visit[] = new boolean[maxdeadLine + 1];
        visit[0] = true;
        
        int profit = 0;
        int count = 0;
        
        while(pq.size() > 0){
            Job i = pq.remove();
            int dl = i.deadline;
            
            while(dl > 0){
                if(visit[dl] == false){
                    visit[dl] = true;
                    count++;
                    profit += i.profit;
                    break;
                }
                dl--;
            }
        }
        int ans[] = new int[2];
        ans[0] = count;
        ans[1] = profit;
        
        return ans;
    }
}

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
