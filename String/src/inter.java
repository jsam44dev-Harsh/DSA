import java.util.*;
public class inter {
    public static void main(String[] args) {
        String a="hello ji keso ho sara";
        String b=new String("kunal");
//        System.out.println(a.substring(2,5));
//        System.out.println(a.equals(b));
//        System.out.println(a.trim());


//        ******************Code  to Reverse a String********************
        String s="Geek";
        String x="";
        for (int i = s.length()-1; i >=0 ; i--) {
            char ch= s.charAt(i);
            String str=""+ch;
            x=x.concat(str);
        }
        System.out.println(x);

    }
}
