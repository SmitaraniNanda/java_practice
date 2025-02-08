public class SwitchExpression {
    public static void main(String[] args) {
        String day = "Monday";
        String message = switch (day) {
            case "Monday" -> "Start of the week!";
            case "Friday" -> "Weekend is near!";
            default -> "Regular day";
        };
        System.out.println(message);
    }
}
