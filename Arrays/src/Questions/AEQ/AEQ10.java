package Questions.AEQ;

import java.util.HashMap;
import java.util.Map;

// Question: Find missing number in an array
public class AEQ10 {
    public static void main(String[] args) {
        int[] arr={5,1,4,2};
        AEQ10 obj= new AEQ10();
//        System.out.println(obj.BruteForce(arr,5));
//        System.out.println(obj.Better(arr,5));
        System.out.println(obj.Optimal1(arr,5));
        System.out.println(obj.Optimal2(arr,5));
    }
    public int Optimal2(int[] arr,int n){
        int xor1 = 0;
        int xor2 = 0;
        for (int i = 0; i <arr.length; i++) {
            xor1=xor1^(i+1);
            xor2=xor2^arr[i];
        }
        xor1=xor1^n;
        return xor1^xor2;
        // TC -> O(N)
        // SC->  O(1)
    }
    // Using the sum
    public int Optimal1(int[] arr,int n){
        int totalSum= (n*(n+1))/2;
        int currentSum = 0;
        for(int i=0;i<arr.length;i++){
            currentSum+=arr[i];
        }
        return totalSum-currentSum;
        // TC -> O(N)
        // SC->  O(1)
    }
    public int Better(int[] arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 1; i <= n; i++) {
            if (!map.containsKey(i)) {
                return i;
            }
        }
        return -1;
        // uses HashMap
        // TC -> O(N)
        // SC->  O(N)
    }

    public int BruteForce(int[]arr,int n){
        for(int i=1;i<=n;i++){
            boolean flag=false;
            for (int j = 0; j < n-1; j++) {
                if(arr[j]==i){
                    flag=true;
                    break;
                }
            }
            if(flag==false){
                return i;
            }
        }
        return -1;

        // TC -> O(n)*O(n)
        // SC->  O(1)
    }
}
