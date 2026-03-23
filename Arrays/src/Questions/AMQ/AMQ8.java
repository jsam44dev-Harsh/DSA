package Questions.AMQ;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Question: Leaders in an Array


public class AMQ8 {
    public static void main(String[] args) {
        int[] arr = {10,22,12,3,0,6};
        AMQ8 obj = new AMQ8();
        System.out.println(Arrays.toString(obj.BruteForce(arr)));
        List<Integer> arr1 = obj.Optimal(arr);
        System.out.println(Arrays.toString(arr1.toArray()));

    }
    public List<Integer> Optimal(int[] arr) {
        List<Integer> list = new ArrayList<>();
        if (arr.length == 0) {
            return list;
        }
        int max= Integer.MIN_VALUE;
        list.add(arr[arr.length-1]);
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]>max){
                list.add(arr[i]);
                max = arr[i];
            }
        }
        return list;
        // Time Complexity: O(N)
        // Space Complexity: O(N)
    }
    public int[] BruteForce(int[] arr) {
        List<Integer> list= new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            Boolean flag = true;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(arr[i]);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
        // Time Complexity: O(N^2)
        // Space Complexity: O(N)
    }
}
