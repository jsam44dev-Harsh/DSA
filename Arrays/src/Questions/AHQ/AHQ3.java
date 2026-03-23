package Questions.AHQ;
import java.util.*;

// Question: 3 Sum : Find triplets that add up to a zero

// Problem: Given an array of N integers, your task is to find unique triplets that add up to give a sum
// of zero. In short, you need to return an array of all the unique triplets [arr[a], arr[b], arr[c]]
// such that i!=j, j!=k, k!=i, and their sum is equal to zero.


public class AHQ3 {
    public static void main(String[] args) {
        AHQ3 obj = new AHQ3();
//        int[] arr = {-1, 0, 1, 2, -1, -4};
        int[] arr={-2,-2,-2,-1,-1,-1,0,0,0,2,2,2};
        System.out.println(obj.BruteForce(arr));
        System.out.println(obj.Better(arr));
        System.out.println(obj.Optimal(arr));
    }
    public List<List<Integer>> Optimal(int[]arr){
        int n = arr.length;
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            int left = i + 1, right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == 0) {
                    ans.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    left++;
                    right--;

                    while (left < right && arr[left] == arr[left - 1]) left++;
                    while (left < right && arr[right] == arr[right + 1]) right--;
                }
                else if (sum < 0) left++;
                else right--;
            }
        }
        return ans;
        // Time Complexity: O(n^2)
        // Space Complexity: O(k) for number of unique triplets stored in the ans
    }

    public List<List<Integer>> Better(int[] arr) {
        int n = arr.length;
        Set<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> st = new HashSet<>();
            for (int j = i+1; j <n ; j++) {
                int third=-(arr[i]+arr[j]);
                if(st.contains(third)){
                    List<Integer> temp= Arrays.asList(arr[i],arr[j],third);
                    Collections.sort(temp);
                    ans.add(temp);
                }
                st.add(arr[j]);
            }
        }
        return new ArrayList<>(ans);
        // Time Complexity: O(n^2)
        // Space Complexity: O(n + k) for ans and st
    }

    public List<List<Integer>> BruteForce(int[] arr){
        int n = arr.length;
        Set<List<Integer>> st= new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if(arr[i]+arr[j]+arr[k]==0) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                        Collections.sort(temp);
                        st.add(temp);
                    }
                }
            }
        }
        return new ArrayList<>(st);
        // Time Complexity:O((N^3))
        // Space Complexity: O(N) for storing unique triplets
    }
}
