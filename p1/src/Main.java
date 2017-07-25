import java.util.Arrays;

/**
 * Created by milabobo on 10:47 PM.
 * Email mailto:milabobo@126.com
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new Solution().twoSum(new int[]{1, 5, 3, 8, 10}, 11)));
    }

    public static class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] answer = new int[2];
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        answer[0] = i;
                        answer[1] = j;
                        break;
                    }
                }
            }
            return answer;
        }
    }
}
