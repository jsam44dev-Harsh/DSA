package Questions.BS;
import java.util.Arrays;
import java.util.List;

// Question: First and last occurrence

public class BS4 {
    private BS1 obj = new BS1();
    private BS2 obj2 = new BS2();
    public static void main(String[] args) {
        BS4 obj = new BS4();
        int[] arr={1,2,3};
        int x=3;
        System.out.println(obj.firstAndLastOccurrence(arr,x));
        System.out.println("Optimal: "     + obj.Optimal(arr, x));
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

//    Optimal Approach
    public List<Integer> Optimal(int[] arr, int x) {

        int lb= obj.LowerBound(arr,x);
        if(lb==arr.length || arr[lb]!=x){
            return Arrays.asList(-1,-1);
        }
        return Arrays.asList(lb,obj2.UpperBound(arr,x)-1);
        // Time Complexity: 2 * (O(log n) base 2)
        // Space Complexity: O(1)
    }

}
