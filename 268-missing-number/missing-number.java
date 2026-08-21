class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int add=n*(n+1)/2;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        int result=add-sum;

        return result;

        
    }
}