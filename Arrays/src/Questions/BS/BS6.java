package Questions.BS;

// Question: Minimum in Rotated Sorted Array

// Problem Statement:
// Given an integer array arr of size N, sorted in ascending order (with distinct values),
// the array is rotated at any index which is unknown.
// Find the minimum element in the array.

public class BS6 {
    public static void main(String[] args) {
        BS6 obj=new BS6();
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(obj.Optimal(arr));
    }
    public int Optimal(int[] arr){
        int ans= Integer.MAX_VALUE;
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr[left]<=arr[right]){ // edge case if remaining array is sorted
                ans=Math.min(ans,arr[left]);
                break;
            }
            if(arr[left]<=arr[mid]){
                ans=Math.min(ans,arr[left]);
                left=mid+1;
            }
            else{
                ans=Math.min(ans,arr[mid]);
                right=mid-1;
            }

        }
        return ans;
        // Time Complexity: O(log n) base 2
        // Space Complexity: O(1)
    }
}
