package Questions.BS;
import java.util.Arrays;


// Question: Capacity to Ship Packages within D Days


// Problem Statement:
// You are the owner of a Shipment company.
// You use conveyor belts to ship packages from one port to another.
// The packages must be shipped within 'd' days.
// The weights of the packages are given in an array 'of weights'.
// The packages are loaded on the conveyor belts every day in the same order as they appear in the array.
// The loaded weights must not exceed the maximum weight capacity of the ship.
// Find out the least-weight capacity so that you can ship all the packages within 'd' days .


public class BS14 {
    public static void main(String[] args) {
        int[] arr={5,4,5,2,3,4,5,6};
        int days=5;
        BS14 obj=new BS14();
        System.out.println(obj.BruteForce(arr,days));
        System.out.println(obj.Optimal(arr,days));
    }
    public int Optimal(int[] arr,int days){
        int low= Arrays.stream(arr).max().getAsInt();
        int high= Arrays.stream(arr).sum();
        while (low<high){
            int mid=low+(high-low)/2;
            if(totalDaysToShipTheGivenWeight(arr,mid)<=days){
                high=mid;
            }
            else low=mid+1;
        }
        return low;
        // Time Complexity:  O(n × log M)
        // Space Complexity: O(1)
    }
    public int BruteForce(int[] arr,int days) {
        int low= Arrays.stream(arr).max().getAsInt();
        int high= Arrays.stream(arr).sum();
        for (int i = low; i <= high; i++) {
            if(totalDaysToShipTheGivenWeight(arr,i)<=days){
                return i;
            }
        }
        return -1;
        // Time Complexity:  O(n × M)
        // Space Complexity: O(1)
    }
    public int totalDaysToShipTheGivenWeight(int[] arr,int capacity){
        int currentLoad=0;
        int days=1;
        for(int w:arr){
            if(currentLoad+w>capacity){
                currentLoad=w;
                days++;
            }
            else{
                currentLoad+=w;
            }
        }
        return days;
        // Time Complexity:  O(n)
        // Space Complexity: O(1)
    }
}
