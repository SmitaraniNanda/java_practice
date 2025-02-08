import java.util.Scanner;

public class GradeProgram {
	 /**
     * This is the main method that takes user input, evaluates the score, 
     * and prints the corresponding grade.
     * 
     * @param args Command-line arguments 
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the score: ");
        int score = scanner.nextInt();
        scanner.close();
        
        if (score < 0 || score > 100) {
            System.out.println("Invalid score");
        } else {
            switch (score / 10) {
                case 10:
                case 9:
                    System.out.println("Grade A");
                    break;
                case 8:
                    System.out.println("Grade B");
                    break;
                case 7:
                    System.out.println("Grade C");
                    break;
                case 6:
                    System.out.println("Grade D");
                    break;
                default:
                    System.out.println("Grade F");
            }
        }
    }
}
