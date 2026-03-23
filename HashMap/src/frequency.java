import java.util.HashMap;

public class frequency {
    public static void main(String[] args) {
        String t="tree";
        int []arr={10,20,33,34,54,65,98};
        int w=33;
        System.out.println(binarysearch(arr,w,0,arr.length-1));
        System.out.println(fib(7));
    }
    static int fib(int n){
        if(n<2){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }
    public static int binarysearch(int arr[],int target, int s,int e){
        if(s>e){
            return -1;
        }
        int m= s+(e-s)/2;
        if(arr[m]==target){
            return m;
        }
        if (target<arr[m]){
            return binarysearch(arr,target,s,m-1);
        }
        return binarysearch(arr,target,m+1,e);
    }
}
