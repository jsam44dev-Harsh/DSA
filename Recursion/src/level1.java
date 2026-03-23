public class level1 {
    public static void main(String[] args) {
//        funboth(5);
//        System.out.println(factorial(5));
//        System.out.println(sum_of_digit(132));
//        Reverse_number(132);
//        System.out.println(sum);
//        System.out.println(countZero());
    }
    // to count number of zero's in a given digit
    static int countZero(int n) {
        // Base case
        if (n == 0) {
            return 0;
        }
        // Check last digit + recurse on the rest
        return (n % 10 == 0 ? 1 : 0) + countZero(n / 10);
    }
//    ************************************************

//    another method to count number of zero's in a digit
    static int countZero2(int n){
        if(n==0){
            return 1;
        }
        return helper(n);
    }
    static int helper(int n){
        if(n==0)return 0;
        return (n % 10 == 0 ? 1 : 0) + helper(n / 10);
    }
//    ******************************************************
//    dfd
//    static void pallindrom(int n,)


    //***********************************************
    static int sum=0;
   //Print the reverse of a number
   static void Reverse_number(int n){
        if(n<=0){
            return ;
        }
        sum=(sum*10)+n%10;
        Reverse_number(n/10);
   }
//   ****************************************************


   // Print the sum_of_digit (example there is a number 1342 then print 2431)
    static int sum_of_digit(int n){
        if(n<=1){
            return 1;
        }
        return (n%10)+sum_of_digit(n/10);
    }
//    ******************************************************

    //Print factorial of a number n
    static int factorial(int n){
        if(n<=1){
            return 1;
        }
        return n*factorial(n-1);
    }
//    ********************************************************


    // Print a number from 1 to n;
    static void funRev(int n){
        if(n==0){
            return;
        }
        funRev(n-1);
        System.out.println(n);
    }
//    *********************************************


    // Print a number from n to 1;
    static void fun(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        fun(n-1);
    }
//    *******************************************************

    // Print number form n to 1 and then 1 to n;
    static void funboth(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        funboth(n-1);
        System.out.println(n);
    }
}