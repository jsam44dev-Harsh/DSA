package Questions.AHQ;

// Questions: Majority Elements(N/3 times) | Find the elements that appears more than N/3 times in the array

// Problem Statement: Given an integer array nums of size n.
// Return all elements which appear more than n/3 times in the array.
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AHQ2 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,3,3,2,2,2};
        AHQ2 obj = new AHQ2();
        System.out.println(obj.BruteForce(arr));
        System.out.println(obj.Better(arr));
        System.out.println(obj.Optimal(arr));
    }
    public List<Integer> Optimal(int[] arr) {
        int n = arr.length;
        int cnt1 = 0, cnt2 = 0;
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && el2 != arr[i]) {
                cnt1 = 1;
                el1 = arr[i];
            } else if (cnt2 == 0 && el1 != arr[i]) {
                cnt2 = 1;
                el2 = arr[i];
            } else if (arr[i] == el1) {
                cnt1++;
            } else if (arr[i] == el2) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0; cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == el1) cnt1++;
            if (arr[i] == el2) cnt2++;
        }

        int mini = n / 3 + 1;
        List<Integer> result = new ArrayList<>();
        if (cnt1 >= mini) result.add(el1);
        if (cnt2 >= mini && el1 != el2) result.add(el2);

        return result;
        // Time Complexity: O(N)
        // Space Complexity: O(1)
    }
    public List<Integer> Better(int[] arr) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int mini = arr.length / 3 + 1;
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if(map.get(i)==mini){
                list.add(i);
            }
            if(list.size()==2){
                break;
            }
        }
        return list;
        // Time Complexity: O(N)
        // Space Complexity: O(N) use of the Hashmap
    }
    public List<Integer> BruteForce(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            int count = 0;
            if (list.isEmpty() || list.get(0) != i && (list.size() < 2 || list.get(1) != i)) {
                for (int j : arr) {
                    if (i == j) {
                        count++;
                    }
                }
                if (count > arr.length / 3) {
                    list.add(i);
                }
            }
            if (list.size() == 2) {
                break;
            }
        }
        return list;
        // Time Complexity: O(N^2)
        // Space Complexity: O(1)
    }
}
