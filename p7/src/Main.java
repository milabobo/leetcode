/**
 * Created by milabobo on 11:25 AM.
 * Email mailto:milabobo@126.com
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(1534236469));
        System.out.println(solution.reverse(100345));
        System.out.println(solution.reverse(2147483647));
    }

    public static class Solution {
        public int reverse(int x) {
            boolean isNegative = x < 0;
            int absX = isNegative ? -x : x;
            int sum = absX % 10;
            int k = absX;
            while (k / 10 != 0) {
                int tempSum = sum * 10;
                if (tempSum / 10 != sum) {
                    return 0;
                }
                int tempSum1 = tempSum + (k / 10) % 10;
                if (tempSum1 < tempSum) {
                    return 0;
                }
                sum = tempSum1;
                k = k / 10;
            }
            return isNegative ? -sum : sum;
        }
    }
}
