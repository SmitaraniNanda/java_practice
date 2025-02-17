public class ThrowExample {

    /**
     * Checks if a person is eligible to vote.
     * If the age is less than 18, throws an IllegalArgumentException.
     * @param age The age of the person.
     * @throws IllegalArgumentException if age is less than 18.
     */
    public static void checkEligibility(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("You are not eligible to vote");
        } else {
            System.out.println("You can vote!");
        }
    }

    public static void main(String[] args) {
        int age = 20; 
        
        try {
            checkEligibility(age); // Pass the  age
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
