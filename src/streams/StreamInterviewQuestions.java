package streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamInterviewQuestions {
    public static void main(String[] args) {
        String input = "ilovejavatechie";
        // count occ of each char in string and print
        //linked hashmap to preserve insertion order
        Map<String,Long> stringLongMap = Stream.of(input.split("")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println(stringLongMap);
        Map<String,Long> stringLongMap2 = Stream.of(input.split("")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));

        //get duplicate element
        System.out.println(
                stringLongMap.entrySet().stream().filter((e) -> e.getValue()>1).map(Map.Entry::getKey).collect(Collectors.toList()));

        //first non repeat element of a string

        System.out.println(
                stringLongMap.entrySet().stream().filter((e) -> e.getValue()==1).map(Map.Entry::getKey).findFirst().get()
        );

        // second highest number
        int[] nums = {1,2,4,9,21,11,123,321,1211,211,111,221};
        System.out.println(
                Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get());

        //find longest string in an array
        String[] strings = {"java","techie","springboot","djk"};
        System.out.println(
                Arrays.stream(strings).max(Comparator.comparingInt(String::length)).get());

        //find elements that start with 1
        List<Integer> result = Arrays.stream(nums).boxed().filter(StreamInterviewQuestions::isStartWithOne).toList();
        System.out.println("result elements"+result);
        //or
        List<String> result2= Arrays.stream(nums).boxed().map(s->s+"").filter(s->s.startsWith("1")).toList();
        System.out.println("result elements"+result2);
    }

    private static boolean isStartWithOne(Integer num) {
        if(num == 1) return true;
        while(num>0){
            if(num/10 == 1) return true;
            num /=10;
        }
        return false;
    }
}
