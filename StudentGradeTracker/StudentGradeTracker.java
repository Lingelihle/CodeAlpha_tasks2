import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker { //ArrayList to store studentNames and grades
    private final ArrayList<String> studentNames; 
    private final ArrayList<Double> studentGrades;

    public StudentGradeTracker() {
        studentNames = new ArrayList<>();
        studentGrades = new ArrayList<>();
    }

    // Method to add a student and their grade
    public void addStudentGrade(String name, double grade) {
        studentNames.add(name);
        studentGrades.add(grade); //Adds a //student and their grade to the lists.
    }

    // Method to compute the average grade
    public double computeAverageGrade() { // Computes and returns the average grade.
        double sum = 0;
        for (double grade : studentGrades) {
            sum += grade;
        }
        return sum / studentGrades.size();
    }

  
    public double findHighestGrade() { //Finds and returns the highest grade.
        double highest = Double.MIN_VALUE;
        for (double grade : studentGrades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

   
    public double findLowestGrade() { // Finds and returns the lowest grade.
        double lowest = Double.MAX_VALUE;
        for (double grade : studentGrades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }

   
    public void displayStudentGrades() { //Displays all students and their grades.
        System.out.println("Student Grades:");
        for (int i = 0; i < studentNames.size(); i++) {
            System.out.println(studentNames.get(i) + ": " + studentGrades.get(i));
        }
    }

    public static void main(String[] args) { //for the teacher to enter grades, compute average, highest, and lowest grades, display all grades, and exit the program.
        StudentGradeTracker gradeTracker = new StudentGradeTracker();
        try (Scanner scanner = new Scanner(System.in)) {
            boolean done = false;
            
            while (!done) {
                System.out.println("1. Add student grade");
                System.out.println("2. Compute average grade");
                System.out.println("3. Find highest grade");
                System.out.println("4. Find lowest grade");
                System.out.println("5. Display all student grades");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                
                switch (choice) {
                    case 1:
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter student grade: ");
                        double grade = scanner.nextDouble();
                        gradeTracker.addStudentGrade(name, grade);
                        break;
                    case 2:
                        double average = gradeTracker.computeAverageGrade();
                        System.out.println("Average grade: " + average);
                        break;
                    case 3:
                        double highest = gradeTracker.findHighestGrade();
                        System.out.println("Highest grade: " + highest);
                        break;
                    case 4:
                        double lowest = gradeTracker.findLowestGrade();
                        System.out.println("Lowest grade: " + lowest);
                        break;
                    case 5:
                        gradeTracker.displayStudentGrades();
                        break;
                    case 6:
                        done = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}  