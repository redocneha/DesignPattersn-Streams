package dsa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MaxFreqEleArray {
        private static Integer getMaxFreq(int[] nums){
            int max=0;
            Map<Integer,Integer> hm = new HashMap<>();
            int[] copy =Arrays.copyOf(nums,nums.length);
            Arrays.sort(copy);
            for(int num:copy){
                 hm.put(num,hm.getOrDefault(num,0)+1);
            }
            return hm.values().stream().max(Integer::compare).orElse(0);
        }
        public static int helper(int[] nums, int i, int k){
            if(i>=nums.length || k == 0) return getMaxFreq(nums);
            nums[i]++;
            int res1 = helper(nums,i,k-1);
            nums[i]--;
            int res2 = helper(nums,i+1,k);
            return Math.max(res1,res2);
        }
        public static int maxFrequency(int[] nums, int k) {
            return helper(nums,0,k);
    }

    public static void main(String[] args) {
            int [] nums = {3,9,6};
            int k = 2;
        System.out.println("Result is "+maxFrequency(nums,k));
    }
}
