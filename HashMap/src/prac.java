import java.util.*;

public class prac {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0,3,4,1,2,1,1};
        System.out.println(findIntTarget(0,arr));
        String s="aaaa";
        String target="a";
        System.out.println(findStringTarget(s,target));
        System.out.println(findCountArrayElements(arr));
    }
    public static List<List<Integer>> findCountArrayElements(int []arr){
        Map<Integer,Integer> map= new HashMap<>();
        for(int a:arr){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        List<List<Integer>> list=new ArrayList<>();
        for(int key:map.keySet()){
            list.add(Arrays.asList(key,map.get(key)));
        }
        return list;
    }
    public static int findStringTarget(String s,String target){
        int[] hash= new int[26];
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)-'a']+=1;
        }
        return hash[target.charAt(0)-'a'];

    }
    public static int findIntTarget(int target, int[]arr){
        int n=0;
        for(int i=0;i<arr.length;i++){
            n=Math.max(n,arr[i]);
        }
        int[]hash= new int[n+1];
        for(int i:arr){
            hash[i]+=1;
        }
        return hash[target];
    }



}
