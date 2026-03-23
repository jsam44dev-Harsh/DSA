package Questions.AMQ;
import java.util.Arrays;

// Question: Rearrange array elements by sign
public class AMQ6 {
    public static void main(String[] args) {
        AMQ6 obj = new AMQ6();
        int[] arr = {3,1,-2,2,-5,-4};
//        obj.BruteForce(arr);
//        System.out.println("BruteForce: "+Arrays.toString(arr));

        System.out.println("Optimal: "+Arrays.toString(obj.Optimal(arr)));
    }


    // if no of positive = no of negative in array
    public int[] Optimal(int[] arr){
        int[] nums = new int[arr.length];
        int neg=1, pos=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
                nums[neg]=arr[i];
                neg+=2;
            }
            else{
                nums[pos]=arr[i];
                pos+=2;
            }
        }
        return nums;
        // Time Complexity: O(N)+O(N/2)
        // Space Complexity: O(N)
    }
    // if no of positive = no of negative in array
    public void BruteForce(int[] arr) {
        int[] pos=new int[arr.length/2];
        int[] neg=new int[arr.length/2];
        int j=0;
        int k=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                pos[j++]=arr[i];
            }
            else{
                neg[k++]=arr[i];
            }
        }
        for(int i=0;i<arr.length/2;i++) {
            arr[2 * i] = pos[i];
            arr[2 * i + 1] = neg[i];
        }
        // Time Complexity: O(N)+O(N/2)
        // Space Complexity: O(N)
    }
}
