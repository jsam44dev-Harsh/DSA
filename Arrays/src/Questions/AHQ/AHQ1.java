package Questions.AHQ;

// Question: Pascal Triangle

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AHQ1 {
    public static void main(String[] args) {
        AHQ1 obj=new AHQ1();
        System.out.println(obj.Approach1(5,3));
        System.out.println(obj.Approach2(5));

        List<List<Integer>> result = obj.Approach3(5);
        for (List<Integer> row : result) {
            for (Integer val : row) System.out.print(val + " ");
            System.out.println();
        }
    }
    // To print the element of the pascal triangle on particular position
    public int Approach1(int row, int col){
        int result = 1;
        for(int i = 1; i <= col-1; i++){
            result *= (row - i);
            result /= i;
        }
        return result;
        // Time Complexity:  O(N)
        // Space Complexity: O(1)
    }

    // To print the Pascal Triangle
    public List<List<Integer>> Approach3(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(Collections.nCopies(i + 1, 1));
            for (int j = 1; j < i; j++) {
                row.set(j, triangle.get(i - 1).get(j - 1) +
                        triangle.get(i - 1).get(j));
            }
            triangle.add(row);
        }
        return triangle;
    }


    // To print row of the pascal triangle
    public List<Integer> Approach2(int row){
        // ******************Brute Force Approach********************
        List<Integer> result=new ArrayList<>();
//
//        for (int col = 1; col <=row; col++) {
//            result.add(Approach1(row,col));
//        }
//        return result;

        // Time Complexity:  O(N^2)
        // Space Complexity: O(N)

        // *****************Optimal Approach******************
        int ans=1;
        result.add(ans);
        for(int col = 1; col < row; col++){
            ans*=(row-col);
            ans/=col;
            result.add(ans);
        }
        return result;
        // Time Complexity:  O(N)
        // Space Complexity: O(N)
    }
}
