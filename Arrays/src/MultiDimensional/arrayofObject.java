package MultiDimensional;
// *************************************Array of Object********************************

class Student{
    int rollNo;
    String name;
    int marks;
}

public class arrayofObject {
    public static void main(String[] args) {
        Student s1= new Student();
        s1.name="kiran";
        s1.rollNo=1;
        s1.marks=88;

        Student s2= new Student();
        s2.name="Harsh";
        s2.rollNo=2;
        s2.marks=67;

        Student s3= new Student();
        s3.name="Navin";
        s3.rollNo=3;
        s3.marks=72;
        Student[] students= new Student[3];
        students[0]=s1;
        students[1]=s2;
        students[2]=s3;

        for (Student student : students) {
            System.out.println(student.name + " : " + student.marks);
        }
        for (int i = 0; i < students.length ; i++) {
            System.out.println(students[i].name+" : "+students[i].marks);
        }

//        int []nums=new int[6];
//        nums[0]=8;
//        nums[1]=9;
//        nums[2]=4;
//        nums[3]=2;
//
//        for (int i = 0; i < nums.length ; i++) {
//            System.out.println(nums[i]);
//        }
    }

}
