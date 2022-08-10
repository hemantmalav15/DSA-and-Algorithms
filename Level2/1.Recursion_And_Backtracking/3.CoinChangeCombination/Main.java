public class Main {
    //In this we can use a coin any number of time 
    public static int combinationsInfiniteSupply(int coins[],int target,int idx,String asf){
        if(target == 0){
            System.out.println(asf);
            return 1;
        }
        int count = 0;
        for(int i = idx; i<coins.length; i++){
            if(target - coins[i] >= 0){
                count += combinationsInfiniteSupply(coins, target - coins[i], i, asf + coins[i]);
            }
        }
        return count;
    }

    //In this we can use a coin only once 
    public static int combinationsSingleSupply(int coins[],int target,int idx,String asf){
        if(target == 0){
            System.out.println(asf);
            return 1;
        }
        int count = 0;
        for(int i = idx; i<coins.length; i++){
            if(target - coins[i] >= 0){
                // we are using one coin only once thats why we are calling function with next idx
                // agar (2,3) ko humne use kar liya hai to ab hum next (5,7) ke liye call lagayenge 
                count += combinationsSingleSupply(coins, target - coins[i], i + 1, asf + coins[i]);
            }
        }
        return count;
    }
    public static void main(String [] args){
        int coins[] = {2,3,5,7};
        int target = 10;

        int ans = combinationsSingleSupply(coins,target,0,"");
        System.out.println("total combinations are -> " + ans);
    }
}
