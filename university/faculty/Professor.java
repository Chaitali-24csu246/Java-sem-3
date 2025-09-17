package university.faculty;

public class Professor {
    protected String name;   // accessible in subclasses and same package
    private double salary;   // only accessible within Professor
    public Professor(String name) {//accessible even outside
        this.name = name;
    }
    public void displayInfo() {
        System.out.println("Professor Name: " + name);
    }
    
    public void setSalary(double s) {
        salary = s;
    }
    
    public double getSalary() {
        return salary;
    }
}

    