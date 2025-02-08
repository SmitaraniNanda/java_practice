import java.util.List;
import java.util.stream.IntStream;

public class ForEachLambda {
    public static void main(String[] args) {
    	IntStream.range(1, 5).forEach(i-> System.out.println(i));
       
    }
}
