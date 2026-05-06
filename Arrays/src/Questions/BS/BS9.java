package Questions.BS;

// Question: Finding Sqrt of a number using Binary Search

// Problem Statement: You are given a positive integer n. Your task is to find and return its square root.
// If ‘n’ is not a perfect square, then return the floor value of sqrt(n).

public class BS9 {
    public static void main(String[] args) {
        BS9 obj= new BS9();
        System.out.println(obj.Optimal(80));
    }
    public int Optimal(int n){
        if (n < 2) return n;
        int low = 1;
        int high = n/2;
        while (low<=high){
            long mid= low+(high-low)/2;
            if(mid*mid>n){
                high = (int) mid-1;
            }
            else if(mid*mid<=n){
                low = (int) mid+1;
            }
        }
        return high;
        // Time Complexity: O(log n) base 2
        // Space Complexity: O(1)
    }
    public int BruteForce(int n){
        int ans=0;
        for (int i = 1; i <=n ; i++) {
            if(i*i<=n){
                ans=i;
            }
            else break;
        }
        return ans;
        // Time Complexity: O(n)
        // Space Complexity: O(1)
    }
}
