
import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        int[] freq = new int[n + 1];
        int minPrice = Integer.MAX_VALUE;

        // Count items having each factor
        for (int[] item : items) {
            freq[item[0]]++;
            minPrice = Math.min(minPrice, item[1]);
        }

        // Count how many other item types each factor can unlock
        int[] gain = new int[n + 1];

        for (int f = 1; f <= n; f++) {
            for (int j = f; j <= n; j += f) {
                gain[f] += freq[j];
            }
            gain[f]--;
        }

        // Sort items by price
        Arrays.sort(items, (a, b) ->
            Integer.compare(a[1], b[1])
        );

        long remaining = budget;
        long ans = 0;

        // Buy items that provide an additional free item
        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];

            if (price >= 2L * minPrice) {
                break;
            }

            if (gain[factor] <= 0) {
                continue;
            }

            long count = Math.min(
                gain[factor],
                remaining / price
            );

            ans += count * 2;
            remaining -= count * price;
        }

        // Spend the remaining budget on the cheapest item
        ans += remaining / minPrice;

        return (int) ans;
    }
}
