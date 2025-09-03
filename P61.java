//For simplicity, keep all attributes string
//Keeping all values package private
//So no getters or protected reqd. for same file
// Simple inheritance illustration program without using super
class Person {
    String name, email;
    //iF WE ARE TAKING VALUES DIRECTLY FROM SUBCLASS DO NOT DECLARE CONSTRUCTOR HERE, UNLESS DEFAULT
    Person(){
        //default constructor
        name="abc";
        email="XYZ@gmail.com";
    }
}

class Faculty extends Person {
    String employeeID, specialization;
    Faculty(String name, String email, String employeeID, String specialization) {
        this.name = name;
        this.email = email;
        this.employeeID = employeeID;
        this.specialization = specialization;
    }
}

class Student extends Person {
    String rollno, course;
    Student(String name, String email, String rollno, String course) {
        this.name = name;
        this.email = email;
        this.rollno = rollno;
        this.course = course;
    }
}

public class P61 {
    public static void main(String args[]) {
        Faculty f = new Faculty("Dr. Rao", "rao@uni.edu", "F123", "Physics");
        Student s = new Student("Amit", "amit@uni.edu", "S456", "Computer Science");
        Person p = new Person();//default values here
        System.out.println("Faculty: " + f.name + ", " + f.email + ", " + f.employeeID + ", " + f.specialization);
        System.out.println("Student: " + s.name + ", " + s.email + ", " + s.rollno + ", " + s.course);
        System.out.println("Person: " + p.name + ", " + p.email);
    }
}