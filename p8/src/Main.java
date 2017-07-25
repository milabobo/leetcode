/**
 * Created by milabobo on 1:35 PM.
 * Email mailto:milabobo@126.com
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("100"));
        System.out.println(solution.myAtoi("-c1001"));
        System.out.println(solution.myAtoi("-100100000000"));
    }

    public static class Solution {
        static int INVALID = -1;
        static int INTEGER_MAX = Integer.MAX_VALUE;
        static int INTEGER_MIN = Integer.MIN_VALUE;

        public int myAtoi(String str) {
            if (str == null || str.length() == 0) {
                return INVALID;
            }

            char first = str.charAt(0);
            if (first != '-' && first != '+' && !isDigit(first)) {
                return INVALID;
            }

            int sign = first == '-' ? -1 : 1;
            int result = 0;
            int position = first == '-' || first == '+' ? 1 : 0;

            while (position < str.length()) {
                char a = str.charAt(position);
                if (!isDigit(a)) {
                    return INVALID;
                }
                int temp = result * 10 + value(a);
                // check overflow
                if ((temp - value(a)) / 10 != result) {
                    return sign == 1 ? INTEGER_MAX : INTEGER_MIN;
                }
                result = temp;
                position++;
            }

            return sign * result;
        }

        public int value(char digit) {
            return digit - '0';
        }

        public boolean isDigit(char a) {
            return a >= '0' && a <= '9';
        }
    }
}
