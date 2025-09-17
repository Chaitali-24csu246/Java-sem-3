package university;
import university.faculty.*;
import university.students.*;
public class MainApp {
	public static void main(String args[]){
        /*
         * Create a MainApp class in a different package (e.g., university.app) to:

Create a Professor and a Student object.

Try to directly access salary (should fail).

Correctly access/update salary through setSalary().

Try to access Student.name from outside its package (should fail due to default access).
         */
        Professor prof = new Professor( "Dr. abc");
        Student s = new Student("Student name");
        //prof.salary = 50000; // This line would cause a compile-time error
        prof.setSalary(50000);
        System.out.println("Professor Salary: " + prof.getSalary());
        // System.out.println("Student Name: " + s.name); // This line would cause a compile-time error
        prof.displayInfo();
        s.displayInfo();    
    }
}
