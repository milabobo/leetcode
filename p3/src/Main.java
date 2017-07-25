import java.util.HashMap;

/**
 * Created by milabobo on 9:40 AM.
 * Email mailto:milabobo@126.com
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring("abba"));
    }

    public static class Solution {
        public int lengthOfLongestSubstring(String s) {
            HashMap<Character, Integer> map =
                    new HashMap<Character, Integer>(s.length());

            int start = 0;
            int end = 0;
            int max = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!map.containsKey(c)) {
                    end++;
                } else {
                    int tempStart = map.get(c) + 1;
                    if (tempStart > start) {
                        start = tempStart;
                    }
                    end++;
                }

                map.put(c, i);
                int length = end - start;
                if (length > max) {
                    max = length;
                }
            }

            return max;
        }
    }
}
