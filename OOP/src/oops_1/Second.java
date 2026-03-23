package oops_1;

public class Second {
    public static void main(String[] args) {
        Main obj= new Main();
//        System.out.println(obj.x);
        student object=new student();
        student rahul =new student();
        System.out.println(rahul.rno);
//        object.marks=10.24f;
//        object.name="kunal";
//        object.rno=2;
        System.out.println(object.rno);
        System.out.println(object.name);
        System.out.println(object.marks);
    }
}
class student{
    int rno;
    String name;
    float marks;
    student(){
        this.rno=10;
        this.name="kunal";
        this.marks=88.53f;
    }
}