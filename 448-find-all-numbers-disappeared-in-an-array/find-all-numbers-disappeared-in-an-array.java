class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        Arrays.sort(nums);

        List<Integer> result = new ArrayList<>();

        int expected = 1;

        for(int i = 0; i < nums.length; i++) {

            if(nums[i] == expected) {
                expected++;
            }
            else if(nums[i] > expected) {
                result.add(expected);
                expected++;
                i--;
            }
        }

        while(expected <= nums.length) {
            result.add(expected);
            expected++;
        }

        return result;
    }
}