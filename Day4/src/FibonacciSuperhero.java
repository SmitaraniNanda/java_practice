import java.util.Scanner;

public class FibonacciSuperhero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number N: ");
        int n = scanner.nextInt();
        scanner.close();
        
        int a = 0, b = 1;
        
        System.out.println("Fibonacci sequence up to " + n + ":");
        for (int i = 0; a <= n; i++) {
            if (a % 3 == 0 && a % 5 == 0) {
                System.out.println(a + " - I am spiderman and ironman");
            } else if (a % 3 == 0) {
                System.out.println(a + " - I am spiderman");
            } else if (a % 5 == 0) {
                System.out.println(a + " - I am ironman");
            } else {
                System.out.println(a + " - I am zero");
            }
            
            int next = a + b;
            a = b;
            b = next;
        }
    }
}
