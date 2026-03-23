package Questions.AEQ;

import java.util.Arrays;
import java.util.HashSet;

// Question: Find the Union for two Sorted Array's
public class AEQ9 {
    public static void main(String[] args) {
        int[] arr={1,2,2,2,5};
        int[] nums={3,4,4,4,5,6,7};
        AEQ9 obj= new AEQ9();
        System.out.println(Arrays.toString(obj.BruteForce(arr,nums)));
        System.out.println(Arrays.toString(obj.Optimal(arr,nums)));
    }
    public int[] Optimal(int[] arr1, int[] arr2) {

        int[] temp = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {

            if (arr1[i] < arr2[j]) {
                if (k == 0 || temp[k - 1] != arr1[i]) {
                    temp[k++] = arr1[i];
                }
                i++;
            }
            else {
                if (arr2[j] < arr1[i]) {
                    if (k == 0 || temp[k - 1] != arr2[j]) {
                        temp[k++] = arr2[j];
                    }
                }
                else {
                    if (k == 0 || temp[k - 1] != arr1[i]) {
                        temp[k++] = arr1[i];
                    }
                    i++;
                }
                j++;
            }
        }

        while (i < arr1.length) {
            if (k == 0 || temp[k - 1] != arr1[i]) {
                temp[k++] = arr1[i];
            }
            i++;
        }

        while (j < arr2.length) {
            if (k == 0 || temp[k - 1] != arr2[j]) {
                temp[k++] = arr2[j];
            }
            j++;
        }

        return Arrays.copyOf(temp, k);

        // TC -> O(N)
        // SC->  O(1)
    }
    public int[] BruteForce(int[]arr1,int[] arr2){
        HashSet<Integer> set= new HashSet<>();
        for (int j : arr1) {
            set.add(j);
        }
        for (int j : arr2) {
            set.add(j);
        }
//        int[] temp=new int[set.size()];
//        int i=0;
//        for(int value:set){
//            temp[i++]=value;
//        }
//
//        return temp;

        // *********************Alternative **********
        return set.stream().mapToInt(Integer::intValue).toArray();

        // TC -> O(n+n)
        // SC->  O(n+n)
    }
}
