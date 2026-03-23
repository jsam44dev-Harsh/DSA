package Questions.AHQ;
import java.util.HashMap;

//Question: Count the number of subarrays with given xor K

// Problem Statement: Given an array of integers A and an integer B.
// Find the total number of subarrays having bitwise XOR of all elements equal to k.

public class AHQ6 {
    public static void main(String[] args) {
        int[] arr={4,2,2,6,4};
        System.out.println(Better(arr,6));
        System.out.println(Optimal(arr,6));
    }
    public static int Better(int[] arr,int k) {
        int n = arr.length;
        int count=0;
        for(int i=0;i<n;i++){
            int xor=0;
            for(int j=i;j<n;j++){
                xor ^=arr[j];
                if(xor==k){
                    count++;
                }
            }
        }
        return count;
        // Time Complexity: O(N^2)
        // Space Complexity: O(1)
    }
    public static int Optimal(int[] arr,int k){
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int count=0;
        int prefixXor=0;
        for(int i: arr){
            prefixXor ^=i;

            int target=prefixXor^k;
            if(map.containsKey(target)){
                count+=map.get(target);
            }
            map.put(prefixXor,map.getOrDefault(prefixXor,0)+1);
        }
        return count;
        // Time Complexity: O(N)
        // Space Complexity: O(N)
    }
}
