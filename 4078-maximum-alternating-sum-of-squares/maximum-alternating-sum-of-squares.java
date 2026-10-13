
import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[] squares = new long[nums.length];

        for (int i = 0; i < nums.length; i++) {
            squares[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(squares);

        int n = nums.length;
        int positiveCount = (n + 1) / 2;
        long ans = 0;

        for (int i = 0; i < n - positiveCount; i++) {
            ans -= squares[i];
        }

        for (int i = n - positiveCount; i < n; i++) {
            ans += squares[i];
        }

        return ans;
    }
}
