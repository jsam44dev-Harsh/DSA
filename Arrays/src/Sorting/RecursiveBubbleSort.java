package Sorting;

import java.util.Arrays;

public class RecursiveBubbleSort {
    public static void main(String[] args) {
        int[] arr={2,3,5,4,1};
        RecursiveBubbleSort sort=new RecursiveBubbleSort();
        sort.bubbleSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
    public void bubbleSort(int[] arr,int n){
        if(n==1){
            return;
        }
        boolean flag=false;
        for(int j=0;j<=n-2;j++){
            if(arr[j]>arr[j+1]){
                int temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
                flag=true;
            }
        }
        if(!flag){
            return;
        }
        bubbleSort(arr,n-1);
    }
}
