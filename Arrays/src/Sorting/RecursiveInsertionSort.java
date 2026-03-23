package Sorting;
import java.util.Arrays;

public class RecursiveInsertionSort {
    public static void main(String[] args) {
        int[] arr={5,2,1,4,3};
        RecursiveInsertionSort sort=new RecursiveInsertionSort();
        sort.InsertionSort(arr,0);
        System.out.println(Arrays.toString(arr));
    }
    public void InsertionSort(int[] arr,int n){
        if(n==arr.length-1){
            return;
        }
        for(int i=n+1;i>0;i--){
            if(arr[i]<arr[i-1]){
                int temp=arr[i];
                arr[i]=arr[i-1];
                arr[i-1]=temp;
            }
            else{
                break;
            }
        }
        InsertionSort(arr,n+1);
    }
}

