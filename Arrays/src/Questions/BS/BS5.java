package Questions.BS;

// Question: Search Element in a Rotated Sorted Array

// Problem Statement: Given an integer array arr, sorted in ascending order (with distinct values)
// and a target value k. The array is rotated at some pivot point that is unknown.
// Find the index at which k is present and if k is not present return -1.


public class BS5 {
    public static void main(String[] args) {
        BS5 obj = new BS5();
        int[] arr={7,8,9,1,2,3,4,5,6};
        int[] num={3,1,2,3,3,3,3};
        System.out.println(obj.Optimal(arr,1));
        System.out.println(obj.optimalDuplicates(num,7));
    }
    public int Optimal(int[] arr,int target){
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target){
                return mid;
            }
            if (arr[low]<=arr[mid]) {
                if(arr[low]<=target && target<=arr[mid]){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            else{
                if(arr[mid]<=target && target<=arr[high]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return Integer.MIN_VALUE;
        // Time Complexity: O(log n) base 2
        // Space Complexity: O(1)
    }
    // if there are duplicates in the array then solution
    public boolean optimalDuplicates(int[] arr,int target){
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target){
                return true;
            }
            if(arr[low]==arr[mid] && arr[mid]==arr[high]){
                low++;
                high--;
                continue;
            }
            if (arr[low]<=arr[mid]) {
                if(arr[low]<=target && target<=arr[mid]){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            else{
                if(arr[mid]<=target && target<=arr[high]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return false;
        // Time Complexity: O(log n) base 2
        // Space Complexity: O(1)
    }
}
