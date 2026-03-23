package Questions.AEQ;
import java.util.Arrays;
import java.util.HashSet;

// Question: Remove Duplicates in-place from Sorted Array
public class AEQ4 {
    public static void main(String[] args) {
        int[] arr={1,1,2,2,2,3,3};
        AEQ4 level= new AEQ4();
        int[] result = level.BruteForce(arr);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(level.BruteForce2(arr)));
        int n= level.Optimal(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public int Optimal(int[] arr){
        int i=0;
        for (int j = 1; j < arr.length; j++) {
            if(arr[i]!=arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i+1;
        // TC -> O(N)
        // SC -> O(1)
    }
    public int[] BruteForce(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int i : arr) {
            set.add(i);
        }

        int[] result = new int[set.size()];
        int index = 0;

        for (int val : set) {
            result[index++] = val;
        }
        return result;
        // TC -> O(N)
        // SC -> O(N)
    }
    public int[] BruteForce2(int[] arr) {
        return Arrays.stream(arr).distinct().toArray();
        // TC -> O(N)
        // SC -> O(N)
    }

}
