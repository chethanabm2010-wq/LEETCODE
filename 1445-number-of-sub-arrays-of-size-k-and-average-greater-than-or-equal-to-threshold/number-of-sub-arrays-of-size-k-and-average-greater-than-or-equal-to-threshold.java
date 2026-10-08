class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int WindowSum=0;
        int count=0;
        int left=0;
        for(int right=0;right<arr.length;right++){
            WindowSum+=arr[right];
            if(right-left+1==k){
                if(WindowSum >= k * threshold){
                    count++;
                }
                WindowSum-=arr[left];
                left++;
            }
        }
        return count;
    }
}