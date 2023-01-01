//package 6Companies30Days;

public class Microsoft_Day2_1 {
    public static void main(String[] args) {
        //input-output will be handled
    }
    public int maxRotateFunction(int[] nums) {
        long sum = 0,original = 0;
        
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            original += i*nums[i];
        }
        
        long maximum = original;
        int n = nums.length;
        
        for(int i= n-1;i>=0;i--)
        {
            original += sum -(nums[i]*n);
            maximum = Math.max(original,maximum);
        }
        return (int)maximum; 
    }
}
