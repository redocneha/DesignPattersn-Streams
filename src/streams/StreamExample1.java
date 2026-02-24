package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample1{
    //Stream object creation ways
    public static void main(String[] args) {
        // using collection
        List<String> values = List.of("Apple","Banana","Carrot");
        Stream<String> stream1 = values.stream();
        // Using Arrays of values
        Stream<String> stream2 = Arrays.stream(new String[]{"one", "two"});
        // Stream method
        Stream<String> stream3 = Stream.of("one","two");
        // generate()
        Stream<String> stream4 = Stream.generate(()-> "One");
        //builder (Builder DP)
        Stream.Builder<String> streamBuilder = Stream.builder();
        Stream<String> stream5 = streamBuilder.add("One").add("Two").build();
        //Empty stream
        Stream<String> stream6 = Stream.empty();
    }
}

