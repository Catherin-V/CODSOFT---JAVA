import java.util.Scanner;

public class StudentGradeCalculator
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);

        int subjects = 0;
        int total = 0;

        System.out.println("\n********** STUDENT GRADE CALCULATOR **********");

        System.out.print("\nEnter how many subjects: ");
        subjects = scanner.nextInt();

        int marks[] = new int[subjects];

        System.out.println("\nEnter the marks for " + subjects + " Subjects (out of 100):");

        for (int i=0; i<subjects; i++)
        {
            System.out.print("\nEnter the mark of Subject " + (i+1) + " : ");
            marks[i] = scanner.nextInt();
            total += marks[i];
        }

        boolean failmarks = false;

        for (int i=0; i<subjects; i++)
        {
            if (marks[i] < 50)
            {
                failmarks = true;
                break;
            }
        }

        float percentage = total / subjects;
        char grade = 'A';

        if (percentage >= 90)
            grade = 'A';
        else if (percentage >= 80)
            grade = 'B';
        else if (percentage >= 70)
            grade = 'C';
        else if (percentage >= 60)
            grade = 'D';
        else if (percentage >= 50)
            grade = 'E';

        if (percentage < 50 || failmarks == true)
            grade = 'F';

        System.out.println("\n****** RESULTS ******");
        System.out.println("\nTotal       : " + total);
        System.out.println("Percentage  : " +percentage);
        System.out.println("Grade       : " + grade + "\n");

        scanner.close();
    }
} 

