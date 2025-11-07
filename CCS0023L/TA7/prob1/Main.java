package TA7.prob1;

public class Main {
    public static void main(String[] args) {

        Student student1 = new Student("John", 16, "M", 1.75);
        Student student2 = new Student("Rachel", 15, "F", 2.50);

        Teacher teacher = new Teacher("Mr. Smith", 35, "M", 50000);

        System.out.println("Student 1:");
        student1.displayInfo();
        System.out.println();

        System.out.println("Student 2:");
        student2.displayInfo();
        System.out.println();

        System.out.println("Teacher:");
        teacher.displayInfo();
    }
}


class Person {
    private String name;
    private int age;
    private String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
    }
}


class Student extends Person {
    private double grade;

    public Student(String name, int age, String gender, double grade) {
        super(name, age, gender); 
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }
    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Grade: " + grade);
    }
}


class Teacher extends Person {
    private double salary;

    public Teacher(String name, int age, String gender, double salary) {
        super(name, age, gender); 
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Salary: " + salary);
    }
}
