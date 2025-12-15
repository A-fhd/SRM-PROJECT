
import java.io.*;
import java.util.*;

public class StudentManager {

    private ArrayList<student> students = new ArrayList<student>();

    
    public boolean addStudent(student s) {
        if (s == null)
            return false;

        for (student st : students) {
            if (st.getID() == s.getID())
                return false; 
        }

        students.add(s);
        return true;
    }

    
    public student findById(int id) {
        for (student s : students) {
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
        student s = findById(id);
        if (s == null)
            return false;

        s.setDepartment(dept);
        s.setYear(year);
        s.setGpa(gpa);
        return true;
    }

    
    public void displayAllStudents() {
        for (student s : students) {
            System.out.println(s);
        }
        }
    }   
