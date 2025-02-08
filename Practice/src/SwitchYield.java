public class SwitchYield {
    public static void main(String[] args) {
        int number = 2;
        String result = switch (number) {
            case 1 -> "One";
            case 2 -> {
                yield "Two"; // Using yield instead of return
            }
            default -> "Other";
        };
        System.out.println(result);
    }
}
