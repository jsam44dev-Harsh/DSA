package Questions.AMQ;

// Question: Longest Consecutive Sequence in an Array

// Problem Statement: Given an array nums of n integers.

// Return: the length of the longest sequence of consecutive integers.
// The integers in this sequence can appear in any order.

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AMQ9 {
    public static void main(String[] args) {
        int[] a = {100, 4, 200, 1, 3, 2,5};
        AMQ9 obj = new AMQ9();
        System.out.println(obj.BruteForce(a));
        System.out.println(obj.Better(a));
        System.out.println(obj.Optimal(a));
    }
    public int Optimal(int[] nums) {
        int n = nums.length;
        int longest= 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        for (int item : set) {
            if (!set.contains(item-1)) {
                int count=1;
                int x=item;
                while(set.contains(x+1)){
                    count++;
                    x++;
                }
                longest=Math.max(longest,count);
            }
        }
        return longest;
        // Time Complexity: O(n)+O(3n) => O(n)
        // Space Complexity: O(n)
    }
    public int Better(int[] arr) {
        Arrays.sort(arr);
        int lastSmaller=Integer.MIN_VALUE;
        int count=0,longest=0;
        for (int i:arr){
            if(i-1==lastSmaller){
                count++;
                lastSmaller=i;
            }
            else{
                count=1;
                lastSmaller=i;
            }
            longest=Math.max(count,longest);
        }
        return longest;
        // Time Complexity: O(n log n)
        // Space Complexity: O(1)
    }
    public int BruteForce(int[] arr) {
        int longest=0,count;
        for(int i:arr){
            int x=i;
            count=1;
            while(linearSearch(arr, x + 1)){
                count++;
                x++;
            }
            longest=Math.max(count,longest);
        }
        return longest;
        // Time Complexity: O(n)^2
        // Space Complexity: O(1)
    }

    private boolean linearSearch(int[] arr, int i) {
        for (int j = 0; j < arr.length; j++) {
            if(arr[j]==i){
                return true;
            }
        }
        return false;
    }
}
