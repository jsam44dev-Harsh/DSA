package Searching;

public class BinarySearch {
    public static void main(String[] args) {
        int []arr= {2,4,6,9,11,12,14,20,36,48};
        int find=48;
        System.out.println(Binary(arr,find));
        System.out.println(Recursion(arr,find,0,arr.length-1));

    }
    static int Binary(int[]arr,int target){
        int start=0;
        int end=arr.length-1;
        while (start<=end){
            int mid=(start+end)/2;
            if(target>arr[mid]){
                start=mid+1;
            }
            else if (target<arr[mid]) {
                end=mid-1;
            }
            else {
                return mid;
            }
        }
        return -1;
        // Time Complexity: O(log n) base 2
        // Space Complexity: O(1)
    }
    static int Recursion(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2; // to avoid overflow case of Integer
        if (target > arr[mid]) {
            return Recursion(arr, target, mid + 1, end);
        } else if (target < arr[mid]) {
            return Recursion(arr, target, start, mid - 1);
        }
        return mid;
        // Time Complexity: O(log n) base 2
        // Space Complexity: O(log n)
    }
}