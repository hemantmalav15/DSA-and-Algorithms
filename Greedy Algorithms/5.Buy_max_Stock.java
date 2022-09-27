import java.util.*;
class Solution {
    static class Pair implements Comparable<Pair>{
       int first;
       int second;
       
       Pair(int first, int second){
           this.first = first;
           this.second=second;
       }
       public int compareTo(Pair p){
           return this.first - p.first;
       }
   }
   public static int buyMaximumProducts(int n, int k, int[] price) {
       Pair p[] = new Pair[n];//creating an array of pair
       
       for(int i = 0; i < n; i++){
           p[i] = new Pair(price[i], i + 1);//pair->(price, max_stock can be bought on i-th day)
       }
       
       Arrays.sort(p);//sorting according to price
       //logic-buy less costly stocks more to maximise no. of stocks
       int ans =0;
       for(int i = 0; i < n; i++){
           
           int prices = p[i].first;
           int stock = p[i].second;
           
           if(prices * stock <= k){ // means we can take
               ans += stock;
               k -= prices * stock;
           }else{
               ans += (k / prices); //no. of stocks that can be added
               k = k - (prices * (k / prices));//k is the total money remaining
           }
       }
       return ans;
   }
}
        
