package university.students;

public class Student {
    public String name;
    public Student(String name){
        this.name = name;
    }
    public void displayInfo() {
        System.out.println("Student Name: " + name);
    }
}
