package Questions.AEQ;
import java.util.HashMap;

// Question: Find the number that appears once, and other numbers twice.

public class AEQ12 {
    public static void main(String[] args){
        int[] arr= {4,1,2,1,2};
        System.out.println(BruteForce(arr));
        System.out.println(Better(arr));
        System.out.println(Optimal(arr));
    }
    public static int Optimal(int[] arr){
        int xor=0;
        for(int i: arr){
            xor=xor^i;
        }
        return xor;
//        Time Complexity (Worst Case): O(N)
//        Space Complexity: O(1)
    }
    public static int Better(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int j : arr) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }

        for(int key:map.keySet()){
            if(map.get(key)==1) return key;
        }
        return -1;
//        Time Complexity (Worst Case): O(N)
//        Space Complexity: O(N)
    }
    public static int BruteForce(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int count=0;
            for (int j = 1; j < arr.length ; j++) {
                if(arr[j]==arr[i]){
                    count++;
                }
            }
            if(count==0){
                return arr[i];
            }
        }
        return -1;
//        Time Complexity (Worst Case): O(n²)
//        Space Complexity: O(1)
    }
}
