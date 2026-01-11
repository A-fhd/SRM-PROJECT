package srms;
public class Student extends Person {
    private String department;
    private int year;
    private double gpa;

    public Student(String department, double gpa, int year, int id, int age, String name) {
        super(id, age, name);
        this.department = department;
        this.gpa = gpa;
        this.year = year;
    }
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

       @Override
public String toString() {
    return "ID: " + getID() +
           ", Name: " + getName() +
           " , Age: "+getAge()+
           ", Department: " + department +
           ", Year: " + year +
           ", GPA: " + gpa;
}
}

