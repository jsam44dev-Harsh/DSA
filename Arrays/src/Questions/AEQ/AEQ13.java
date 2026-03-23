package Questions.AEQ;

import java.util.HashMap;

// Question: Longest subarray with given sum K(positives) and K(Negative, zero and Positive)

public class AEQ13 {
    public static void main(String[] args) {
        int[]  arr = {1,2,3,1,1,1,1,4,3,2};
        int[] arr2={2,0,0,3};
        AEQ13 obj = new AEQ13();
        System.out.println(obj.Optimal(arr2,3));
        System.out.println(obj.Optimal2(arr,6));
        System.out.println(obj.Better(arr,7));
        System.out.println(obj.BruteForce1(arr,3));
        System.out.println(obj.BruteForce2(arr,3));
    }
    public int Optimal2(int[] arr, int k) {
        int n = arr.length;
        int maxLen = 0;
        int left = 0, right = 0;
        int sum = arr[0];
        while (right < n) {
            while (left <= right && sum > k) {
                sum -= arr[left];
                left++;
            }
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
            if (right < n) {
                sum += arr[right];
            }
        }
        return maxLen;
        // TC -> O(2N)
        // SC -> O(1)
    }
    public int Optimal(int[] arr, int k){
        int i=0;
        int j=0,sum=0,len=0;
        while(j<arr.length){
            sum+=arr[j];
            if(sum==k)len=Math.max(len,j-i+1);
            if(sum>k){
                sum-=arr[i];
                i++;
                if(sum==k)len=Math.max(len,j-i+1);
            }
            j++;
        }
        return len;
        // TC -> O(N)
        // SC -> O(1)
    }
    public int Better(int[] arr,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==k){
                maxLen=Math.max(maxLen,i+1);
            }
            int rem=sum-k;
            if(map.containsKey(rem)){
                int len=i-map.get(rem);
                maxLen=Math.max(maxLen,len);
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return maxLen;
        /*
         TC -> O(N)
         SC -> O(N)
                Using HashMap (Unordered Map):
                Time Complexity (Worst Case): O(n²)
                Space Complexity: O(n)

                Using TreeMap (Ordered Map):
                Time Complexity (Worst Case): O(n log n)
                Space Complexity: O(n)
        */

    }
    public int BruteForce2(int[] arr, int k){
        int length=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=i;j<arr.length;j++){
                sum+=arr[j];
                if(sum==k){
                    length=Math.max(length,j-i+1);
                }
            }
        }
        return length;
        // TC -> O(N)^2
        // SC -> O(1)
    }
    public int BruteForce1(int[] arr,int k){
        int length=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int sum=0;
                for (int l = i; l <=j; l++) {
                    sum+=arr[l];
                }
                if(sum==k){
                    length=Math.max(length,j-i+1);
                }
            }
        }
        return length;
        // TC -> O(N)^3
        // SC -> O(1)
    }
}
