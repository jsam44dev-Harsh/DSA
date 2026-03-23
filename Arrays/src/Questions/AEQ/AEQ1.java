package Questions.AEQ;
import java.util.Arrays;

// Question: the largest number in an array

public class AEQ1 {
    public static void main(String[] args) {
        int[] arr={6,5,3,2,8,9,1,0};
        AEQ1 level=new AEQ1();
        System.out.println(level.BruteForce(arr));
        System.out.println(level.Optimal(arr));
    }
    public int BruteForce(int[] arr){
        Arrays.sort(arr);
        return arr[arr.length-1];
        // TC -> O(N log(N))
        // SC -> O(1)
    }
    public int Optimal(int[] arr){
        int large=Integer.MIN_VALUE;
        for (int j : arr) {
            if (j > large) {
                large = j;
            }
        }
        return large;
        // TC -> O(N)
        // SC -> O(1)
    }

}
