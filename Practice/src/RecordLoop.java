import java.util.List;

record Person(String name, int age) {}

public class RecordLoop {
    public static void main(String[] args) {
        var people = List.of(new Person("Alice", 25), new Person("Bob", 30));
        for (var person : people) {
            System.out.println(person.name() + " is " + person.age() + " years old.");
        }
    }
}
