package Questions.AEQ;

// Question: Maximum Consecutive Ones
public class AEQ11 {
    public static void main(String[] args) {
        int[] arr={1,1,0,1,1,1,1,0,1,1,1};
        AEQ11 obj=new AEQ11();
        System.out.println(obj.BruteForce(arr));
        System.out.println(obj.Optimal(arr));
    }
    public int BruteForce(int[] arr){
        int count=0,maxCount=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==1){
                count++;
                maxCount=Math.max(maxCount,count);
            }
            else {
                count=0;
            }
        }
        return maxCount;
        // TC -> O(N)
        // SC->  O(1)

    }

    public int Optimal(int[] nums) {
        int l = 0;
        int r = 0;
        int n = nums.length;
        int maxLen = 0;
        while (r < n) {
            if (nums[r] == 0) {
                l = r;
            }

            maxLen = Math.max(maxLen, r - l);
            r++;
        }

        return maxLen;
        // TC -> O(N)
        // SC->  O(1)
    }
}
