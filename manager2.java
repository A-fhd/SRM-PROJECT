package srms;

import java.io.*;
import java.util.*;

public class StudentManager {

    private ArrayList<Student> students = new ArrayList<Student>();

    
    public boolean addStudent(Student s) {
        if (s == null)
            return false;

        for (Student st : students) {
            if (st.getID() == s.getID())
                return false; 
        }

        students.add(s);
        return true;
    }

    
    public Student findById(int id) {
        for (Student s : students) {
            if (s.getID() == id)
                return s;
        }
        System.out.println("there is no student in this id");
        return null;
    }

    
    public boolean removeStudentById(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getID() == id) {
                students.remove(i);
                return true;
            }
        }
        System.out.println("there is no student in this id");
        return false;
    }

    
    public boolean updateStudent(int id, String dept, int year, double gpa) {
        Student s = findById(id);
        if (s == null)
            return false;

        s.setDepartment(dept);
        s.setYear(year);
        s.setGpa(gpa);
        return true;
    }

    
    public void displayAllStudents() {
        for (Student s : students) {
            System.out.println(s);
        }
    }

    
    public void saveToFile(String fileName) {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(fileName));
            for (Student s : students) {
                out.println(
                        s.getID() + "," +
                        s.getName() + "," +
                        s.getAge() + "," +
                        s.getDepartment() + "," +
                        s.getYear() + "," +
                        s.getGpa()
                );
            }
            out.close();
        } catch (IOException e) {
            System.out.println("miss while reading the file");
        }
    }

    
    public void loadFromFile(String fileName) {
        students.clear();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String dept = data[3];
                int year = Integer.parseInt(data[4]);
                double gpa = Double.parseDouble(data[5]);

                Student s = new Student(dept, gpa, year, id, age, name);
                students.add(s);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("miss while reading the file");
        }
    }
}
