
import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (p.length() > s.length()) {
            return result;
        }

        HashMap<Character, Integer> pMap = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> windowMap = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            char ch = s.charAt(i);
            windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);
        }

        if (windowMap.equals(pMap)) {
            result.add(0);
        }

        for (int right = p.length(); right < s.length(); right++) {
            char leftChar = s.charAt(right - p.length());
            windowMap.put(leftChar, windowMap.get(leftChar) - 1);

            if (windowMap.get(leftChar) == 0) {
                windowMap.remove(leftChar);
            }

            char rightChar = s.charAt(right);
            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);

            if (windowMap.equals(pMap)) {
                result.add(right - p.length() + 1);
            }
        }

        return result;
    }
}
