class Solution {
    public int majorityElement(int[] nums) {

        HashMap<Integer, Integer> freq = new HashMap<>();

        int n = nums.length;

        for(int i = 0; i < n; i++) {

            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);

            if(freq.get(nums[i]) > n / 2) {
                return nums[i];
            }
        }

        return -1;
    }
}