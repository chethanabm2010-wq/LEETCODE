
import java.util.*;

class Solution {
    TreeMap<Integer, Integer> lo = new TreeMap<>();
    TreeMap<Integer, Integer> hi = new TreeMap<>();

    int ls, hs;
    long lsum, hsum;

    void add(TreeMap<Integer, Integer> map, int v) {
        map.merge(v, 1, Integer::sum);
    }

    void remove(TreeMap<Integer, Integer> map, int v) {
        if (map.get(v) == 1) map.remove(v);
        else map.put(v, map.get(v) - 1);
    }

    void balance() {
        while (ls > hs + 1) {
            int v = lo.lastKey();
            remove(lo, v);
            ls--;
            lsum -= v;

            add(hi, v);
            hs++;
            hsum += v;
        }

        while (ls < hs) {
            int v = hi.firstKey();
            remove(hi, v);
            hs--;
            hsum -= v;

            add(lo, v);
            ls++;
            lsum += v;
        }
    }

    void insert(int v) {
        if (lo.isEmpty() || v <= lo.lastKey()) {
            add(lo, v);
            ls++;
            lsum += v;
        } else {
            add(hi, v);
            hs++;
            hsum += v;
        }
        balance();
    }

    void erase(int v) {
        if (lo.containsKey(v)) {
            remove(lo, v);
            ls--;
            lsum -= v;
        } else {
            remove(hi, v);
            hs--;
            hsum -= v;
        }
        balance();
    }

    long getCost() {
        long median = lo.lastKey();

        return median * ls - lsum
             + hsum - median * hs;
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        int windows = n - x + 1;

        long[] cost = new long[windows];

        // Calculate first window
        for (int i = 0; i < x; i++) {
            insert(nums[i]);
        }

        cost[0] = getCost();

        // Sliding window
        for (int i = x; i < n; i++) {
            erase(nums[i - x]);
            insert(nums[i]);

            cost[i - x + 1] = getCost();
        }

        // DP: minimum cost for j windows in first i elements
        long INF = Long.MAX_VALUE / 4;
        long[][] dp = new long[k + 1][n + 1];

        for (int j = 0; j <= k; j++) {
            Arrays.fill(dp[j], INF);
        }

        dp[0][0] = 0;

        for (int j = 0; j <= k; j++) {
            for (int i = 1; i <= n; i++) {
                // Skip current element
                dp[j][i] = Math.min(dp[j][i], dp[j][i - 1]);

                // Select window ending at i - 1
                if (j > 0 && i >= x &&
                    dp[j - 1][i - x] != INF) {

                    dp[j][i] = Math.min(
                        dp[j][i],
                        dp[j - 1][i - x] + cost[i - x]
                    );
                }
            }
        }

        return dp[k][n];
    }
}
