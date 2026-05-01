package Questions.BS;

// Question: Search Single Element in a sorted array

// Problem Statement: Given an array of N integers.
// Every number in the array except one appears twice. Find the single number in the array.

public class BS7 {
    public static void main(String[] args) {
        int[] arr={1,1,2,2,3,3,4,5,5,6,6};
        BS7 obj= new BS7();
        System.out.println(obj.BruteForce(arr));
        System.out.println(obj.BruteForce2(arr));
        System.out.println(obj.Optimal(arr));
    }

    public int Optimal(int[] arr){
        int n=arr.length;
        int low=0;
        int high=n-1;

        if(n==1) return arr[0];
        else if(arr[0]!=arr[1]) return arr[0];
        else if(arr[n-1]!=arr[n-2]) return arr[n-1];

        while(low<=high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
                return arr[mid];
            } else if ((mid % 2 == 1 && arr[mid] == arr[mid - 1]) ||
                    (mid % 2 == 0 && arr[mid] == arr[mid + 1]))  {
                low = mid + 1;
            } else high = mid - 1;
        }

        return -1;
        // Time Complexity: O(log n) base 2
        // Space Complexity: O(1)
    }
    public int BruteForce2(int[] arr) {
        int n = arr.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans = ans ^ arr[i];
        }
        return ans;
        // Time Complexity: O(n)
        // Space Complexity: O(1)
    }
    public int BruteForce(int[] arr) {
        int n= arr.length;
        for (int i = 0; i < n; i++) {
            if(i==0){
                if(arr[i]!=arr[i+1]){
                    return arr[i];
                }
            }
            else if(i==n-1){
                if(arr[i]!=arr[i-1]){
                    return arr[i];
                }
            }
            else{
                if(arr[i-1]!=arr[i] && arr[i]!=arr[i+1]){
                    return arr[i];
                }
            }
        }
        return Integer.MIN_VALUE;
        // Time Complexity: O(n)
        // Space Complexity: O(1)
    }
}
