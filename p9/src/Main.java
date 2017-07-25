/**
 * Created by milabobo on 12:17 PM.
 * Email mailto:milabobo@126.com
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(189));
        System.out.println(solution.isPalindrome(181));
        System.out.println(solution.isPalindrome(1568651));
        System.out.println(solution.isPalindrome(-181));
        System.out.println(solution.isPalindrome(-1));
        System.out.println(solution.isPalindrome(0));
    }

    public static class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            int n = 0;
            int temp = x;
            while (temp != 0) {
                n++;
                temp = temp / 10;
            }

            int start = 0;
            int end = n - 1;
            while (start < end) {
                int startDigit = (x / (int)(Math.pow(10, start))) % 10;
                int endDigit = (x / (int)(Math.pow(10, end))) % 10;
                if (startDigit != endDigit) {
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }
    }
}
