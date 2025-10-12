class Solution {
    int solve(int[] nums,int n,int idx,int p,int[][]dp){
        if(idx>=n){
            return 0;
        }
        if(dp[idx][p+1]!=-1){//ofset 1 to handle neagative value p=-1
            return dp[idx][p+1];
        }
        int take=0;
        if(p==-1||nums[idx]>nums[p]){
            take=1+solve(nums,n,idx+1,idx,dp);
        }
        int skip=solve(nums,n,idx+1,p,dp);
        return dp[idx][p+1]=Math.max(take,skip);
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp =new int[n][n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return solve(nums,n,0,-1,dp);
        
    }
}