public class CoinChange{
    int solve(int[] coins, int n, int amount, int idx, int[][] dp) {
        // Base cases
        if (amount == 0)
            return 0;
        if (idx == n)
            return Integer.MAX_VALUE-1;//to avoid overflow
        if (dp[idx][amount] != -1)
            return dp[idx][amount];
        if (coins[idx] > amount)
            return dp[idx][amount] = solve(coins, n, amount, idx + 1, dp);
        int take=solve(coins,n,amount-coins[idx],idx,dp);
        if (take != Integer.MAX_VALUE - 1)
            take = 1 + take;
        int skip = solve(coins, n, amount, idx + 1, dp);
        return dp[idx][amount] = Math.min(take, skip);
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = -1;
            }
        }

        int result = solve(coins, n, amount, 0, dp);
        return (result == Integer.MAX_VALUE - 1) ? -1 : result;
    }
}