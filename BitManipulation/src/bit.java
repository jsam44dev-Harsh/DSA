public class bit {
    public static void main(String[] args) {
        int n=23;
        int[] nums={1,2,3,3,5,2,1};
        System.out.println(evenOrOdd(n));
        System.out.println(FindUnique(nums));
        System.out.println(Findpositionbit(n,2));
    }
    public static boolean evenOrOdd(int n){
        return (n&1)==1;
        // return true if number is odd and vice versa
    }
    public static int FindUnique(int []arr){
        int unique=0;
        for(int n:arr){
            unique^=n;
            // unique=unique^n;

        }
        return unique;
    }
    public static int Findpositionbit(int n,int bit){
        int mask=1<<bit;
        return n&mask;
    }
}
