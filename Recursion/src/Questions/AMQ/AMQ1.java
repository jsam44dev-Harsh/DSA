package Questions.AMQ;

// Question: Permutation

import java.util.ArrayList;
import java.util.List;

public class AMQ1 {
    public static void main(String[] args) {
        int[] arr={1,2,3};
        AMQ1 obj = new AMQ1();
//        List<List<Integer>> list=obj.BruteForce(arr);
//        System.out.println(list);
        List<List<Integer>> list=obj.Optimal(arr);
        System.out.println(list);
    }
    public List<List<Integer>> Optimal(int[] nums){
        List<List<Integer>> ans=new ArrayList<>();
        recurPermuteOptimal(0,nums,ans);
        return ans;
        // Time Complexity: O(N!)+O(N)
        // Space Complexity: O(N){ds data structure}
    }
    public void recurPermuteOptimal(int index,int[] nums,List<List<Integer>> ans){
        if(index==nums.length){
            List<Integer> ds=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index;i<nums.length;i++){
            swap(i,index,nums);
            recurPermuteOptimal(index+1,nums,ans);
            swap(i,index,nums);
        }
    }
    public void swap(int i,int j,int[]arr){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public List<List<Integer>> BruteForce(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        boolean[] freq= new boolean[nums.length];
        recurPermute(nums,ds,ans,freq);
        return ans;

    // Time Complexity: O(N!)+O(N)
    // Space Complexity: O(N){ds data structure}+O(N) {freq data Structure}
    }

    private void recurPermute(int[] nums, List<Integer> ds, List<List<Integer>> ans, boolean[] freq) {
        if(ds.size()==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!freq[i]){
                freq[i]=true;
                ds.add(nums[i]);
                recurPermute(nums,ds,ans,freq);
                ds.remove(ds.size()-1);
                freq[i]=false;
            }
        }
    }
}
