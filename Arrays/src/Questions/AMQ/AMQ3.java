package Questions.AMQ;
import java.util.HashMap;

// Question: Majority Element-I
// Note: The majority element is the element that appears more than ⌊n / 2⌋ times.

public class AMQ3 {
    public static void main(String[] args) {
        int[] arr={2,2,1,3,3,2,2};
        AMQ3 obj=new AMQ3();
        System.out.println(obj.BruteForce(arr));
        System.out.println(obj.Better(arr));
    }
    public int BruteForce(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }
            if(count>(arr.length/2)){
                return arr[i];
            }
        }
        return -1;
        // Time Complexity:  O(N^2)
        // Space Complexity:O(1)
    }
    public int Better(int[] arr){
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(int key:map.keySet()){
            if(map.get(key)>arr.length/2){
                return key;
            }
        }
        return -1;
        // Time Complexity:  O(N)
        // Space Complexity: O(N)
    }
    public int Optimal(int[] arr){
        int count=0;
        int candidate=0;
        for (int i = 0; i < arr.length; i++) {
            if(count==0){
                count=1;
                candidate=arr[i];
            }
            else if(arr[i]==candidate){
                count++;
            }
            else{
                count--;
            }
        }
        int count1=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==candidate){
                count1++;
            }
        }
        if(count1>(arr.length/2)){
            return candidate;
        }
        return -1;
        // Time Complexity:  O(N)
        // Space Complexity: O(1)

    }
}
