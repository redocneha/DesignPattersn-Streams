package dsa;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortCharsByFreq {
    public static void main(String[] args) {
        String input= "cccaaa";
        System.out.println("Result: "+ sortByFreq(input));
    }

    private static String sortByFreq(String input) {
        Map<Character,Integer> hm = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<input.length();i++){
            Character curr = input.charAt(i);
            hm.put(curr,hm.getOrDefault(curr,0)+1);
        }
        List<Character> desc =hm.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .toList();
        for(Character c: desc){
            int count = hm.get(c);
           while(count-->0) stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

}
