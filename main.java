import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        int choice;

        do {
            System.out.println("\nprogram list of student System");
            System.out.println("1 - add a student");
            System.out.println("2 - search a student");
            System.out.println("3 - update student information");
            System.out.println("4 - delete student");
            System.out.println("5 - display all student");
            System.out.println("6 - exit");
            System.out.print("choose: ");

            choice = in.nextInt();
            in.nextLine(); 

            switch (choice) {

                case 1: { 
                    System.out.print("Enter Name: ");
                    String name = in.nextLine();

                    System.out.print("Enter ID: ");
                    int id = readId(in);

                    System.out.print("Enter Age: ");
                    int age = in.nextInt();
                    in.nextLine();

                    System.out.print("Enter Department: ");
                    String dept = in.nextLine();

                    System.out.print("Enter Year: ");
                    int year = in.nextInt();
                    in.nextLine();

                    System.out.print("Enter GPA: ");
                    double gpa = in.nextDouble();
                    in.nextLine();

                    student s = new student(dept, gpa, year, id, age, name);

                    if (manager.addStudent(s))
                        System.out.println("Student added successfully.");
                    else
                        System.out.println("Student ID already exists.");

                    break;
                }

                case 2: { 
                    System.out.print("Enter ID: ");
                    int id = readId(in);

                    student found = manager.findById(id);
                    if (found != null)
                        System.out.println(found);
                    else
                        System.out.println("Student not found.");

                    break;
                }

                case 3: {  
                    System.out.print("Enter ID: ");
                    int id = readId(in);

                    System.out.print("New Department: ");
                    String dept = in.nextLine();

                    System.out.print("New Year: ");
                    int year = in.nextInt();
                    in.nextLine();

                    System.out.print("New GPA: ");
                    double gpa = in.nextDouble();
                    in.nextLine();

                    if (manager.updateStudent(id, dept, year, gpa))
                        System.out.println("Student updated.");
                    else
                        System.out.println("Student not found.");

                    break;
                }

                case 4: { 
                    System.out.print("Enter ID: ");
                    int id = readId(in);

                    if (manager.removeStudentById(id))
                        System.out.println("Student deleted.");
                    else
                        System.out.println("Student not found.");

                    break;
                }

                case 5: { 
                    manager.displayAllStudents();
                    break;
                }

                case 6: {
                    System.out.println("see u again");
                    in.close();
                    return;   
                }
                

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        in.close();
    }

    private static int readId(Scanner in) {
        while (true) {
            try {
                String input = in.nextLine();
                return Integer.parseInt(input);
            } catch (Exception e) {
                System.out.print("Invalid ID, enter numbers only: ");
            }
        }
    }
}
