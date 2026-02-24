package dsa;

public class SecondSmallestEle {
    public static void main(String[] args) {
        int[] input= {-1,-2,-2,-3,-22,0,1,2,3};
        System.out.println("2nd Smallest element:"+ findSecondSmallest(input));
    }

    private static int findSecondSmallest(int[] input) {
       int min =Integer.MAX_VALUE,res=Integer.MAX_VALUE;
       for(int i: input){
           if(min>i){
               res = min;
               min=i;
           }
           else if(res>i){
               res = i;
           }
       }
       return res;
    }
}
