package streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static streams.StreamOperations.loadEmployees;

public class PracticeStreams {
    public static void main(String[] args) {
        List<String> arrList = List.of("Neha","Apple","Irfan","Pumpokin");
        List<String> sortedList = arrList.stream().sorted(Comparator.comparingInt(String::length).reversed()).toList();
        sortedList.forEach(System.out::println);

        List<String> versionList = List.of("10.0.1","1.0","1.0.1","2.0.3","10.1.2","1.0");
        List<String> sortedVerList = versionList.stream().map(s -> s.split("\\.")).sorted((a,b)->{
            int result = 0;
            for(int i=0;i<3;i++){
                int v1 = i < a.length ? Integer.parseInt(a[i]) : Integer.MIN_VALUE;
                int v2 = i < b.length ? Integer.parseInt(b[i]) : Integer.MIN_VALUE;
                if(v1 != v2)  return Integer.compare(v1, v2);
            }
            return result;
        }).map(x->String.join(".",x)).toList();
        sortedVerList.forEach(System.out::println);

        String str = "1253";
        int res = str.chars().map(Character::getNumericValue).reduce(0, Integer::sum);
        System.out.println("res "+res);

        int fact = IntStream.range(1,6).reduce(1,(a,b)->a*b);
        System.out.println("fact "+fact);

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        int secondLarge = numbers.stream().sorted(Collections.reverseOrder()).skip(1).findFirst().orElse(0);
        System.out.println("secondLarge "+secondLarge);

        Map<Integer,List<String>> groupedList = arrList.stream().collect(Collectors.groupingBy(String::length));
        System.out.println("groupedList "+groupedList);

        Map<Boolean, List<Integer>> partitionList = numbers.stream().collect(Collectors.partitioningBy(n->n%2==0));
        System.out.println("partitionList "+partitionList);

        List<Integer> list1 = List.of(1, 8, 3);
        List<Integer> list2 = List.of(4, 5, 6,8,8,1,3,4,4,5);
        List<Integer> mergedList = Stream.concat(list1.stream(),list2.stream()).sorted().toList();
        System.out.println("mergedList "+mergedList);

        List<Integer> interList = list1.stream().filter(list2::contains).toList();
        System.out.println("interList "+interList);

        Map<Integer,Long> freqList = list2.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()));
        System.out.println("freqList "+freqList);

        String input = "hhlhello";
        Map<Character,Long> freqList2 = input.chars().mapToObj(x -> (char)x).collect(Collectors.groupingBy(c->c,Collectors.counting()));
        System.out.println("freqList2 "+freqList2);
        Character nonRep = input.chars().mapToObj(x -> (char) x).collect(Collectors.groupingBy(c->c,LinkedHashMap::new,Collectors.counting())).entrySet().stream().filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey).findFirst().orElse(null);
        System.out.println("nonRep "+nonRep);

        input = "hello world hello";
        Map<String,Long> freqList3 = Arrays.stream(input.split("\\s")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("freqList3 "+freqList3);
        String mostFreq = freqList3.entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue)).map(Map.Entry::getKey).orElse("");
        System.out.println("mostFreq "+mostFreq);

        //todo

        input = "hello 123 world 45526";
        freqList2 = input.chars().mapToObj(x->(char)x).filter(Character::isDigit).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("freqList2 "+freqList2);
        //todo

        arrList = List.of("Neha","Apple","Irfan","Pumpokin");
        int size = arrList.size();
        List<String> revList = arrList.stream().collect(Collectors.collectingAndThen(Collectors.toList(), (list) -> {
            Collections.reverse(list);
            return list;
        }));
        System.out.println("revList "+revList);

        revList = arrList.stream().map(x-> new StringBuilder(x).reverse().toString()).toList();
        System.out.println("revList "+revList);
        //todo
        String revStr = input.chars().mapToObj(x->String.valueOf((char)x)).reduce((a,b)->b+a).orElse("");
        System.out.println("revStr "+revStr);
        //todo
        List<String> words = List.of("listen", "silent", "enlist", "google", "inlets");
        String target = "silent";
        List<String> anagrams = words.stream().filter(word -> Arrays.equals(word.chars().sorted().toArray(),target.chars().sorted().toArray())).toList();
        System.out.println("anagrams "+anagrams);
        //todo
        words = List.of("madam", "racecar", "apple", "banana", "level");
        String longPalin = words.stream().filter(x -> x.contentEquals(new StringBuilder(x).reverse())).max(Comparator.comparingInt(String::length)).orElse(null);
        System.out.println("longPalin "+longPalin);
        Person person1 = new Person(23,"Neha","HR");
        Person person2 = new Person(25,"Teddy","HR");
        Person person3 = new Person(21,"Irfan","CSE");
        Person person4 = new Person(21,"Irfan2","IT");
        //todo
        List<Person> personList = List.of(person1,person2,person3,person4);
        Map<String,List<String>> depWiseNames = personList.stream().collect(Collectors.groupingBy(Person::department, Collectors.mapping(Person::name, Collectors.toList())));
        System.out.println("depWiseNames "+depWiseNames);

        List<Integer> integers = IntStream.rangeClosed(0,10000).boxed().toList();
        int sum = integers.parallelStream().mapToInt(Integer::intValue).sum();
        System.out.println("sum "+sum);

        List<List<Integer>> listOfLists = List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 9)
        );
        List<Integer> oddList = listOfLists.stream().flatMap(List::stream).filter(x->x%2!=0).toList();
        System.out.println("oddList "+oddList);
        //todo
        IntSummaryStatistics intSummaryStatistics = list1.stream().collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println("intSummaryStatistics "+intSummaryStatistics);
        //todo
        List<Employee> employeeList = loadEmployees();
        Map<String, Double> depWiseAvg = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("depWiseAvg "+depWiseAvg);

        List<String> topPaidEmps = employeeList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).limit(3).map(Employee::getName).toList();
        System.out.println("topPaidEmps "+topPaidEmps);
        //todo
        input = "hello world";
        String finalRes = input.chars().mapToObj(x->(char)x).filter(c -> !"aeiou".contains(String.valueOf(c))).map(String::valueOf).collect(Collectors.joining(","));
        System.out.println("finalRes "+finalRes);
        //todo
        input = "hello 123 world";
        finalRes = input.chars().filter(x-> !Character.isDigit(x)).mapToObj(c->String.valueOf((char)c)).collect(Collectors.joining());
        System.out.println("finalRes "+finalRes);

    }

}
