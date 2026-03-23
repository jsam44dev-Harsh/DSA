package Questions.AEQ;
import java.util.Arrays;

//  Questions: Second-Largest Element in an Array

public class AEQ2 {
    public static void main(String[] args) {
        int[] arr={7,3,4,2,5,7,7,1};
        AEQ2 level= new AEQ2();
        System.out.println(level.BruteForce(arr));
        System.out.println(level.Better(arr));
        System.out.println(level.Optimal(arr));
    }
    public int BruteForce(int[] arr) {
        Arrays.sort(arr);
        int largest=arr[arr.length-1];
        int secondLargest=Integer.MIN_VALUE;
        for(int i= arr.length-2;i>=0;i--){
            if(arr[i]!=largest){
                secondLargest=arr[i];
                break;
            }
        }
        return secondLargest;
        // TC -> O(N logN)+O(N)
        // SC -> O(1)
    }
    public int Better(int[] arr){
        int largest=Integer.MIN_VALUE;
        for(int i: arr){
            if(i>largest){
                largest=i;
            }
        }
        int secondLargest=Integer.MIN_VALUE;
        for(int i:arr){
            if(i>secondLargest && i!=largest){
                secondLargest=i;
            }
        }
        return secondLargest;
        // TC -> O(N) + O(N)
        // SC -> O(1)
    }
    public int Optimal(int[] arr){
        if(arr.length<2){
            return Integer.MIN_VALUE;
        }
        int largest=Integer.MIN_VALUE;
        int secondLargest=Integer.MIN_VALUE;
        for(int i: arr){
            if(i>largest){
                secondLargest=largest;
                largest=i;
            }
            else if(i>secondLargest && i!=largest) {
                secondLargest = i;
            }
        }
        return secondLargest;
    }
    // TC -> O(N)
    // SC -> O(1)
}
