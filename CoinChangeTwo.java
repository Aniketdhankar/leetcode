public class CoinChangeTwo{
    int solve(int[] coins,int n,int amount,int idx,int[][] dp){
        if(amount==0){
            return 1;
        }
        if(idx==n){
           return 0;
        }
        if(dp[idx][amount]!=-1){
            return dp[idx][amount];
        }
        if(coins[idx]>amount){
            return solve(coins,n,amount,idx+1,dp);
        }
        int take=solve(coins,n,amount-coins[idx],idx,dp);
        int skip=solve(coins,n,amount,idx+1,dp);
        return dp[idx][amount]=take+skip;
    }
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp =new int[n][amount+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<amount+1;j++){
                dp[i][j]=-1;
            }
        }
       
        return solve(coins,n,amount,0,dp);
        
    }
}