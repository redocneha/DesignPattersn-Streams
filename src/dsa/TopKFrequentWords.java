package dsa;

import java.util.*;

public class TopKFrequentWords {
        public static List<String> topKFrequent(String[] words, int k) {
            PriorityQueue<WordCount> pq = new PriorityQueue<>(k, new WordCntComparator());
            if(k==0 || words.length == 0 || words.length<k) return null;
            List<String> res = new ArrayList<>();
            for (String curr : words) {
                Optional<WordCount> existingWc = pq.stream().filter(wc -> wc.word.equals(curr)).findAny();
                if (existingWc.isPresent()) {
                    WordCount wordCount = existingWc.get();
                    pq.remove(wordCount);
                    pq.add(new WordCount(curr, wordCount.count+1));
                } else {
                    pq.add(new WordCount(curr, 1));
                }
            }
            while(k-->0){
                res.add(pq.poll().word);
            }
            return res;
        }
        static class WordCount{
            String word;
            int count;
            public WordCount(String word,int count){
                this.word = word;
                this.count = count;
            }
        }
        static class WordCntComparator implements Comparator<WordCount> {

            @Override
            public int compare(WordCount o1, WordCount o2) {
                if(o1.count == o2.count) return o1.word.compareTo(o2.word);
                return o2.count - o1.count;
            }
        }

    public static void main(String[] args) {
            String[] words = {"i","love","leetcode","i","love","coding"};
        System.out.println("Result is");
        topKFrequent(words,2).forEach(System.out::println);
    }
}
