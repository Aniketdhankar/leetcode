class Solution {
    long solve(int[] nums,int n,int idx,boolean positive,long[][] dp){
        if(idx>=n){
            return 0;
        }
        int p;
        if(positive){
            p=1;
        }else{
            p=0;
        }
        if(dp[idx][p]!=-1){
            return dp[idx][p];
        }
        long val=nums[idx];
        if(!positive){
            val=-val;
        }
        long take=solve(nums,n,idx+1,!positive,dp)+val;
        long skip=solve(nums,n,idx+1,positive,dp);
        return dp[idx][p]=Math.max(take,skip);
    }
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        long[][] dp=new long[n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                dp[i][j]=-1;
            }
        }
        return solve(nums,n,0,true,dp);
        
    }
}