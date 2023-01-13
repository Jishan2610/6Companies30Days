import java.util.Arrays;

public class Microsoft_Day5_2 {
    public static void main(String[] args) {
        
    }
    class Solution {
        public int minOperations(int[] nums, int[] numsDivide) {
            int gcd=numsDivide[0];
            for(int i=0;i<numsDivide.length;i++){
                gcd=gcd(gcd,numsDivide[i]);
            }
            int cnt=0;
            Arrays.sort(nums);
            for(int i=0;i<nums.length;i++){
                if(gcd%nums[i]==0){
                    break;
                }
                cnt++;
            }
            if(cnt==nums.length)return -1;
            return cnt;
        }
        public int gcd(int a,int b){
            if (b == 0)
                return a;
            return gcd(b, a % b);
        }
    }
}
