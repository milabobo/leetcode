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
        System.out.println(solution.myAtoi("   -100 1"));
        System.out.println(solution.myAtoi("-0012a42"));
        System.out.println(solution.myAtoi("-"));
        System.out.println(solution.myAtoi("+"));
        System.out.println(solution.myAtoi("2147483648"));
    }

    public static class Solution {
        static int INVALID = 0;
        static int INTEGER_MAX = Integer.MAX_VALUE;
        static int INTEGER_MIN = Integer.MIN_VALUE;

        public int myAtoi(String str) {
            if (str == null || str.length() == 0) {
                return INVALID;
            }

            int firstPosition = 0;
            while (firstPosition < str.length()
                    && str.charAt(firstPosition) == ' ') {
                firstPosition++;
            }

            char first = str.charAt(firstPosition);
            if (first != '-' && first != '+' && !isDigit(first)) {
                return INVALID;
            }

            int sign = first == '-' ? -1 : 1;
            int result = 0;
            int position = first == '-' || first == '+'
                    ? firstPosition + 1 : firstPosition;

            if (position < str.length() && !isDigit(str.charAt(position))) {
                return INVALID;
            }

            while (position < str.length()) {
                char a = str.charAt(position);
                if (!isDigit(a)) {
                    break;
                }
                int temp = result * 10 + value(a);
                // check overflow
                if (temp < 0 || (temp - value(a)) / 10 != result) {
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
