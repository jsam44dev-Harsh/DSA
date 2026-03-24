package Questions.BS;

// Floor and Ceil in Sorted Array
// Problem Statement: You're given a sorted array arr of n integers and an integer x.
// Find the floor and ceiling of x in arr[0..............n-1].

// The floor of x is the largest element in the array which is smaller than or equal to x. (arr[index]<=x)

// The ceiling of x is the smallest element in the array greater than or equal to x. (arr[index]>=x)

public class BS3 {
    public static void main(String[] args) {
        BS3 obj = new BS3();
        int[]arr={10,20,30,40,50};
        int x=35;
        System.out.println(obj.Ceil(arr,x));
        System.out.println(obj.Floor(arr,x));
    }
    public int Ceil(int[] arr,int x){
        int low=0;
        int high=arr.length-1;
        int ans= arr.length;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>=x){
                ans=arr[mid];
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
        // Time Complexity: O(log n) base 2
        // Space Complexity: O(1)
    }
    public int Floor(int[] arr,int x){
        int low=0;
        int high=arr.length-1;
        int ans= arr.length;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>=x){

                high=mid-1;
            }
            else {
                ans=arr[mid];
                low=mid+1;
            }
        }
        return ans;
        // Time Complexity: O(log n) base 2
        // Space Complexity: O(1)
    }

}
