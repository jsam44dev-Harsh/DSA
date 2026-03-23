package Questions.AHQ;
import java.util.HashMap;

// Question: Largest Subarray with Sum 0

// Problem Statement: Given an array containing both positive and negative integers,
// we have to find the length of the longest subarray with the sum of all elements equal to zero.

public class AHQ5 {
    public static void main(String[] args) {
        AHQ5 obj = new AHQ5();
        int[] arr={9, -3, 3, -1, 6, -5};
        System.out.println(obj.BruteForce(arr));
        System.out.println(obj.Optimal(arr));
    }
    public int Optimal(int[]arr){
        HashMap<Integer,Integer> map=new HashMap<>();
        int maxCount=0;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==0){
                maxCount=i+1;
            }
            else {
                if (map.containsKey(sum)) {
                    maxCount = Math.max(maxCount, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
        }
        return maxCount;

        // Time Complexity: O(N)
        // Space Complexity: O(N)
    }
    public int BruteForce(int[]arr){
        int n=arr.length;
        int count=0,maxCount=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int sum=0;
            for (int j = i; j <n; j++) {
                sum+=arr[j];
                count++;
                if(sum==0){
                    maxCount=Math.max(maxCount,count);
                }
            }
            count=0;
        }
        return maxCount;
        // Time Complexity: O(N^2)
        // Space Complexity: O(1)
    }
}
