class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;

        int[] best = new int[n];

        Arrays.fill(best, Integer.MAX_VALUE);

        int left = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {

            // Expand window
            sum += arr[right];

            // Shrink window if sum is too large
            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            // If we found a valid subarray
            if (sum == target) {

                int len = right - left + 1;

                // Combine with previous non-overlapping subarray
                if (left > 0 && best[left - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, len + best[left - 1]);
                }

                // Store shortest valid subarray ending here
                if (right == 0) {
                    best[right] = len;
                } else {
                    best[right] = Math.min(best[right - 1], len);
                }

            } else {

                // No new valid subarray
                if (right > 0) {
                    best[right] = best[right - 1];
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}