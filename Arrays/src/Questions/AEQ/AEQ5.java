package Questions.AEQ;

// Question: Left rotate an array by one place

import java.util.Arrays;

public class AEQ5 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        oneRotate(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void oneRotate(int[] arr){
        int n = arr.length-1;
        int last=arr[0];
        for(int i=1;i<=n;i++){
            arr[i-1]=arr[i];
        }
        arr[n]=last;
        // TC -> O(N)
        // SC -> O(1)
    }

}
