public class maze {
    int maze(int nums[][],int n,int m,int i,int j){
        if(i==n-1 &&j==m-1){
            return 1;
        }
        if(i>=n || j>=m){
            return 0;
        }
        int right=maze(nums,n,m,i,j+1);
        int down=maze(nums,n,m,i+1,j);
        return right+down;
    }
    int maze2(int nums[][],int n,int m,int i,int j){
        if(i==n-1 &&j==m-1){
            return 1;
        }
        
        if(i==n-1){
            return maze2(nums,n,m,i,j+1);
        }else if(j==m-1){
            return maze2(nums,n,m,i+1,j);
        }else{
            return maze2(nums,n,m,i,j+1)+ maze2(nums,n,m,i+1,j)
        }
    }
    void mazeprint(int[][] nums,String s,int n,int m,int i,int j){
         if(i==n-1 &&j==m-1){
            System.out.println(s);
            return;
        }
        
        if(i==n-1){
            return mazeprint(nums,s+"R",n,m,i,j+1);
        }else if(j==m-1){
            return mazeprint(nums,s+"D",n,m,i+1,j);
        }else{
            return mazeprint(nums,s+"D",n,m,i,j+1)+ mazeprint(nums,s+"D",n,m,i+1,j);
        }
        //issue is that we  are using function as void so we cannot return anything in the function but the three functions returns which is not needed


    }
    //corrected version 
    static void mazeprint2(int[][] nums, String s, int n, int m, int i, int j) {
        // Base condition: reached the destination
        if (i == n - 1 && j == m - 1) {
            System.out.println(s);
            return;
        }

        // If out of bounds, stop recursion
        if (i >= n || j >= m) {
            return;
        }

        // Move Right
        mazeprint2(nums, s + "R", n, m, i, j + 1);

        // Move Down
        mazeprint2(nums, s + "D", n, m, i + 1, j);
    }
    static int mazedp(int[][] nums, int n, int m, int i, int j, int[][] dp) {
        // Base case: reached the destination
        if (i == n - 1 && j == m - 1) {
            return 1;
        }

        // Out of bounds
        if (i >= n || j >= m) {
            return 0;
        }

        // If already computed, return from dp
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        // Move right and down
        int right = mazedp(nums, n, m, i, j + 1, dp);
        int down = mazedp(nums, n, m, i + 1, j, dp);
        // Store result in dp array and return
        return dp[i][j] = right + down;
    }
     static void printSubsequence(String s, String ans, int idx) {
        if (idx == s.length()) {
            System.out.println(ans);
            return;
        }

        // ✅ Take the current character
        printSubsequence(s, ans + s.charAt(idx), idx + 1);

        // ❌ Skip the current character
        printSubsequence(s, ans, idx + 1);
    }


    
    static int countSubsequences(String s, int idx, int[] dp) {
        if (idx == s.length()) return 1;

        if (dp[idx] != -1) return dp[idx];

        // take + skip
        int take = countSubsequences(s, idx + 1, dp);
        int skip = countSubsequences(s, idx + 1, dp);

        dp[idx] = take + skip;
        return dp[idx];
    }


    
}
