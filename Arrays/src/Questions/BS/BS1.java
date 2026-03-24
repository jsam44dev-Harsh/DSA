package Questions.BS;
// Implement Lower Bound

// Problem Statement: Given a sorted array of N integers and an integer x,
// write a program to find the lower bound of x.

// What is lower bound?
// The lower bound algorithm finds the first or the smallest index in a sorted array
// where the value at that index is greater than or equal to a given key i.e. x.

// The lower bound is the smallest index, ind, where arr[ind] >= x.
// But if any such index is not found, the lower bound algorithm returns n i.e. size of the given array.

public class BS1 {
    public static void main(String[] args) {
        BS1 obj= new BS1();
        int[] arr = {3, 5, 8, 15, 19}; // Sorted array
        int x = 9;
        System.out.println(obj.LowerBound(arr,x));
        System.out.println(obj.Recursion(arr,x,0,arr.length-1, arr.length));
    }
    public int LowerBound(int[]arr,int x){
        if (arr == null || arr.length == 0) return 0;
        int low=0;
        int high=arr.length-1;
        int ans=arr.length;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>=x){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans; // Lower Bound Index
        // Time Complexity: O(log n) base 2
        // Space Complexity: O(1)
    }
    public int Recursion(int[] arr, int x, int low, int high, int ans) {
        if (low > high) {
            return ans;
        }
        int mid = low + (high - low) / 2;
        if (arr[mid] >= x) {
            return Recursion(arr, x, low, mid - 1, mid);
        } else {
            return Recursion(arr, x, mid + 1, high, ans);
        }
        // Time Complexity: O(log n) base 2
        // Space Complexity: O(log n)
    }
}
