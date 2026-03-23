public class practice {
    public static void main(String[] args) {
        System.out.println(countZero(30204));
    }
    static int count=0;
    static int countZero(int n){
        if(n<=0){
            return 0;
        }
        if(n%10==0){
            count++;
        }
        countZero(n/10);
        return count;
    }

}
