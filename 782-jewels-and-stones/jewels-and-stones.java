class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> set = new HashSet<>();

        for(char c : jewels.toCharArray()) {
            set.add(c);
        }

        int count = 0;

        for(int i = 0; i < stones.length(); i++) {
            if(set.contains(stones.charAt(i))) {
                count++;
            }
        }

        return count;
    }
}