public class dungeon_game_memo {

    int solve(int[][] dungeon, int m, int n, int i, int j, int[][] dp) {
        if (i >= n || j >= m) {
            return Integer.MAX_VALUE;
        }

        if (i == n - 1 && j == m - 1) {
            if (dungeon[i][j] >= 0) {
                return 1;
            } else {
                return Math.abs(dungeon[i][j]) + 1; // Minimum HP at destination
            }
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int right = solve(dungeon, m, n, i, j + 1, dp);
        int down = solve(dungeon, m, n, i + 1, j, dp);

        int result = Math.min(right, down) - dungeon[i][j];

        if (result <= 0) {
            dp[i][j] = 1;
        } else {
            dp[i][j] = result;
        }

        return dp[i][j];
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(dungeon, m, n, 0, 0, dp);
    }

    public static void main(String[] args) {
        int[][] dungeon = {
            {-2, -3, 3},
            {-5, -10, 1},
            {10, 30, -5}
        };

        dungeon_game_memo sol = new dungeon_game_memo();
        int result = sol.calculateMinimumHP(dungeon);
        System.out.println(result);  // Output: 7
    }
}
/*🔹 Example:

Suppose min(right, down) = 5 and dungeon[i][j] = -3 (this cell costs 3 health):

result = 5 - (-3)
       = 5 + 3
       = 8


So you need 8 health at this cell to survive the path.

If dungeon[i][j] = 3 (cell gives 3 health):

result = 5 - 3
       = 2


You only need 2 health at this cell to survive the path.

*/
