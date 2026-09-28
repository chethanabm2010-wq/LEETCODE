class Solution {
    public int maxDepth(String s) {

        int current = 0;
        int max = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                current++;
                max = Math.max(max, current);
            }

            else if (ch == ')') {
                current--;
            }
        }

        return max;
    }
}