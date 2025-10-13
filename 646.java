import java.util.*;

class Solution {
    // Recursive memo function:
    // idx  -> current index being considered
    // prev -> index of previously chosen pair (-1 if none chosen)
    // dp   -> memo table, dp[idx][prev+1] stores answer for (idx, prev)
    private int solve(int[][] pairs, int n, int idx, int prev, int[][] dp) {
        if (idx == n) {
            return 0;
        }
        if (dp[idx][prev + 1] != -1) {
            return dp[idx][prev + 1];
        }
        // Option 1: skip current pair
        int skip = solve(pairs, n, idx + 1, prev, dp);
        // Option 2: take current pair (only if it can follow prev)
        int take = 0;
        if (prev == -1 || pairs[prev][1] < pairs[idx][0]) {
            take = 1 + solve(pairs, n, idx + 1, idx, dp);
        }
        dp[idx][prev + 1] = Math.max(take, skip);
        return dp[idx][prev + 1];
    }
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) return 0;
        int n = pairs.length;
        // Sort by second element (ending) — helps greedy and also improves DP pruning
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        // dp dimensions: n x (n+1) because prev ranges -1..n-1 -> prev+1 in 0..n
        int[][] dp = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(pairs, n, 0, -1, dp);
    }
}
