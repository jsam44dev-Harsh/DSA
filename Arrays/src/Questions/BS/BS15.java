package Questions.BS;

// Question: Kth Missing Positive Number

//Problem Statement: You are given a strictly increasing array ‘vec’ and a positive integer 'k'.
// Find the 'kth' positive integer missing from 'vec'.
// LeetCode: 1539

public class BS15 {
    public static void main(String[] args) {
        int[] arr={2,3,4,7,11};
        int k=5;
        BS15 obj=new BS15();
        System.out.println(obj.BruteForce(arr,k));
        System.out.println(obj.Optimal(arr,k));
    }
    public int Optimal(int[] arr,int k){
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int missing=arr[mid] -(mid+1);
            if(missing<k){
                low=mid+1;
            }
            else high=mid-1;
        }
        return low+k; // or high+1+k
        // Time Complexity:  O(log(N))
        // Space Complexity: O(1)
    }
    public int BruteForce(int[] arr,int k){
        for(int i: arr){
            if(i<=k){
                k++;
            }
            else break;
        }
        return k;
        // Time Complexity:  O(N)
        // Space Complexity: O(1)
    }
}
