package Questions.BS;


// Question: Peak element in Array
// Problem Statement: Given an array of length N, peak element is defined as the element greater than both of
// its neighbors. Formally, if arr[i] is the peak element, arr[i - 1] < arr[i] and arr[i + 1] < arr[i].
// Find the index(0-based) of a peak element in the array.
// If there are multiple peak numbers, return the index of any peak number.


public class BS8 {
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1};
        BS8 obj=new BS8();
        System.out.println(obj.BruteForce(arr));
        System.out.println(obj.Optimal(arr));
        System.out.println(obj.Optimal2(arr));
    }

    public int Optimal2(int[]arr){ // works for 2 or more peak
        int n=arr.length;
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] > arr[mid + 1]) {
                high = mid;
            }
            else low = mid + 1;

        }
        return arr[low];
        // Time Complexity: O(log n) base 2
        // Space Complexity: O(1)
    }

    public int Optimal(int[] arr) { // works for only 1 peak
        int n = arr.length;

        if(n==1) return arr[0];
        if(arr[0]>arr[1]) return arr[0];
        if(arr[n-1]>arr[n-2]) return arr[n-1];

        int low = 1;
        int high = n - 2;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if(arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1]) {
                return arr[mid];
            } else if (arr[mid]>arr[mid-1]) {
                low = mid+1;
            }
            else if(arr[mid]>arr[mid+1]) {
                high = mid - 1;
            }
        }
        return -1;
        // it fails for this case {1,5,1,2,1}
        // Time Complexity: O(log n) base 2
        // Space Complexity: O(1)
    }
    public int BruteForce(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean left = (i == 0) || (arr[i] >= arr[i - 1]);
            boolean right = (i == n - 1) || (arr[i] >= arr[i + 1]);
            if (left && right) return arr[i];
        }
        return -1;
        // Time Complexity: O(n)
        // Space Complexity: O(1)
    }
}
