package Questions.AEQ;

// Question: Linear Search

public class AEQ8 {
    public static void main(String[] args) {
        AEQ8 obj=new AEQ8();
        int[] arr={7,5,3,9,0,1};
        int result =obj.Optimal(arr,0);
        System.out.println(result);
    }
    public int Optimal(int[] arr, int target){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
        // TC -> O(N)
        // SC->  O(1)
    }
}
