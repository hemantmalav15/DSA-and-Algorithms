public class Main{
    //we have infinite supply of each coins or we can use each coin any number of times
    public static int permutationInfiniteSupply(int coins[],int target,String asf){
        if(target == 0){
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for(int i = 0; i<coins.length; i++){
            if(target - coins[i] >= 0){
                count += permutationInfiniteSupply(coins, target - coins[i], asf + coins[i]);
            }
        }
        return count;
    }

    //we have single supply of each coins or we can use each coin only once
    public static int permutationSingleSupply(int coins[],int target,String asf){
        if(target == 0){
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for(int i = 0; i<coins.length; i++){
            if(target - coins[i] >= 0 && coins[i] > 0){
                //we have to store value of coins[i] bcoz we are using this value in function call and if we 
                //dont store it then the value of coins[i] becomes negative in function call
                int val = coins[i];

                //we are using this to mark visited bcoz we have to use every coin only once otherwise 
                //we have to use a visited array to store which coin is used
                coins[i] = -coins[i];
                count += permutationSingleSupply(coins, target - val, asf + val);
                coins[i] = -coins[i];
            }
        }
        return count;
    }
    public static void main(String [] args){
        int coin[] = {2,3,5,7};
        int target = 10;
        int ans = permutationSingleSupply(coin, target,"");
        System.out.println("Total Permutations is -> " + ans);
    }
}