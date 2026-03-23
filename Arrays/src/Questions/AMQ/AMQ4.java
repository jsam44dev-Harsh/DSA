package Questions.AMQ;

import java.util.Arrays;

// Questions: Kadane's Algorithm, maximum subarray sum
public class AMQ4 {
    public static void main(String[] args) {
        int[] arr={-2,-3,4,-1,-2,1,5,-3};
        System.out.println(BruteForce(arr));
        System.out.println(Better(arr));
        System.out.println(Optimal(arr));
        System.out.println(Arrays.toString(Optimal1(arr)));
    }
    public static int[] Optimal1(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0;
        int end = 0;
        int tempStart = 0;

        for (int i = 0; i < arr.length; i++) {
            if (sum == 0) {
                tempStart = i;
            }
            sum += arr[i];
            if (sum > maxSum) {
                maxSum = sum;
                start = tempStart;
                end = i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        int[] nums = new int[end - start + 1];
        int j = 0;

        for (int i = start; i <= end; i++) {
            nums[j++] = arr[i];
        }
        return nums;
        // Time Complexity: O(N)
        // Space Complexity: O(N)
    }
    public static int Optimal(int[] arr){
        int maxSum=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum>maxSum) {
                maxSum = sum;
            }
            if(sum<0){
                sum=0;
            }
        }
        return maxSum;
        // Time Complexity: O(N)
        // Space Complexity: O(1)
    }
    public static int Better(int[] arr){
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=i;j<arr.length;j++){
                sum+=arr[j];
                maxSum=Math.max(sum,maxSum);
            }
        }
        return maxSum;
        // Time Complexity: O(N^2)
        // Space Complexity: O(1)
    }

    public static int BruteForce(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum=0;
                for (int k=i; k<j; k++) {
                    sum+=arr[k];
                    maxSum = Math.max(sum, maxSum);
                }
            }
        }
        return maxSum;
        // Time Complexity: O(N^3)
        // Space Complexity: O(1)
    }
}
