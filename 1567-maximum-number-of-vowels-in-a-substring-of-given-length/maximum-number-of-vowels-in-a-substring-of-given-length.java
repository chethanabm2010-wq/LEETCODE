class Solution {
    public int maxVowels(String s, int k) {
        int vowelCount=0;
        int maxCount=0;
        int left=0;
        for(int right=0;right<s.length();right++){
            if(s.charAt(right)=='a'||s.charAt(right)=='e'||s.charAt(right)=='o'||s.charAt(right)=='i'||s.charAt(right)=='u'){
                vowelCount++;
            }
            
           
            if(right-left+1==k){
                 maxCount=Math.max(maxCount,vowelCount);
                  if(s.charAt(left)=='a'||s.charAt(left)=='e'||s.charAt(left)=='o'||s.charAt(left)=='i'||s.charAt(left)=='u'){
                  vowelCount--;
                 
            }
             left++;
            
            
            
            
        }
        }
        return maxCount;
    }
}