package Questions.BS;

import java.util.Arrays;
import java.util.List;

public class BS4 {
    public static void main(String[] args) {
        BS4 obj = new BS4();
        int[] arr={1,2,3};
        int x=3;
        System.out.println(obj.firstAndLastOccurrence(arr,x));
    }
    // BruteForce
    public List<Integer> firstAndLastOccurrence(int[] arr, int x) {
        int first = -1;
        int last = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                if (first == -1) {
                    first = i;
                }
                last = i;
            }
        }
        return Arrays.asList(first, last);
        // Time complexity: O(n)
        // Space complexity: O(1)
    }
}
