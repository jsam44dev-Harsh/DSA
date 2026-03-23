package Questions.AMQ;

// Question: Print the matrix in spiral manner
// Problem Statement: Given a Matrix, print the given matrix in spiral order.
// Time Complexity: O(n^2)
// Space Complexity: O(1)

import java.util.ArrayList;
import java.util.List;

public class AMQ12 {
    public static void main(String[] args) {
        int[][] arr={{1,2,3,4,5,6},
                {7,8,9,10,11,12},
                {13,14,15,16,17,18},
                {19,20,21,22,23,24},
                {25,26,27,28,29,30},
                {30,31,32,33,34,35}
            };
        List list=spiral(arr);
        System.out.println(list);
    }
    public static List<Integer> spiral(int[][] arr){
        List<Integer> ans=new ArrayList<>();
        int n=arr.length;
        int m=arr[0].length;
        int top=0;
        int left=0;
        int right=m-1;
        int bottom=n-1;
        while (left<=right&&top<=bottom){
            for(int i=left;i<=right;i++){
                ans.add(arr[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++){
                ans.add(arr[i][right]);
            }
            right--;
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    ans.add(arr[bottom][i]);
                }
                bottom--;
            }

            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    ans.add(arr[i][left]);
                }
                left++;
            }
        }
        return ans;
    }
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
}
