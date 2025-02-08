import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamLoop {
    public static void main(String[] args) {
    	//for (int i = 1; i <= 5; i++) {
    	List<Integer> intList = Arrays.asList(new Integer[] {1,2});
    	
    	
    	for (Integer integer : intList) {
			System.out.println(integer);
		}
    	IntStream.range(0, intList.size()).forEach(idx -> intList.get(idx));
    	
    	
    	
    	//IntStream.range(1, 5).forEach(i-> System.out.println(i));
       /* Stream.iterate(1, n -> n <= 5, n -> n + 1)
              .forEach(System.out::println);*/
    }
}
