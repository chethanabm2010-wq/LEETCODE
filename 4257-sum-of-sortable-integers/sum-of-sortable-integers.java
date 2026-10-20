
class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;

        int[] prefMax = new int[n + 1];
        int[] suffMin = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefMax[i + 1] = Math.max(prefMax[i], nums[i]);
        }

        suffMin[n] = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            suffMin[i] = Math.min(nums[i], suffMin[i + 1]);
        }

        int[] drops = new int[n + 1];

        for (int i = 1; i < n; i++) {
            drops[i + 1] = drops[i] + (nums[i - 1] > nums[i] ? 1 : 0);
        }

        int ans = 0;

        for (int k = 1; k <= n / k; k++) {
            if (n % k != 0) continue;

            if (check(nums, prefMax, suffMin, drops, k)) {
                ans += k;
            }

            int other = n / k;
            if (other != k &&
                check(nums, prefMax, suffMin, drops, other)) {
                ans += other;
            }
        }

        return ans;
    }

    private boolean check(int[] nums, int[] prefMax,
                          int[] suffMin, int[] drops, int k) {
        int n = nums.length;
        int prevMax = 0;

        for (int start = 0; start < n; start += k) {
            int end = start + k - 1;

            int descents = drops[end + 1] - drops[start + 1];

            if (nums[end] > nums[start]) {
                descents++;
            }

            if (descents > 1) return false;

            if (start > 0 && prevMax > suffMin[start]) {
                return false;
            }

            prevMax = prefMax[end + 1];
        }

        return true;
    }
}
