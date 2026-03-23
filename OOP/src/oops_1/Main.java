package oops_1;

public class Main {
//    static void swap(int x,int y){
//
//    }

    public static void main(String[] args) {
        int x=5;
        int y=10;
//        swap(x,y);
        int temp=x;
        x=y;
        y=temp;
        System.out.println(x+" "+y);
    }
}
