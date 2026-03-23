package oops_1;

public class overloading {
    // Constructor Overloading
    int rno;
    String name;
    float marks;
    overloading(){
        this.rno=7;
        this.name="Iron Man";
        this.marks=89;
    }
    // constructor oops_1.overloading
    overloading(overloading other){
        this.name=other.name;
        this.rno=other.rno;
        this.marks=other.marks;
    }
    void  Greeting (){
        System.out.println("My name is "+this.name);
    }

    public static void main(String[] args) {
        overloading kunal= new overloading();
        overloading random = new overloading(kunal);
        System.out.println(random.marks);
        System.out.println(random.rno);
        System.out.println(random.name);
        kunal.Greeting();


    }

}
