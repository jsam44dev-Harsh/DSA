import java.util.ArrayList;

//*************************************   Array Questions   ***************************************
public class level2 {
    public static void main(String[] args) {
        int []num={5,6,7,8,9,1,2,3,4};
//        System.out.println(isSorted(num,0));
//        System.out.println(linearSearch(num,10,0));
//        System.out.println(findAllIndex(num,8,0,new ArrayList<>()));
//        System.out.println(findAllIndex2(num,8,0));
        System.out.println(search(num,8,0,num.length,new ArrayList<>()));
    }


//    ****************************************************************************************************

//    Rotated Binary Search
    public static ArrayList<Integer> search(int[]arr,int target,int start,int end,ArrayList<Integer> list){
        if(start>end){
            return list;
        }
        int mid=start+(end-start)/2;
        if(arr[mid]==target){
            list.add(mid);
        }
        if(arr[start]<=arr[mid]){
            if(target>=arr[start]&&target<=arr[mid]){
                return search(arr,target,start,mid-1,list);
            }
            else {
                return search(arr,target,mid+1,end,list);
            }
        }
        if(target>=arr[mid]&&target<=arr[end]){
            return search(arr,target,mid+1,end,list);
        }
        return search(arr,target,start,mid-1,list);
    }

//    *********************************************************************************************

//    Return the list without passing the argument and Linear Search
    public static ArrayList<Integer> findAllIndex2(int []arr,int target,int index){
        ArrayList<Integer> list= new ArrayList<>();
        if(index==arr.length){
            return list;
        }
        if(target==arr[index]){
            list.add(index);
        }
        ArrayList<Integer> ansFromBelowCalls = findAllIndex2(arr,target,index+1);
        list.addAll(ansFromBelowCalls);
        return list;
    }

//    ************************************************************************************************

//    Return ArrayList and Linear Search
    public static ArrayList<Integer> findAllIndex(int []arr,int target,int index,ArrayList<Integer> list){
        if(index==arr.length){
            return list;
        }
        if(target==arr[index]){
            list.add(index);
        }
        return findAllIndex(arr,target,index+1,list);
    }

//    ********************************************************************************************

//    Linear Search
    public static boolean linearSearch(int []arr,int target,int index){
        if(arr.length==index){
            return false;
        }
        return arr[index]==target || linearSearch(arr,target,index+1);
    }

//    **********************************************************************************************

//    function to check whether array is sorted or not
    public static boolean isSorted(int []arr, int index){
        if(index==arr.length-1){
            return true;
        }
        return arr[index]<arr[index+1] && isSorted(arr,index+1);
    }
}
