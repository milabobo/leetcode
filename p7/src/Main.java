/**
 * Created by milabobo on 11:25 AM.
 * Email mailto:milabobo@126.com
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(1534236469));
        System.out.println(solution.reverse(100345));
        System.out.println(solution.reverse(-100345));
    }

    public static class Solution {
        public int reverse(int x) {
            int sum = x % 10;
            int k = x;
            while (k / 10 != 0) {
                int tempSum = sum * 10;
                if (tempSum / 10 != sum) {
                    return 0;
                }
                int tempSum1 = tempSum + (k / 10) % 10;
                if (tempSum1 - tempSum != (k / 10) % 10) {
                    return 0;
                }
                sum = tempSum1;
                k = k / 10;
            }
            return sum;
        }
    }
}
