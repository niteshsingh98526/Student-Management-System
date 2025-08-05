import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    private List<Student> students;
    private Scanner scanner;
    private int nextId;

    public StudentManager(){
        students = new ArrayList<>();
        scanner =new Scanner(System.in);
        nextId = 1;
    }

    public void run(){
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1 :
                    addStudent();
                    break;
                case 2 :
                    viewStudents();
                    break;
                case 3 :
                    updateStudent();
                    break;
                case 4 :
                     deleteStudent();
                     break;
                case 5 :
                    System.out.println("Existing application. ");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
        scanner.close();
    }

    public void displayMenu(){
        System.out.println("\nStudent Crud Operation: ");
        System.out.println("1. Add Student");
        System.out.println("2. View Student");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Exit");


    }

    public void addStudent(){
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine();

        Student newStudent = new Student(nextId++, name, marks);
        students.add(newStudent);
        System.out.println("Student added: "+ newStudent);
    }

    public void viewStudents(){
        if (students.isEmpty()){
            System.out.println("No Student to display. ");
            return;
        }

        System.out.println("\n--- All Students ---");
        for (Student student : students){
            System.out.println(student);
        }
    }

    public void updateStudent(){
        System.out.println("Enter student ID to update: ");
        int idToUpdate = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;
        for (Student student : students){
            if (student.getId() == idToUpdate){
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                if (!newName.isEmpty()){
                    student.setName(newName);
                }

                System.out.print("Enter new marks: ");
                double newMarks = scanner.nextDouble();
                scanner.nextLine();
                if (newMarks != 0){
                    student.setMarks(newMarks);
                }
                System.out.println("Student update successfully: "+ student);
                found = true;
                break;
            }
        }
        if (!found){
            System.out.println("Student with id " + idToUpdate + " not found. ");
        }
    }

    public void deleteStudent() {
        System.out.println("Enter student ID to delete: ");
        int idToDelete = scanner.nextInt();
        scanner.nextLine();

        boolean removed = students.removeIf(s -> s.getId() == idToDelete);
        if (removed) {
            System.out.println("Student with id " + idToDelete + " delete successfully.");
        } else {
            System.out.println("Student with id " + idToDelete + " not found.");
        }
    }

//    public static void main(String[] args) {
//        StudentManager sm = new StudentManager();
//        sm.run();
//    }
}


