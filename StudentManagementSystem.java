import java.util.Scanner;
import java.util.ArrayList;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }
    public int getRollNumber() {
        return rollNumber;
    }
    public String getGrade() {
        return grade;
    }
    public void setName (String name) {
        this.name = name;
    }
    public void setGrade (String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

class main {
    private ArrayList <Student> students = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void addStudent() {
        System.out.print("\nEnter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter roll number: ");
        int rollNumber = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter grade: ");
        String grade = sc.nextLine();

        students.add(new Student(name, rollNumber, grade));
        System.out.println("\nStudent added successfully.\n");
    }

    public void removeStudent() {
        System.out.print("\nEnter roll number of student to remove: ");
        int rollNumber = sc.nextInt();
        sc.nextLine();

        Student student = findStudent(rollNumber);
        if (student != null) {
            students.remove(student);
            System.out.println("\nStudent removed successfully.\n");
        } else {
            System.out.println("Student not found.\n");
        }
    }

    public void searchStudent() {
        System.out.print("\nEnter roll number to search: ");
        int rollNumber = sc.nextInt();
        sc.nextLine();

        Student student = findStudent(rollNumber);
        if (student != null) {
            System.out.println("\nStudent found: " + student + "\n");
        } else {
            System.out.println("\nStudent not found.\n");
        }
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("\nNo students found.\n");
        } else {
            System.out.println("\nAll Students: ");
            for (Student student : students) {
                System.out.println(student);
            }
            System.out.println();
        }
    }

    private Student findStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        main sms = new main();
        Scanner sc = new Scanner (System.in);
        int choice;

        do {
            System.out.println("\n*** Student Management System ***");
            System.out.println("\t1. Add Student\n\t2. Remove Student\n\t3. Search Student\n\t4. Display All Students\n\t5. Exit");
            System.out.print("\nChoose an option (1-5): ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    sms.addStudent();
                    break;
                case 2:
                    sms.removeStudent();
                    break;
                case 3:
                    sms.searchStudent();
                    break;
                case 4:
                    sms.displayAllStudents();
                    break;
                case 5:
                    System.out.println("\nExiting system. Goodbye!\n");
                    break;
                default:
                    System.out.println("\nInvalid choice. Please choose a valid option.\n");
            }
        } while (choice != 5);

        sc.close();
    }
}