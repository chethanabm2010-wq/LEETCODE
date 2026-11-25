
import java.util.*;

class Solution {
    static final long MOD1 = 1_000_000_007L;
    static final long MOD2 = 1_000_000_009L;
    static final long BASE = 233L;

    long[] h1, h2, p1, p2;

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        h1 = new long[n + 1];
        h2 = new long[n + 1];
        p1 = new long[n + 1];
        p2 = new long[n + 1];

        p1[0] = 1;
        p2[0] = 1;

        for (int i = 0; i < n; i++) {
            p1[i + 1] = p1[i] * BASE % MOD1;
            p2[i + 1] = p2[i] * BASE % MOD2;

            h1[i + 1] = (h1[i] * BASE + nums[i]) % MOD1;
            h2[i + 1] = (h2[i] * BASE + nums[i]) % MOD2;
        }

        int low = 1, high = n;
        int ans = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (check(n, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    boolean check(int n, int len) {
        HashMap<Long, Integer> map = new HashMap<>();

        for (int i = 0; i + len <= n; i++) {
            long a = (h1[i + len] -
                    h1[i] * p1[len] % MOD1 + MOD1) % MOD1;

            long b = (h2[i + len] -
                    h2[i] * p2[len] % MOD2 + MOD2) % MOD2;

            long key = a * MOD2 + b;

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int count : map.values()) {
            if (count == 1) {
                return true;
            }
        }

        return false;
    }
}
