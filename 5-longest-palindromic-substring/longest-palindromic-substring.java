
class Solution {
    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return "";
        }

        int start = 0;
        int maxLength = 1;

        for (int i = 0; i < s.length(); i++) {

            // Odd-length center
            int left = i;
            int right = i;

            while (left >= 0 && right < s.length()
                    && s.charAt(left) == s.charAt(right)) {

                int length = right - left + 1;

                if (length > maxLength) {
                    maxLength = length;
                    start = left;
                }

                left--;
                right++;
            }

            // Even-length center
            left = i;
            right = i + 1;

            while (left >= 0 && right < s.length()
                    && s.charAt(left) == s.charAt(right)) {

                int length = right - left + 1;

                if (length > maxLength) {
                    maxLength = length;
                    start = left;
                }

                left--;
                right++;
            }
        }

        return s.substring(start, start + maxLength);
    }
}
