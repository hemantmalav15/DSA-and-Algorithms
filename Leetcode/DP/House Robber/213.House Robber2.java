class Solution {
    
    // It is slight variation of house robber question
    public int robHouse(int[] num, int lo, int hi) {
        
       int include = num[lo], exclude = 0;
       for (int j = lo + 1; j <= hi; j++) {
           
         int ninc = exclude + num[j];
         int nexc = Math.max(include,exclude);
           
         include = ninc;
         exclude = nexc;
    }
    return Math.max(include, exclude);
}
    
    public int rob(int[] nums) {
        
        if (nums.length == 1){
          return nums[0];  
        } 
    // if we rob the first house then we cannot rob the last house and if we do not rob
    // the first house then we can rob the last house  
    // first call shows that we rob first house and we left last house
    // second call shows we rob the second house and can rob last house as well        
    return Math.max(robHouse(nums, 0, nums.length - 2), robHouse(nums, 1, nums.length - 1));
    }
}