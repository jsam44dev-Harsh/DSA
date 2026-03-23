package Questions.AEQ;

// Questions: Move Zeros to end

import java.util.Arrays;

public class AEQ7 {
    public static void main(String[] args) {
        AEQ7 obj = new AEQ7();
        int[] arr={1,0,7,0,3,0,0};
//        obj.BruteForce(arr);
//        System.out.println(Arrays.toString(arr));
        obj.Optimal(arr);
        System.out.println(Arrays.toString(arr));
    }
    public void Optimal(int[] nums){
        int left=0;
        for (int right = 0; right < nums.length; right++) {
            if(nums[right]!=0){
                int temp=nums[right];
                nums[right]=nums[left];
                nums[left]=temp;
                left++;
            }
        }
    }
    public void BruteForce(int[] nums) {
        int j=0;
        for(int i=0;i< nums.length;i++){
            if(nums[i]!=0){
                nums[j++]=nums[i];
            }
        }
        for(int i=j;i<nums.length;i++){
            nums[i]=0;
        }
    }

}
