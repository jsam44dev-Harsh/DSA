package Questions.AEQ;
// Question: Check whether the array is sorted or not;


public class AEQ3 {
    public static void main(String[] args) {
        int[] arr={1,2,1,3,4};
        AEQ3 level= new AEQ3();
        System.out.println(level.Optimal(arr));
    }
    public boolean Optimal(int[] arr){
        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[i-1]){
                return false;
            }
        }
        return true;
    }
}
