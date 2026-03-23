package Questions.AHQ;

// Question: 4 Sum | Find Quads that add up to a target value

// Problem Statement: Given an array of N integers, your task is to find unique quads that add up
// to give a target value. In short, you need to return an array of all the unique
// quadruplets [arr[a], arr[b], arr[c], arr[d]] such that their sum is equal to a given target.
import java.util.*;

public class AHQ4 {
    public static void main(String[] args) {
        AHQ4 obj = new AHQ4();
        int[] arr={1,0,-1,0,-2,2};
        System.out.println(obj.BruteForce(arr,0));
        System.out.println(obj.Better(arr,0));
        System.out.println(obj.Optimal(arr,0));
    }

    public List<List<Integer>> Optimal(int[] arr,int target) {
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            if(arr[i]>0 && arr[i]==arr[i-1]) continue;
            for(int j=i+1;j<n;j++){
                if(arr[j]>0&&arr[j]==arr[j-1]) continue;
                int left=j+1;
                int right=n-1;
                while(left<right){
                    int sum=arr[i]+arr[j]+arr[left]+arr[right];
                    if(sum==target){
                        ans.add(Arrays.asList(arr[i],arr[j],arr[left],arr[right]));
                        left++;
                        right--;
                        while(left<right&&arr[left]==arr[left-1]) left++;
                        while(left<right&&arr[right]==arr[right+1]) right--;
                    }
                    else if(sum<target) left++;
                    else right--;
                }

            }
        }
        return ans;
//        Time Complexity: O(N^3)
//        Space Complexity: O(1)
    }
    public List<List<Integer>> Better(int[] arr,int target) {
        int n = arr.length;
        Set<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                HashSet<Integer> set = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    int fourth = target-(arr[i] + arr[j] + arr[k]);
                    if(set.contains(fourth)){
                        List<Integer> temp=Arrays.asList(arr[i],arr[j],arr[k],fourth);
                        Collections.sort(temp);
                        ans.add(temp);
                    }
                    set.add(arr[k]);
                }
            }
        }
        return new ArrayList<>(ans);
        // Time Complexity: O(N^3*log(M)
        // Space Complexity: O(2 * no. of the quadruplets)+O(N)
    }
    public List<List<Integer>> BruteForce(int[] arr,int target) {
        int n = arr.length;
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (arr[i] + arr[j] + arr[k] + arr[l] == target) {
                            List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                            Collections.sort(temp);
                            set.add(temp);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(set);
        // Time Complexity: O(n^4)
        // Space Complexity: O(n)*2
    }
}
