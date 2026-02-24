package dsa;

class Solution {
        public static String removeDuplicates(String s, int k) {
            int len=s.length();
            int i=0,j=i+k-1;
            char str[] = s.toCharArray();
            StringBuilder tmp = new StringBuilder("");
            while(true){
                i=0;
                j=i+k-1;
                tmp = new StringBuilder("");
                while(j<len){
                    if(str[i]==str[j]){
                        String subStr = s.substring(i,j+1);
                        if(subStr.chars().distinct().count()==1){
                            i=j+1;
                            j=i+k-1;
                            continue;
                        }
                    }
                        tmp.append(str[i]);
                        i++;
                        j = i + k - 1;
                    }
                String subStr2 = s.substring(i,len);
                tmp.append(subStr2);
                if(s.contentEquals(tmp)) break;
                s=tmp.toString();
                str = s.toCharArray();
                len = s.length();
            }
            return s;
        }


    public static void main(String[] args) {
        System.out.println("Result: "+removeDuplicates("viittttttiiiillllkkkkkkllllllkkkkkkllkkkkkkcnoooossssssooasu",6));
    }
}