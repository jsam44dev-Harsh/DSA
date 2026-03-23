package Questions.AMQ;
import java.util.Arrays;
import java.util.HashMap;

// Question: Two Sum
public class AMQ1 {
    public static void main(String[] args) {
        AMQ1 obj = new AMQ1();
        int []arr={2,6,8,5,11};
        int target=7;
        System.out.println(Arrays.toString(obj.BruteForce(arr, target)));
        System.out.println(Arrays.toString(obj.Better(arr, target)));
    }
    public int[] Better(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
        // Time Complexity: O(N);
        // Space Complexity: O(N);
    }
    public boolean Optimal(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int sum=nums[left]+nums[right];
            if(sum==target){
                return true;
            }
            else if(sum>target){
                right--;
            }
            else{
                left++;
            }
        }
        return false;
        // Time Complexity: O(N) for loop + O(N logN) for Sorting;
        // Space Complexity: O(1);
    }
    public int[] BruteForce(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{0,0};
        // Time Complexity: O(N^2);
        // Space Complexity: O(1);

    }
}