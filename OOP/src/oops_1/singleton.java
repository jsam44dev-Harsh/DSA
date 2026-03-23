package oops_1;

public class singleton {
    String name;
    singleton(String naam){
        this.name=naam;
    }
    public static void main(String[] args) {
        singleton obj = new singleton("jangra");
        System.out.println(obj);
        System.out.println();
    }
}
