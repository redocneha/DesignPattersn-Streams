package streams;

import java.util.Comparator;
import java.util.List;

public class BasicStreamOperations {
    public static void main(String[] args) {
        List<Integer> numList = List.of(-1,5,4,9,8,2,3,2,3,1);
        List<String> strList = List.of("B","Neha","Shaik","A");
        // Find Sum of the elements
        // Integer::intValue transform Integer values to primitive int for efficiency as boxing/unboxing will be avoided
        // map to int will transform stream of integer objects to IntStream to work directly with sum,min,max,average
        int sum = numList.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum of the elements in the list:"+sum);

        // Find the Product of All Elements in a List
        int prod = numList.stream().mapToInt(Integer::intValue).reduce(1, (a,b)->a*b);
        System.out.println("Prod of the elements in the list:"+prod);

        // Find the Average of All Elements in a List
        double average = numList.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println("Average of the elements in the list:"+average);

        //Find the Maximum Element in a List
        int max = numList.stream().mapToInt(Integer::intValue).max().orElse(0);
        System.out.println("Max of the elements in the list:"+max);

        // Find the Minimum Element in a List
        int min = numList.stream().min(Integer::compare).orElse(0);
        System.out.println("Min of the elements in the list:"+min);

        //Count the Number of Elements in a List
        long count  = numList.stream().count();
        System.out.println("Count of the elements in the list:"+count);

        // Check if a List Contains a Specific Element
        boolean doesExists = numList.stream().anyMatch(x -> x == 2);
        System.out.println("Does Element Exists:"+doesExists);

        // Filter Out Even Numbers from a List
        List<Integer> evenList = numList.stream().filter(x -> x%2 == 0).toList();
        System.out.println("Even List: "+evenList);

        // Filter Out Odd Numbers from a List
        List<Integer> oddList = numList.stream().filter(x -> x%2 == 1).toList();
        System.out.println("Odd List: "+oddList);

        // Convert a List of Strings to Uppercase
        List<String> transformedList = strList.stream().map(String::toUpperCase).toList();
        System.out.println("Transformed List: "+transformedList);

        // Convert a List of Integers to Their Squares
        List<Integer> sqList = numList.stream().map(x -> x*x).toList();
        System.out.println("Square List: "+sqList);

        // Find the First Element in a List
        int firstEle = numList.getFirst();
        int lastEle = numList.getLast();
        int lastEle2 = numList.stream().reduce(0, (a,b)->b);

        System.out.println("First Ele: "+firstEle);
        System.out.println("Last Ele: "+lastEle);
        System.out.println("Last Ele2: "+lastEle2);

       // Check if All Elements in a List Satisfy a Condition
        boolean doesSatisfy = numList.stream().allMatch(x -> x>0);
        System.out.println("Are all elements positive: "+doesSatisfy);

       //  Check if Any Element in a List Satisfies a Condition
        doesSatisfy = numList.stream().anyMatch(x -> x<0);
        System.out.println("Is Any elements negative: "+doesSatisfy);

       // Remove Duplicate Elements from a List
        List<Integer> processedList = numList.stream().distinct().toList();
        System.out.println("Distinct elements: "+processedList);

       // Sort a List of Integers in Ascending Order
        List<Integer> sortedList = numList.stream().sorted().toList();
        System.out.println("Sorted elements: "+sortedList);

        // Sort a List of Integers in Descending Order
        sortedList = numList.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("Descending Sorted elements: "+sortedList);

        // Sort a List of Strings in Alphabetical Order
        List<String> sortedStrList = strList.stream().sorted().toList();
        System.out.println("Sorted Strings: "+sortedStrList);

        // Sort a List of Strings by Their Length
        // sorted( always takes comparator and which inturn takes what to be sorted)
        sortedStrList = strList.stream().sorted(Comparator.comparingInt(String::length)).toList();
        System.out.println("Sorted Strings by length: "+sortedStrList);


    }
}
