package Questions.BS;

// Question: Minimum days to make M bouquets

// Problem Statement: You are given 'N’ roses, and you are also given an array 'arr' where 'arr[i]'
// denotes that the 'ith' rose will bloom on the 'arr[i]th' day.
// You can only pick already bloomed roses that are adjacent to make a bouquet.
// You are also told that you require exactly 'k' adjacent bloomed roses to make a single bouquet.
// Find the minimum number of days required to make at least 'm' bouquets each containing 'k' roses.
// Return -1 if it is not possible.

import java.util.Arrays;

public class BS12 {
    public static void main(String[] args) {
        BS12 obj = new BS12();
        int[] bloomDays = {7, 7, 7, 7, 13, 11, 12, 7};
        int k = 3;
        int m = 2;
        System.out.println(obj.BruteForce(bloomDays,k,m));
        System.out.println(obj.Optimal(bloomDays,k,m));
    }

    public int Optimal(int[] arr, int m, int k) {
        int n = arr.length;
        long totalFlowers = (long) m * k;
        if (totalFlowers > n) return -1;

        int low  = Arrays.stream(arr).min().getAsInt();
        int high = Arrays.stream(arr).max().getAsInt();

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(arr, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
        // Time Complexity:  O(n * log(max − min))
        // Space Complexity: O(1)
    }


    public int BruteForce(int[] arr, int m, int k) {
        int n = arr.length;
        long totalFlowers=(long) m*k;
        if(totalFlowers > n) return -1;

        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();

        for(int day=min;day<=max;day++){
            if(isPossible(arr,day,m,k)){
                return day;
            }
        }
        return -1;
        // Time Complexity:  O(n * (max − min))
        // Space Complexity: O(1)
    }

    private boolean isPossible(int[] arr, int day, int m, int k) {
        int count=0;
        int bouquets=0;

        for(int bloom: arr){
            if (bloom <= day) {
                count++;
                if (count == k) {
                    bouquets++;
                    count = 0;
                }
            }
            else count = 0;
        }
        return bouquets>=m;
    }
}
