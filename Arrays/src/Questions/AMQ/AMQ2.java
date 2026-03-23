package Questions.AMQ;
import java.util.Arrays;

// Question: Sort an array of 0's 1's and 2's
// Optimal Solution is Dutch National Flag Algorithm
public class AMQ2 {
    public static void main(String[] args) {
        int[]arr={2, 0, 2, 1, 1, 0};
        AMQ2 obj=new AMQ2();
//        obj.Bruteforce(arr);
//        obj.Better(arr);
        obj.Optimal(arr);
        System.out.println(Arrays.toString(arr));
    }

//    Dutch National Flag Algorithm
    public void Optimal(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
        // Time Complexity: O(N);
        // Space Complexity: O(1);
    }
    public void Bruteforce(int[] arr) {
        Arrays.sort(arr);
        // Time Complexity: O(N logN);
        // Space Complexity: O(N);
    }
    public void Better(int[] nums) {
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
        for (int num : nums) {
            if (num == 0) cnt0++;
            else if (num == 1) cnt1++;
            else cnt2++;
        }
        for (int i = 0; i < cnt0; i++) {
            nums[i] = 0;
        }
        for (int i = cnt0; i < cnt0 + cnt1; i++) {
            nums[i] = 1;
        }
        for (int i = cnt0 + cnt1; i < nums.length; i++) {
            nums[i] = 2;
        }
        // Time Complexity: O(2N);
        // Space Complexity: O(1);
    }
}
