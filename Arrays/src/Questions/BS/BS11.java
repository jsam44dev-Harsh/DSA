package Questions.BS;

// Question: Koko Eating Bananas
// LeetCode Problem: 875

public class BS11 {
    public static void main(String[] args) {
        int[] arr={30,11,23,4,20};
        int h=6;
        BS11 obj=new BS11();
        System.out.println(obj.BruteForce(arr,h));
        System.out.println(obj.Optimal(arr,h));
    }

    public int Optimal(int[] arr,int h){
        int low=1,high=maxBananas(arr);
        while(low<=high){// O(log m)
            int mid=low+(high-low)/2;
            long hours=calculateTotalHours(arr,mid); // O(n)
            if(h>=hours){
                high=mid-1;
            }
            else low=mid+1;
        }
        return low;
        // Time Complexity:  O(n * log m)
        // Space Complexity: O(1)
    }
    public int BruteForce(int[] arr, int h){
        int maxBananas= maxBananas(arr);

        for (int i = 1; i <=maxBananas; i++) { // O(n)
            long totalHours=calculateTotalHours(arr,i);// O(m)
            if(totalHours<=h){
                return i;
            }
        }
        return maxBananas;
        // Time Complexity:  O(m*n)
        // Space Complexity: O(1)
    }


    private long calculateTotalHours(int[] arr, int i) {
        long totalHours=0;
        for (int pile: arr) {
            totalHours+=(int)Math.ceil((double)pile/i);
        }
        return totalHours;
    }

    public int maxBananas(int[] arr){
        int max=Integer.MIN_VALUE;
        for(int i : arr){
            max=Math.max(i,max);
        }
        return max;
    }
}
