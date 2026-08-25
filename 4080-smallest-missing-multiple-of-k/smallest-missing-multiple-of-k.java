class Solution {
    public int missingMultiple(int[] nums, int k) {

        int[] arr = new int[nums.length];
        int j = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] % k == 0) {
                arr[j] = nums[i];
                j++;
            }
        }

        Arrays.sort(arr, 0, j);

        int i = 0;
        int multiple = k;

        while(i < j) {

            if(arr[i] == multiple) {
                i++;
                multiple += k;
            }
            else if(arr[i] < multiple) {
                i++;
            }
            else {
                return multiple;
            }
        }

        return multiple;
    }
}