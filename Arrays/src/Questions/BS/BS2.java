package Questions.BS;
// Implement Upper Bound

// Problem Statement: Given a sorted array of N integers and an integer x,
// write a program to find the upper bound of x.

// What is Upper Bound?

//The upper bound algorithm finds the first or the smallest index in a sorted array
// where the value at that index is greater than the given key i.e. x.

//The upper bound is the smallest index, ind, where arr[ind] > x.

public class BS2 {
    public static void main(String[] args) {
        BS2 obj = new BS2();
        int[] arr={3, 5, 8, 9, 15, 19};
        int x=9;
        System.out.println(obj.UpperBound(arr,x));
        System.out.println(obj.Recursion(arr,x,0, arr.length-1, arr.length));
    }
    public int UpperBound(int[]arr,int x){
        if (arr == null || arr.length == 0) return 0;
        int low=0;
        int high=arr.length-1;
        int ans=arr.length;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>x){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
        // Time Complexity: O(log n) base 2
        // Space Complexity: O(1)
    }
    public int Recursion(int[]arr,int x,int low,int high,int ans){
        if(low>high){
            return ans;
        }
        int mid=(low+high)/2;
        if (arr[mid] > x) {
            return Recursion(arr, x, low, mid - 1, mid);
        } else {
            return Recursion(arr, x, mid + 1, high, ans);
        }
        // Time Complexity: O(log n) base 2
        // Space Complexity: O(log n)
    }
}
