
class Solution {
    public int minOperations(String s) {
        int n = s.length();

        // Check whether the string is already sorted
        boolean sorted = true;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i - 1) > s.charAt(i)) {
                sorted = false;
                break;
            }
        }

        if (sorted) return 0;

        // Cannot sort a reversed string of length 2
        if (n == 2) return -1;

        char min = 'z';
        char max = 'a';

        for (int i = 0; i < n; i++) {
            min = (char) Math.min(min, s.charAt(i));
            max = (char) Math.max(max, s.charAt(i));
        }

        // Minimum already at start or maximum already at end
        if (s.charAt(0) == min || s.charAt(n - 1) == max) {
            return 1;
        }

        // Minimum or maximum occurs in the middle
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == min || s.charAt(i) == max) {
                return 2;
            }
        }

        return 3;
    }
}
