class Solution {
    public boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int length = m + n - 1;

        // Valid parentheses string must have even length
        if (length % 2 != 0) {
            return false;
        }

        // dp[row][col][balance]
        boolean[][][] dp = new boolean[m][n][length + 1];

        // Starting cell must be '('
        if (grid[0][0] == ')') {
            return false;
        }

        dp[0][0][1] = true;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                if (r == 0 && c == 0) {
                    continue;
                }

                int change = grid[r][c] == '(' ? 1 : -1;

                for (int balance = 0; balance <= length; balance++) {

                    int previous = balance - change;

                    if (previous < 0 || previous > length) {
                        continue;
                    }

                    // Come from top
                    if (r > 0 && dp[r - 1][c][previous]) {
                        dp[r][c][balance] = true;
                    }

                    // Come from left
                    if (c > 0 && dp[r][c - 1][previous]) {
                        dp[r][c][balance] = true;
                    }
                }
            }
        }

        return dp[m - 1][n - 1][0];
    }
}