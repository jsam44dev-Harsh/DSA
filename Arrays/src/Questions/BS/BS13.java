package Questions.BS;

// Question: Find the Smallest Divisor Given a Threshold

// Problem Statement:
// You are given an array of integers 'arr' and an integer i.e. a threshold value 'limit'.
// Your task is to find the smallest positive integer divisor,
// such that upon dividing all the elements of the given array by it,
// the sum of the division's result is less than or equal to the given threshold value.

public class BS13 {
    public static void main(String[] args) {
        int[] arr={44,22,33,11,1};
        int threshold=5;
        BS13 obj=new BS13();
        System.out.println(obj.BruteForce(arr,threshold));
        System.out.println(obj.Optimal(arr,threshold));
    }
    public int Optimal(int[] arr,int threshold){
        if (arr.length > threshold) return -1;
        int high=maxElement(arr);
        int low=1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(currentSum(arr,mid)<=threshold){
                high=mid-1;
            }
            else low=mid+1;
        }
        return low;
        // Time Complexity:  O(n × log M)
        // Space Complexity: O(1)

    }
    public int BruteForce(int[] arr, int threshold) {
        int max=maxElement(arr);
        for(int i=1;i<=max;i++){
            if(currentSum(arr,i)<=threshold){
                return i;
            }
        }
        return -1;
        // Time Complexity:  O(M × n)
        // Space Complexity: O(1)
    }

    // helper method to find current sum after dividing entire arr with divisor
    public int currentSum(int[] arr,int divisor){
        int sum=0;
        for (int j : arr) {
            sum += (int) Math.ceil((double) j / divisor);
        }
        return sum;
    }

    // helper method to find max element in the array
    public int maxElement(int[] arr){
        int max=Integer.MIN_VALUE;
        for (int j : arr) {
            max = Math.max(max, j);
        }
        return max;
    }
}
