package Questions.AMQ;

// Questions: Stock Buy and Sell

public class AMQ5 {
    public static void main(String[] args) {
        AMQ5 obj = new AMQ5();
//        int[] arr={7,1,5,3,6,4};
        int[] arr={2,4,1};
        System.out.println(obj.Optimal(arr));
    }
    public int Optimal(int[] arr) {
        int Buy=arr[0];
        int maxProfit=0;
        for(int i=1;i<arr.length;i++){
            int Sell=arr[i]-Buy;
            maxProfit=Math.max(maxProfit,Sell);
            Buy=Math.min(Buy,arr[i]);
        }
        return maxProfit;
        // Time Complexity: O(N)
        // Space Complexity: O(1)
    }
}
