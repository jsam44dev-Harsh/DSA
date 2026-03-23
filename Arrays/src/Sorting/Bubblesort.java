package Sorting;
import java.util.Arrays;
// push the max to the last by adjacent swap;

public class Bubblesort {
    public static void main(String[] args) {
        int[] num = {3, 2, 5, 4, 1};
        System.out.println(Arrays.toString(sorting(num)));
    }

    public static int[] sorting(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n ; i++) {
            for (int j = 1; j < n - i; j++) { // Fix loop condition
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }
        return arr;
    }

    public static void swap(int[] arr1, int a, int b) {
        int temp = arr1[a];
        arr1[a] = arr1[b];
        arr1[b] = temp;
    }
}
