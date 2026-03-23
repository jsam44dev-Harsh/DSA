package Questions.AMQ;

import java.util.Arrays;

// Question: Rotate matrix by 90 degrees
// Problem Statement: Given an N * N 2D integer matrix, rotate the matrix by 90 degrees clockwise.
// The rotation must be done in place, meaning the input 2D matrix must be modified directly.
public class AMQ11 {
    public static void main(String[] args) {
        AMQ11 obj=new AMQ11();
        int[][]arr={
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        int[][] rotated= obj.BruteForce(arr);
        System.out.println("Brute Force Answer");
        for (int[] row : rotated) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
        System.out.println("Optimal Answer");
        obj.Optimal(arr);
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }
    public void Optimal(int[][] arr){
        int n=arr.length;
        int m=arr[0].length;
        // Transpose the matrix
        for(int i=0;i<n;i++){
            for(int j=i+1;j<m;j++){
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
        // Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = arr[i][left];
                arr[i][left] = arr[i][right];
                arr[i][right] = temp;
                left++;
                right--;
            }
        }
        // Time Complexity: O(n^2)
        // Space Complexity: O(1)
    }

    public int[][] BruteForce(int[][] arr){
        int n= arr.length;
        int m= arr[0].length;
        int[][] ans= new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[j][(n-1)-i]=arr[i][j];
            }
        }
        return ans;
        // Time Complexity: O(n^2)
        // Space Complexity: O(n^2)
    }
}
