package Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums={10,7,8,9,1,5};
        QuickSort q = new QuickSort();
        q.qs(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
    public void qs(int[] arr, int low,int high){
        if(low<high){
            int pivot=partition(arr, low, high);
            qs(arr,low,pivot-1);
            qs(arr,pivot+1,high);
        }
    }
    public int partition(int[] arr,int low,int high){
        int pivot=arr[low];
        int i=low;
        int j=high;
        while(i<j){
            while(arr[i]<=pivot && i<=high-1){
                i++;
            }
            while(arr[j]>pivot&&j>=low+1){
                j--;
            }
            if(i<j){
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        int tme=arr[low];
        arr[low]=arr[j];
        arr[j]=tme;
        return j;
    }
}
