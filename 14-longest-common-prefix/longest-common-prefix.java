class Solution {
    public String longestCommonPrefix(String[] strs) {

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < strs[0].length(); i++) {

            char ch = strs[0].charAt(i);
            boolean found = false;

            for(int j = 1; j < strs.length; j++) {

                if(i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    found = true;
                    break;
                }
            }

            if(found) {
                break;
            }

            result.append(ch);
        }

        return result.toString();
    }
}