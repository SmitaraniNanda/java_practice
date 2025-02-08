import java.util.List;

public class VarInLoop {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie");
        for (var name : names) {
            System.out.println(name);
        }
    }
    
   
}
