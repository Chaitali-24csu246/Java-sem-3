//seedpracticle05
//in java every class created by default is inherited by object class 
//all classes inherit object class, either use extend or override, though extend is not mandatory as it is default

class Book {
    String isbn, title, author;
    //constructor parameterized
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;//this is used because it distinguishes between class attributes and parameters
        this.title = title;
        this.author = author;
    }
    //setter
    //setter is different from constructor because it can be called multiple times to 
    //change the value of an attribute
    public void setIsbn(String i) {
        isbn = i;//if we dont use this we use this method
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    //getter
    //getter returns values
    public String getIsbn() {//this is standard naming convention
        return isbn;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    //toString
    //to string is from object class so use override, with this we can directly print object to get values from our 
    //constructor, otherwise print(objname) will return a memory address
    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';//concatenate as string and return
                //check later toString with non string values
    }
}

class Member {
    String memberID, name;
    //constructor 
    Member(String m, String n){
        memberID = m;
        name = n;
    }
    //getter
    public String getMemberID(){
        return memberID;
    }
    public String getName(){
        return name;
    }
    //setter
    public void setMemberID(String memberID){
        this.memberID= memberID;
    }
    public void setName(String name){
        this.name= name;
    }
    //tostring
    @Override
    public String toString(){
        return "Member : \n Member ID : " + memberID + "\n Name : " + name;
    }
}

class Loan{
    Book book;
    Member member;
    int daysBorrowed,allowedDays,perDayFine;
    public String seed="SEEDPRACTICLE05";
    Loan(Book book, Member member, int daysBorrowed){//instead of using multiple values make class data type
        this.book = book;
        this.member = member;
        this.daysBorrowed = daysBorrowed;
    }
    //seed rule
    void seedRule(String seed){
        int sum = 0;
        for (char c : seed.toCharArray()) {//tochararray makes string array of characters
            if (Character.isDigit(c)) {//What is Character ? Character is a wrapper class in Java that
                // provides utility methods for working with char values.
                sum += Character.getNumericValue(c);//char to int
            }
        }
        allowedDays = 10 + (sum % 3);//condition met
        if (seed.length() > 0) {
            perDayFine = 5 + Character.getNumericValue(seed.charAt(seed.length() - 1));
        } else {
            perDayFine = 5;
        }
    }
    //method
    int computeFine(int allowedDays, int perDayFine) {
        if (daysBorrowed > allowedDays) {
            int overdueDays = daysBorrowed - allowedDays;
            return overdueDays * perDayFine;
        }
        return 0;
    }
    //tostring
    @Override
    public String toString() {
        return "Loan{" +
                "book=" + book +
                ", member=" + member +
                ", daysBorrowed=" + daysBorrowed +
                ", allowedDays=" + allowedDays +
                ", perDayFine=" + perDayFine +
                '}';
    }

}

public class MicroLibAssignment {

    public static void main(String[] args) {
        /*Create 5 books, 3 members (use literals).
•
Create an array of 6 loans (some overdue, some not).
•
Print all loans with computed fines and total fine collected. */
        Book[] books = {
                new Book("123", "Book 1", "Author 1"),
                new Book("456", "Book 2", "Author 2"),
                new Book("789", "Book 3", "Author 3"),
                new Book("101", "Book 4", "Author 4"),
                new Book("112", "Book 5", "Author 5")
        };//array of objects instead of several smaller objects

        Member[] members = {
                new Member("M1", "Member 1"),
                new Member("M2", "Member 2"),
                new Member("M3", "Member 3")
        };

        Loan[] loans = new Loan[6];
        loans[0] = new Loan(books[0], members[0], 12);
        loans[1] = new Loan(books[1], members[1], 5);
        loans[2] = new Loan(books[2], members[2], 8);
        loans[3] = new Loan(books[3], members[0], 15);
        loans[4] = new Loan(books[4], members[1], 3);
        loans[5] = new Loan(books[0], members[2], 10);
        int totalFine = 0;
        for (Loan loan : loans) {
            loan.seedRule(loan.seed);//execute method everytime
            int fine = loan.computeFine(loan.allowedDays, loan.perDayFine);
            totalFine += fine;
            System.out.println(loan + ", Fine: " + fine);
        }

        System.out.println("Total Fine Collected: " + totalFine);
    }
}
/*
1) Library Micro-Lending
Scenario: You’re prototyping a tiny library system.
Classes to design
•
Book
o
Fields: isbn (String), title (String), author (String).
o
Constructor(s), getters, toString() -> "ISBN: ..., Title: ..., Author: ...".
•
Member
o
Fields: memberId (String), name (String).
o
Constructor(s), getters, toString().
•
Loan (composition)
o
Fields: book (Book), member (Member), daysBorrowed (int).
o
Method: int computeFine(int allowedDays, int perDayFine) → returns fine for overdue days (0 if within allowedDays).
o
toString() summarizing a loan.
Seed rule
•
Let allowedDays be 10 + (sum of digits in SEED % 3).
•
perDayFine is ₹ 5 + (last digit in SEED if exists, else 0).
Driver requirements
•
Create 5 books, 3 members (use literals).
•
Create an array of 6 loans (some overdue, some not).
•
Print all loans with computed fines and total fine collected.
Constraints
•
Use only plain arrays, no ArrayList.
•
All fields private with getters (no public fields).
    No scanning user input; values are literals.*/
