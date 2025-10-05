class Employee{
    String name;
    float salary;
    Employee(){
        name="Anonymous";
        salary=0;
    }
    void displayDetails(){
        System.out.println("Employee Name: "+name);
        System.out.println("Salary: "+salary);
    }
}
class Manager extends Employee{
    int teamSize;
    Manager(String name, float salary, int teamSize){
        this.name=name;
        this.salary=salary;
        this.teamSize=teamSize;
    }
    @Override
    void displayDetails(){
        System.out.println("Manager Name: "+name);
        System.out.println("Salary: "+salary);
        System.out.println("Team Size: "+teamSize);
    }
}
class Developer extends Employee{
    String programmingLanguage;
    Developer(String name, float salary, String programmingLanguage){
        this.name=name;
        this.salary=salary;
        this.programmingLanguage=programmingLanguage;
    }
    @Override
    void displayDetails(){
        System.out.println("Developer Name: "+name);
        System.out.println("Salary: "+salary);
        System.out.println("Programming Language: "+programmingLanguage);
    }
}
class Intern extends Employee{
    int durationMonths;
    Intern(String name, float salary, int durationMonths){
        this.name=name;
        this.salary=salary;
        this.durationMonths=durationMonths;
    }
    @Override
    void displayDetails(){
        System.out.println("Intern Name: "+name);
        System.out.println("Salary: "+salary);
        System.out.println("Internship Duration (months): "+durationMonths);
    }
}
public class P65 {
    public static void main(String args[]){
        Employee[] employees=new Employee[4];
        employees[0]=new Employee(); // Default employee
        employees[1]=new Manager("Alice", 100000, 5);
        employees[2]=new Developer("Bob", 80000, "Java");
        employees[3]=new Intern("Charlie", 30000, 6);
        for(Employee e:employees){
            e.displayDetails();
            System.out.println("-----");
        }
    }

}