package Searching;

public class LinearSearch {
    public static void main(String[] args) {
        int []arr= {2,4,6,9,11,12,14,20,36,48};
        int find=36;
        System.out.println(Linear(arr,find));
    }
    static int Linear(int[]arr,int target){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==target){
                return i;
            }
        }
        return Integer.MIN_VALUE;
    }

}
