import java.net.Inet4Address;
import java.util.*;

class Result {
    public static void main(String[] args) {
        int[] arr={9,2,6,1};
        char []arr1={'c','f','j'};
        System.out.println(minRemoval(arr,3));
    }

        public static int minRemoval(int[] nums, int k) {
            int n = nums.length;
            if (n <= 1) return 0;

            Arrays.sort(nums);

            int left = 0;
            int maxLen = 1;

            for (int right = 0; right < n; right++) {
                while ((long) nums[right] > (long) nums[left] * k) {
                    left++;
                }
                maxLen = Math.max(maxLen, right - left + 1);
            }

            return n - maxLen;
        }


}
