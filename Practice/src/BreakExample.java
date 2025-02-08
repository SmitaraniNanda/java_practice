public class BreakExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                System.out.println("Breaking loop at i = " + i);
                break;
            }
            System.out.println("Iteration: " + i);
        }
    }
}