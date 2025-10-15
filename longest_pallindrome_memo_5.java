class Solution {
    boolean solve(String s, int i, int j, Boolean[][] dp) {
        if (i >= j) return true;
        if (dp[i][j] != null) return dp[i][j];
        if(s.charAt(i)==s.charAt(j)){
           return dp[i][j]=solve(s,i+1,j-1,dp);
        }
        return dp[i][j] = false;
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        Boolean[][] dp = new Boolean[n][n];
        int maxlen = 0;
        int best_start = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (solve(s, i, j, dp) && maxlen < j - i + 1) {
                    maxlen = j - i + 1;
                    best_start = i;
                }
            }
        }
        return s.substring(best_start, best_start + maxlen);
    }
}
  
