import java.util.*;
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
class Solution
{
    class Pair implements Comparable<Pair>{
        int val;
        int wt;
        
        public Pair(int val, int wt){
            this.val = val;
            this.wt = wt;
        }
        
        public int compareTo(Pair other){
            double r1 = (double)(this.val) / (double)(this.wt);
            double r2 = (double)other.val /(double) (other.wt); 
            
            if(r2 > r1){
                return 1;
            }
            else if(r1 > r2){
                return -1;
            }
            else{
                return 0;
            }
        }
    }
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        Pair p[] = new Pair[n];
        for(int i = 0; i < n; i++){
            p[i] = new Pair(arr[i].value, arr[i].weight);
        }
        Arrays.sort(p);
        double res = 0.0;
        
        for(int i=0; i<n; i++){
            if(p[i].wt <= W){
                res += p[i].val;
                W -= p[i].wt;
            }
            else{
                res += (double)(p[i].val)/p[i].wt * W;
                break;
            }
        }
        
        return res;
    }
}