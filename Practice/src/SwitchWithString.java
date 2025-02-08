public class SwitchWithString {
    public static void main(String[] args) {
        String day = "Monday";
        switch (day) {
            case "Monday":
                System.out.println("Start of the week!");
                break;
            case "Friday":
                System.out.println("Weekend is near!");
                break;
            default:
                System.out.println("Regular day");
        }
    }
}
