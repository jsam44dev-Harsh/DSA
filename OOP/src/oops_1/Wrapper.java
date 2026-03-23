package oops_1;

public class Wrapper {

    public static void main(String[] args) {
        int a=10;
        byte b=1;
        float c=10.22f;

//      efficient way to create wrapper class
        Integer intobj= Integer.valueOf(a);
        Byte byteobj= Byte.valueOf(b);
        Float floatobj= Float.valueOf(c);
        // simpler way to creaet
        Integer inta=a;
        Byte intb=b;
        Float intc=c;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

    }
}
