package dsa;

public class CycleInArray {
    public static void main(String[] args) {
        int[] input= {1,-2,3,1};
        int stIndex = 0;
        System.out.println("Cycle length:"+ findCycleLength(input,stIndex));
    }

    private static int findCycleLength(int[] input, int stIndex) {
        int fp=stIndex,sp=stIndex;
        int len=0;
        if(input[stIndex]>input.length || input[stIndex]<0) return -1;
        do{
            if(input[fp]<0 || input[input[fp]] < 0 || input[fp]>input.length || input[input[fp]]> input.length) return -1;
            fp=input[input[fp]];
            sp=input[sp];
        }while(fp!=sp);
        fp=stIndex;
        do{
            fp=input[fp];
            len++;
        }while(fp!=sp);
        return len;
    }
}
