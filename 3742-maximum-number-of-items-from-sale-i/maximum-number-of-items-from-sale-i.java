
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, items[i][1]);
        }

        // dp[c] = maximum items obtained by spending exactly c
        int[] dp = new int[budget + 1];
        java.util.Arrays.fill(dp, -1000000);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            int factor = items[i][0];
            int price = items[i][1];

            // Count free items obtained from buying item i
            int freeCount = 0;

            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % factor == 0) {
                    freeCount++;
                }
            }

            // Buy the first copy of this item type only once
            for (int c = budget; c >= price; c--) {
                if (dp[c - price] != -1000000) {
                    dp[c] = Math.max(
                        dp[c],
                        dp[c - price] + 1 + freeCount
                    );
                }
            }
        }

        // Use remaining money to buy the cheapest item repeatedly
        int ans = 0;

        for (int c = 0; c <= budget; c++) {
            if (dp[c] != -1000000) {
                int total = dp[c] + (budget - c) / minPrice;
                ans = Math.max(ans, total);
            }
        }

        return ans;
    }
}
