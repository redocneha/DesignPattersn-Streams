package dsa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermInString {
        public static boolean checkInclusion(String s1, String s2) {
            if(s1.length()>s2.length()) return false;
            int[] s1Count = new int[26];
            int[] s2Count = new int[26];
            int len = s1.length();
            int st=0,end=st+len-1;
            for(int i=0;i<len;i++){
                s1Count[s1.charAt(i)-'a']++;
                s2Count[s2.charAt(i)-'a']++;
            }
            while(st<=end && end<s2.length()-1){
                if(matches(s1Count,s2Count)) return true;
                s2Count[s2.charAt(st)-'a']--;
                s2Count[s2.charAt(end+1)-'a']++;
                st++;
                end++;
            }
            return matches(s1Count,s2Count);
        }
        public static boolean matches(int[] arr1, int[] arr2){
            for(int i=0;i<26;i++){
                if(arr1[i]!=arr2[i]) return false;
            }
            return true;
    }


    public static void main(String[] args) {

        System.out.println("Result is "+checkInclusion("r","aor"));
    }
}
