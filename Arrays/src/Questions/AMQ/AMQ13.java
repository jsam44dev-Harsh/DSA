package Questions.AMQ;
import java.util.HashMap;

// Question: Count Subarray sum Equals K
// Problem Statement: Given an array of integers and an integer k, return the total number of subarrays whose
// sum equals k. A subarray is a contiguous non-empty sequence of elements within an array.

public class AMQ13 {
    public static void main(String[] args) {
        int[] num={1,2,3,-3,1,1,1,4,2,-3};
        AMQ13 obj=new AMQ13();
        System.out.println(obj.BruteForce(num,3));
        System.out.println(obj.Optimal(num,3));
    }
    public int Optimal(int[] arr,int k){
        int n = arr.length;
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        int prefixSum = 0;
        int count = 0;
        prefixSumCount.put(0, 1);

        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            int remove = prefixSum - k;

            if (prefixSumCount.containsKey(remove)) {
                count += prefixSumCount.get(remove);
            }
            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
        // Time Complexity: O(n)
        // Space Complexity: O(1)
    }


    public int BruteForce(int arr[],int k){
        int count=0;
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=i;j<arr.length;j++){
                sum+=arr[j];
                if(sum==k){
                    count++;
                }
            }
        }
        return count;
        // Time Complexity: O(n^2)
        // Space Complexity: O(1)
    }
}
