public class Main {
    
    public static boolean isPalindrome(String s,int i,int j){
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    static int dp[][];
	public static int minPalindromicCutRec(String s,int i, int j) {
	    //Base Condition
	    if(i >= j){
	        return 0;
	    }
	    //If String already a palindrome then we dont need to do partition
	    if(isPalindrome(s,i,j)){
	        return 0;
	    }
	    if(dp[i][j] != -1){
	        return dp[i][j];
	    }
	    //For Loop
	    int min = Integer.MAX_VALUE;
	    for(int k = i; k<j; k++){
	        int tempAns = 1 + minPalindromicCutRec(s,i,k) + minPalindromicCutRec(s,k+1,j);
	        
	        if(tempAns < min){
	            min = tempAns;
	        }
	    }
		return dp[i][j] = min;
	}
    static int palindromicPartition(String str)
    {
        int n = str.length();
        dp = new int[n][n];
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                dp[i][j] = -1;
            }
        }
        return minPalindromicCutRec(str,0,str.length()-1);
    }
    
}
