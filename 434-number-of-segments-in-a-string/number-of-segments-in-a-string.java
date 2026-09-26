class Solution {
    public int countSegments(String s) {

        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            // Current character is not a space
            // and it is either the first character
            // or the previous character is a space
            if (s.charAt(i) != ' ' &&
                (i == 0 || s.charAt(i - 1) == ' ')) {

                count++;
            }
        }

        return count;
    }
}