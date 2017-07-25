/**
 * Created by milabobo on 2:53 PM.
 * Email mailto:milabobo@126.com
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isNumber("0"));
        System.out.println(solution.isNumber(""));
        System.out.println(solution.isNumber(" "));
        System.out.println(solution.isNumber(" 0.1 "));
        System.out.println(solution.isNumber("abc"));
        System.out.println(solution.isNumber("1 a"));
        System.out.println(solution.isNumber("2e10"));
        System.out.println(solution.isNumber("1e"));
        System.out.println(solution.isNumber("."));
        System.out.println(solution.isNumber(".1"));
        System.out.println(solution.isNumber("1.1"));
        System.out.println();
        System.out.println(solution.isNumber("1."));
        System.out.println(solution.isNumber("1.e1"));
        System.out.println(solution.isNumber("6e6.5"));
        System.out.println(solution.isNumber("6e+6"));
        System.out.println(solution.isNumber("6e-6"));
        System.out.println(solution.isNumber("-1.e49046 "));
    }

    public static class Solution {
        public boolean isNumber(String s) {
            if (s == null || s.length() == 0) {
                return false;
            }

            int position = 0;
            while (position < s.length()
                    && isBlank(s.charAt(position))) {
                position++;
            }

            if (position < s.length()) {
                position = isSign(s.charAt(position))
                        ? position + 1 : position;
            }

            int end = s.length() - 1;
            while (end >= 0 && end < s.length()
                    && isBlank(s.charAt(end))) {
                end--;
            }

            boolean isValue = false;
            int start = position;
            int eCount = 0;
            int pointCount = 0;
            int ePosition = 0, pointPosition = 0;
            while (position < end + 1) {
                char a = s.charAt(position);
                if (a == '.') {
                    pointPosition = position;
                    pointCount++;
                }
                if (a == 'e') {
                    ePosition = position;
                    eCount++;
                }
                if (ePosition != 0 && pointPosition != 0
                        && ePosition < pointPosition) {
                    return false;
                }

                if (eCount > 1 || pointCount > 1) {
                    return false;
                }

                isValue = isValid(a);
                if (a == 'e'
                        && ((position == start || (!isDigit(s.charAt(position - 1))
                        && s.charAt(position - 1) != '.'))
                        || !isWithoutEDigit(s, position + 1, end))) {
                    return false;
                }
                if (a == 'e') {
                    return true;
                }

                if (a == '.'
                        && !((position != start && isDigit(s.charAt(position - 1)))
                        || (position != end && isDigit(s.charAt(position + 1))))) {
                    return false;
                }
                if (!isValue) {
                    return false;
                }
                position++;
            }

            return isValue;
        }

        public boolean isWithoutEDigit(String s, int from, int end) {
            int position = from;
            if (position <= end) {
                position = isSign(s.charAt(position))
                        ? position + 1 : position;
            }

            boolean valid = false;
            while (position <= end) {
                if (isDigit(s.charAt(position))) {
                    valid = true;
                } else {
                    return false;
                }
                position++;
            }
            return valid;
        }

        public boolean isBlank(char a) {
            return a == ' ';
        }

        public boolean isDigit(char a) {
            return (a >= '0' && a <= '9');
        }

        public boolean isValid(char a) {
            return isDigit(a) || a == '.' || a == 'e';
        }

        public boolean isSign(char a) {
            return a == '-' || a == '+';
        }

    }
}
