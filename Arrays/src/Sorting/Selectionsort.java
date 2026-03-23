package Sorting;

import java.util.Arrays;

public class Selectionsort {
    public static void main(String[] args) {
        int []nums={5,4,1,3,2};
        selection(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void selection(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int last= arr.length-i-1;
            int maxIndex=getMaxIndex(arr,0,last);
            swap(arr,maxIndex,last);
        }
    }
    static void swap(int[]arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    static int getMaxIndex(int []arr,int start, int last){
        int max=start;
        for (int i = start; i < last; i++) {
            if(arr[max]<arr[i]){
                max=i;
            }
        }
        return max;
    }


}

