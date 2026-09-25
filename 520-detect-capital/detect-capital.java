class Solution {
    public boolean detectCapitalUse(String word) {

        int lowercase = 0;
        int uppercase = 0;

        // Count uppercase and lowercase characters
        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                lowercase++;
            }
            else if (ch >= 'A' && ch <= 'Z') {
                uppercase++;
            }
        }

        // Case 1: ALL uppercase
        if (uppercase == word.length()) {
            return true;
        }

        // Case 2: ALL lowercase
        else if (lowercase == word.length()) {
            return true;
        }

        // Case 3: Only first character uppercase
        else if (uppercase == 1 &&
                 word.charAt(0) >= 'A' &&
                 word.charAt(0) <= 'Z') {
            return true;
        }

        return false;
    }
}