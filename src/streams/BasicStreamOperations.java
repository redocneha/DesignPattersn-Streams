package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static streams.StreamOperations.loadEmployees;

public class BasicStreamOperations {
    public static void main(String[] args) throws IOException {
        List<Integer> numList = List.of(-1, 5, 4, 9, 8, 2, 3, 2, 3, 1);
        List<String> strList = List.of("B", "Neha", "Shaik", "A");
        // Find Sum of the elements
        // Integer::intValue transform Integer values to primitive int for efficiency as boxing/unboxing will be avoided
        // map to int will transform stream of integer objects to IntStream to work directly with sum,min,max,average


        // Find the Product of All Elements in a List


        // Find the Average of All Elements in a List
        double average = numList.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println("Average of the elements in the list:" + average);

        //Find the Maximum Element in a List
        int max = numList.stream().mapToInt(Integer::intValue).max().orElse(0);
        System.out.println("Max of the elements in the list:" + max);

        // Find the Minimum Element in a List
        int min = numList.stream().min(Integer::compare).orElse(0);
        System.out.println("Min of the elements in the list:" + min);

        //Count the Number of Elements in a List
        long count = numList.stream().count();
        System.out.println("Count of the elements in the list:" + count);

        // Check if a List Contains a Specific Element
        boolean doesExists = numList.stream().anyMatch(x -> x == 2);
        System.out.println("Does Element Exists:" + doesExists);

        // Filter Out Even Numbers from a List
        List<Integer> evenList = numList.stream().filter(x -> x % 2 == 0).toList();
        System.out.println("Even List: " + evenList);

        // Filter Out Odd Numbers from a List
        List<Integer> oddList = numList.stream().filter(x -> x % 2 == 1).toList();
        System.out.println("Odd List: " + oddList);

        // Convert a List of Strings to Uppercase
        List<String> transformedList = strList.stream().map(String::toUpperCase).toList();
        System.out.println("Transformed List: " + transformedList);

        // Convert a List of Integers to Their Squares
        List<Integer> sqList = numList.stream().map(x -> x * x).toList();
        System.out.println("Square List: " + sqList);

        // Find the First Element in a List
        int firstEle = numList.getFirst();
        int lastEle = numList.getLast();
        int lastEle2 = numList.stream().reduce(0, (a, b) -> b);

        System.out.println("First Ele: " + firstEle);
        System.out.println("Last Ele: " + lastEle);
        System.out.println("Last Ele2: " + lastEle2);

        // Check if All Elements in a List Satisfy a Condition
        boolean doesSatisfy = numList.stream().allMatch(x -> x > 0);
        System.out.println("Are all elements positive: " + doesSatisfy);

        //  Check if Any Element in a List Satisfies a Condition
        doesSatisfy = numList.stream().anyMatch(x -> x < 0);
        System.out.println("Is Any elements negative: " + doesSatisfy);

        List<Integer> numbers = List.of(1, 2, 2, 3, 4, 4, 5);
        List<Integer> distinctNumList = numbers.stream().distinct().toList();
        System.out.println("Distinct List: " + distinctNumList);

        numbers = List.of(10, 12, 2, 23, 4, 40, 5);
        List<Integer> sortedList = numbers.stream().sorted().toList();
        System.out.println("Sorted List: " + sortedList);

        sortedList = numbers.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("Sorted List: " + sortedList);

        List<String> stringList = List.of("banana","apee","cherry","aq");
        List<String> sortedStrList = stringList.stream().sorted().toList();
        System.out.println("Sorted List: " + sortedStrList);

        sortedStrList = stringList.stream().sorted(Comparator.comparingInt(String::length)).toList();
        System.out.println("Sorted List by length: " + sortedStrList);

        List<String> versionList = List.of("1.2.2","0.1","1.1","2.0.2","1.3","1.2.1","0.1.1");
        sortedStrList = versionList.stream().map(s -> s.split("\\.")).sorted((a,b)->{
            for(int i=0;i<3;i++) {
                int v1 = a.length <= i ? 0 : Integer.parseInt(a[i]);
                int v2 = b.length <= i ? 0 : Integer.parseInt(b[i]);
                if (v1 != v2) return Integer.compare(v1, v2);
            }
            return 0;
        }).map(x -> String.join(".",x)).toList();
        System.out.println("Sorted Version list: " + sortedStrList);

        int number = 1234;
        int sum = String.valueOf(number).chars().map(Character::getNumericValue).sum();
        System.out.println("Sum of the digits in the number: " + sum);

        number = 5;
        int factorial = IntStream.rangeClosed(1,number).reduce(1,(a,b)->a*b);
        System.out.println("Factorial of number: " + factorial);


        numbers = List.of(10, 22, 3, 41, 5);
        int secondMax = numbers.stream().sorted(Comparator.reverseOrder()).skip(1).toList().getFirst();
        int secondMax2 = numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0); //better
        System.out.println("Second max of list: " + secondMax2);
        System.out.println("Second max of list: " + secondMax);


        numbers = List.of(10, 22, 3, 41, 5);
        int secondMin= numbers.stream().sorted().skip(1).toList().getFirst();
        int secondMin2 = numbers.stream().sorted().skip(1).findFirst().orElse(0); //better
        System.out.println("Second min of list: " + secondMin2);
        System.out.println("Second min of list: " + secondMin);

        List<String> words = List.of("apple", "banana", "kiwi2221","appel","ananab");
        String longestStr = words.stream().max(Comparator.comparingInt(String::length)).orElse("");
        System.out.println("Longest length string in list: " + longestStr);

        String shortestStr = words.stream().min(Comparator.comparingInt(String::length)).orElse("");
        System.out.println("Shortest length string in list: " + shortestStr);

        Map<Integer,List<String>> groupedByLen= words.stream().collect(Collectors.groupingBy(String::length));
        System.out.println("Grouped by Length: " + groupedByLen);

        Person person1 = new Person(23,"Neha","HR");
        Person person2 = new Person(25,"Teddy","HR");
        Person person3 = new Person(21,"Irfan","CSE");
        Person person4 = new Person(21,"Irfan2","IT");

        List<Person> personList = List.of(person1,person2,person3,person4);

        Map<Integer,List<Person>> ageGroupedList = personList.stream().collect(Collectors.groupingBy(Person::age));
        System.out.println("Grouped by Age: " + ageGroupedList);

        Map<String,List<String>> departmentNames = personList.stream().collect(Collectors.groupingBy(
                Person::department,
                Collectors.mapping(Person::name, Collectors.toList())
        ));
        System.out.println("Grouped by Department: " + departmentNames);
        Map<Integer,List<String>> ageGroupDep = personList.stream().collect(Collectors.groupingBy(Person::age, Collectors.mapping(Person::department, Collectors.toList())));
        System.out.println("Dep Grouped by Age: " + ageGroupDep);

        numbers = List.of(10, 22, 3, 41, 5);
        Map<Boolean,List<Integer>> partitionedList = numbers.stream().collect(Collectors.partitioningBy(x->x%2==0));
        System.out.println("Partitioned map : " + partitionedList);

        System.out.println("Even Numbers partition : " + partitionedList.get(true));
        System.out.println("Odd Numbers partition : " + partitionedList.get(false));

        List<Integer> list1 = List.of(1, 20, 3,6);
        List<Integer> list2 = List.of(4, 5, 6);

        List<Integer> mergedList = Stream.concat(list1.stream(),list2.stream()).toList();
        System.out.println("Merged List "+mergedList);

        mergedList = Stream.concat(list1.stream(),list2.stream()).sorted().toList();
        System.out.println("Sorted Merged List "+mergedList);

        List<Integer> commonList = list1.stream().filter(list2::contains).toList();
        System.out.println("Common List "+commonList);

        List<Integer> unionList =Stream.concat(list1.stream(),list2.stream()).distinct().toList();
        System.out.println("Union List "+unionList);

        List<Integer> diffList = list1.stream().filter( x-> !list2.contains(x)).toList();
        System.out.println("Diff List "+diffList);

        words = List.of("apple", "banana", "apple", "orange");
        Map<String,Long> countList = words.stream().collect(Collectors.groupingBy(s->s,Collectors.counting()));
        System.out.println("Count List "+countList);

        String word = "hellooo";
        Map<Character,Long> charLength = word.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c, Collectors.counting()));
        System.out.println("Char Length "+charLength);

        String input = "hello world hello";
        countList = Arrays.stream(input.split(" ")).collect(Collectors.groupingBy(s->s,Collectors.counting()));
        System.out.println("Count List "+countList);

        charLength = input.chars().mapToObj(c->(char)c).filter(c ->"aeiou".contains(String.valueOf(c))).collect(Collectors.groupingBy(c->c, Collectors.counting()));
        System.out.println("Count List "+charLength);

        input = "hello 1213 world 456";
        Map<Character,Long> hm = input.chars().mapToObj(c->(char)c).filter(Character::isDigit).collect(Collectors.groupingBy(c->c, Collectors.counting()));
        System.out.println("Char Digit List "+hm);

        numbers = List.of(1, 2, 3, 4, 5);
        List<Integer> reversed = numbers.stream().collect(Collectors.collectingAndThen(Collectors.toList(),(list)->{
            Collections.reverse(list);
            return list;
        }));
        System.out.println("Reversed== "+reversed);

//        input.chars().mapToObj(c->(char)c).collect(Collectors.collectingAndThen(Collectors.toList(),(list)->{
//            Collections.reverse(list);
//            return list;
//        }));
//        System.out.println("Reversed== "+reversed);

        words = List.of("apple", "banana", "apple", "orange", "banana", "apple");
        String mostFreqEle = words.stream().collect(Collectors.groupingBy(s->s,Collectors.counting())).entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue)).map(Map.Entry::getKey).orElse("");
        System.out.println("Most freq element "+mostFreqEle);

        words = List.of("apple", "banana", "apple", "orange", "banana", "apple");
        String minFreqEle = words.stream().collect(Collectors.groupingBy(s->s,Collectors.counting())).entrySet().stream().min(Comparator.comparingLong(Map.Entry::getValue)).map(Map.Entry::getKey).orElse("");
        System.out.println("Least freq element "+minFreqEle);

        input = "helloh";
        Character nonRepeatedChar = input.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,LinkedHashMap::new,Collectors.counting()))
                                    .entrySet().stream().filter(entry -> entry.getValue() ==1).findFirst().map(Map.Entry::getKey).orElse(' ');
        System.out.println("First Non repeated character "+nonRepeatedChar);
        Character repeatedChar = input.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() >1).findFirst().map(Map.Entry::getKey).orElse(' ');
        System.out.println("First repeated character "+repeatedChar);

        input = "madam";
        String finalInput = input;
        boolean isPalin = IntStream.rangeClosed(0,input.length()/2).allMatch(i -> finalInput.charAt(i) == finalInput.charAt(finalInput.length()-i-1));
        System.out.println("Is Palindrome: "+isPalin);

        List<String> wordList = List.of("listen", "silent", "enlist", "google", "inlets");
        String target = "silent";
        List<String> anagramList = wordList.stream().filter(wor -> Arrays.equals(wor.chars().sorted().toArray(), target.chars().sorted().toArray())).toList();
        // Arrays.equals is on arrays . sorted() returns only intstream
        System.out.println("Anagram list: "+anagramList);

        List<Integer> randomList = Stream.generate(()-> new Random().nextInt(100)).limit(10).toList();
        System.out.println("Random list: "+randomList);

        List<List<Integer>> listOfLists = List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 9)
        );
        mergedList = listOfLists.stream().flatMap(List::stream).toList();
        System.out.println("mergedList list: "+mergedList);

        int evenSum = listOfLists.stream().flatMap(List::stream).filter(x->x%2==0).mapToInt(Integer::intValue).sum();
        System.out.println("Even numbers sum: "+evenSum);

        int oddSum = listOfLists.stream().flatMap(List::stream).filter(x->x%2!=0).mapToInt(Integer::intValue).sum();
        System.out.println("Odd numbers sum: "+oddSum);

        words = List.of("madam", "racecar", "apple", "banana", "level");
        String longestPalindrome = words.stream().filter(ele -> IntStream.rangeClosed(0,ele.length()/2).allMatch(i->ele.charAt(i) == ele.charAt(ele.length()-i-1)))
                .max(Comparator.comparingInt(String::length)).orElse("");
        System.out.println("Longest Palin: "+longestPalindrome);
        longestPalindrome = words.stream().filter(ele -> ele.contentEquals(new StringBuilder(ele).reverse()))
                .max(Comparator.comparingInt(String::length)).orElse("");
        // reverse exists on stringbuilder but not string
        System.out.println("Longest Palin: "+longestPalindrome);

        String shortestPalindrome = words.stream().filter(ele -> ele.contentEquals(new StringBuilder(ele).reverse()))
                .min(Comparator.comparingInt(String::length)).orElse("");
        // reverse exists on stringbuilder but not string
        System.out.println("Shortest Palin: "+shortestPalindrome);

        input = "hello world2 this is a test";
        String longestWord = Arrays.stream(input.split(" ")).max(Comparator.comparingInt(String::length)).orElse("");
        System.out.println("Longest Word: "+longestWord);

        String shortestWord = Arrays.stream(input.split(" ")).min(Comparator.comparingInt(String::length)).orElse("");
        System.out.println("Shortest Word: "+shortestWord);

        long wordsLen = Arrays.stream(input.split(" ")).count();
        System.out.println("word count: "+wordsLen);

        Path filePath = Paths.get("src/streams/demo.txt");
        long lineCount = Files.lines(filePath).count();
        System.out.println("Line count: "+lineCount);
        long charCount = Files.lines(filePath).flatMapToInt(String::chars).count();
        System.out.println("Char count: "+charCount);

        long wordCount = Files.lines(filePath).flatMap(line -> Arrays.stream(line.split(" "))).count();
        System.out.println("Word count: "+wordCount);
        String json = "[{\"name\":\"Alice\",\"age\":25},{\"name\":\"Bob\",\"age\":30}]";
//        List<Person> personList1 = new ObjectMapper().readValue(json, new TypeReference<List<Person>>(){});
        // Typereference is needed to preserve generic type in output list, wihout this java returns List<Obj>

        CompletableFuture<List<Integer>> cf1 = CompletableFuture.supplyAsync(() -> List.of(1,2,3));
        CompletableFuture<List<Integer>> cf2 = CompletableFuture.supplyAsync(() -> List.of(4,6,9));

        List<Integer> mergedCf = Stream.of(cf1, cf2).flatMap(x -> x.join().stream()).toList();
        System.out.println("Merged Async CF"+mergedCf);

        List<Integer>  numList2 = IntStream.rangeClosed(1,10000).boxed().toList();
        int sum2 = numList2.parallelStream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum--"+sum2);

        List<String> numbersStr = List.of("1", "2", "three", "4");
        List<Integer> parsedNumbers = numbersStr.stream()
                .map(s -> {
                    try {
                        return Integer.parseInt(s);
                    } catch (NumberFormatException e) {
                        return -1;
                    }
                })
                .toList();
        System.out.println("Parsed Numbers: " + parsedNumbers);

        List<Integer> numbers2 = List.of(1, 2, 3, 4, 5);
        DoubleSummaryStatistics doubleSummaryStatistics = numbers2.stream().collect(Collectors.summarizingDouble(Integer::intValue));
        System.out.println("Summary double: " + doubleSummaryStatistics);

        IntSummaryStatistics intSummaryStatistics = numbers2.stream().collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println("Summary Integer: " + intSummaryStatistics);

        LongSummaryStatistics longSummaryStatistics = numbers2.stream().collect(Collectors.summarizingLong(Integer::intValue));
        System.out.println("Summary long: " + longSummaryStatistics);

        List<Employee> employeeList = loadEmployees();

        Map<String,Double> depAvg = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("Average per department: " + depAvg);

        List<Employee> topNEmp = employeeList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).limit(3).toList();
        System.out.println("Top N Employees: " + topNEmp);

        List<String> words2 = Files.lines(filePath).flatMap( x-> Arrays.stream(x.split(" "))).toList();
        System.out.println("words---"+words2);

        List<String> mostFreqWords = words2.stream().collect(Collectors.groupingBy(s->s,Collectors.counting())).entrySet().stream().sorted((a,b)-> Math.toIntExact(b.getValue() - a.getValue())).map(Map.Entry::getKey).limit(2).toList();
        System.out.println("Top 2 Most freq words---"+mostFreqWords);
        mostFreqWords = words2.stream().collect(Collectors.groupingBy(s->s,Collectors.counting())).entrySet().stream().sorted(Map.Entry.<String,Long>comparingByValue().reversed()).map(Map.Entry::getKey).limit(2).toList();
        System.out.println("Top 2 Most freq words---"+mostFreqWords);

        String input2 = "hello world";
        String result = input2.chars().mapToObj(x->String.valueOf( (char) x)).filter(c->!"aeiou".contains(c)).collect(Collectors.joining());
        System.out.println("Result after removing vowels--"+result);

        result = input2.chars().mapToObj(x->String.valueOf( (char) x)).filter("aeiou"::contains).collect(Collectors.joining());
        System.out.println("Result after removing consonants--"+result);

        input = "hello 123 world";
        result = input.chars().filter(x -> !Character.isDigit((char)x)).mapToObj(x -> String.valueOf((char)x)).collect(Collectors.joining());;
        System.out.println("Result after removing digits--"+result);

        String inputSpl = "hello@world!";
        result = inputSpl.chars().filter(x -> Character.isLetter(x) || Character.isDigit(x)).mapToObj(x-> String.valueOf((char)x)).collect(Collectors.joining());
        System.out.println("Result after special chars--"+result);

        String inputSpl2 = "hello 123 world 456";
        sum2 = inputSpl2.chars().filter(x -> Character.isDigit((char)x)).map(Character::getNumericValue).sum();
        System.out.println("Sum of digits in string--"+sum2);

        String input3 = "hello world hello";
        Map<String, Long> wordCnt = Arrays.stream(input3.split(" ")).collect(Collectors.groupingBy(s->s, Collectors.counting()));
        System.out.println("Word count --"+wordCnt);

        List<String> uniqueWords = Arrays.stream(input3.split(" ")).distinct().toList();
        System.out.println("Unique Words --"+uniqueWords);

        String input4 = "madam racecar apple banana level";
        List<String> palinStr = Arrays.stream(input4.split(" ")).filter(str -> new StringBuilder(str).reverse().toString().equalsIgnoreCase(str)).toList();
        System.out.println("Palind words --"+palinStr);

        List<String> startLtrList = Arrays.stream(input4.split(" ")).filter(str -> str.startsWith("m")).toList();
        System.out.println("Start letter words --"+startLtrList);

        List<String> endLtrList = Arrays.stream(input4.split(" ")).filter(str -> str.endsWith("r")).toList();
        System.out.println("End letter words --"+endLtrList);









    }


}

