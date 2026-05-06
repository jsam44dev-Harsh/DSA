package Questions.BS;

// Question: Nth Root of a Number using Binary Search

// Problem Statement: Given two numbers N and M, find the Nth root of M.
// The nth root of a number M is defined as a number X when raised to the power N equals M.
// If the nth root is not an integer, return -1.

public class BS10 {
    public static void main(String[] args) {
        int n=3,m=27;
        System.out.println(BruteForce(n,m));
    }
    public static int Optimal(int n,int m){
        int low = 1, high = m;

        while (low <= high) {
            int mid = (low + high) / 2;
            long ans = 1;

            for (int i = 0; i < n; i++) {
                ans *= mid;
                if (ans > m) break;
            }

            if (ans == m) return mid;
            if (ans < m) low = mid + 1;
            else high = mid - 1;
        }
        return -1;

    }

    public static int BruteForce(int n, int m){
        for (int i = 1; i <= m; i++) {
            long power= (long)Math.pow(i,n);
            if(power==m) return i;
            else if(power>m) break;
        }
        return -1;
        // Time Complexity: O(n)
        // Space Complexity: O(1)
    }
}
