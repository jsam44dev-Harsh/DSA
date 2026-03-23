package Questions.AEQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Question: Left rotate an array by D places
public class AEQ6 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        int k=2;
        BruteForce(arr,k);
        System.out.println(Arrays.toString(arr));
    }
    public static void Optimal(int[] arr,int k){
        k%=arr.length;
        reverse(arr,0,arr.length-1);
        reverse(arr,0,k-1);
        reverse(arr,k,arr.length-1);
    }
    public static void reverse(int[] arr,int i,int j){
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
    public static void BruteForce(int[] arr,int k){
        int n = arr.length-1;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<k;i++){
            list.add(arr[i]);
        }
        for(int i=k;i<=n;i++){
            arr[i-k]=arr[i];
        }
        int j=0;
        for (int i = n-k+1; i <=n ; i++) {
            arr[i]= list.get(j++);
        }
        // TC -> O(N)
        // SC -> O(N)
    }
}
