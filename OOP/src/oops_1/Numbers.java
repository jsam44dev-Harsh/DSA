package oops_1;

// Introduction to oops
public class Numbers {
    // Properties
    private int a;
    private int b;
//    Methods
    public void sum(){
        System.out.println(a+b);
    }
    public void diff(){
        System.out.println(a-b);
    }
    public static void main(String[] args) {
        // Creating a Instance of Class 
        // Objects
        Numbers obj= new Numbers();
        // Assigning values to Properties
        obj.a=5;
        obj.b=2;
        // Using Method's
        obj.sum();

        obj.diff();

        // object creation of inner class name Student
        Student s1= new Student();
        System.out.println(s1.id);
        System.out.println(s1.name);

    }
    static class Student{        // Cannot use non-static inside static
        int id;
        String name;
    }
}
