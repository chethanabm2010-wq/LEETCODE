
class Solution {
    static final int MOD = 1_000_000_007;

    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long[] dp = new long[n];
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            long left = 0;

            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    long temp = left;
                    left = dp[j];
                    dp[j] = temp;
                } else {
                    long total = (left + dp[j]) % MOD;
                    left = total;
                    dp[j] = total;
                }
            }
        }

        return (int) dp[n - 1];
    }
}
