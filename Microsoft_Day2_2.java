import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//package 6Companies30Days;

public class Microsoft_Day2_2 {
    public static void main(String[] args) {
        
    }
    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            int n=nums.length;
            if(n==1){
                List<Integer> ans= new ArrayList<>();
                ans.add(nums[0]);
                return ans;
            }
            Arrays.sort(nums);
            ArrayList<Integer>[] dp=new ArrayList[n];
            dp[n-1]=new ArrayList<Integer>();
            dp[n-1].add(nums[n-1]);
            int final_max_idx=n-1;
            int final_max_size=0;
            for(int i=n-2;i>=0;i--){
                int curr_max_size=0;
                int curr_max_idx=-1;
                for(int j=i+1;j<n;j++){
                    if(nums[j]%nums[i]==0){
                        if(dp[j].size()+1>curr_max_size){
                            curr_max_size=dp[j].size()+1;
                            curr_max_idx=j;
                        }
                    }
                }
                if(curr_max_size>final_max_size){
                    final_max_size=curr_max_size;
                    final_max_idx=i;
                }
                dp[i]=new ArrayList<>();
                dp[i].add(nums[i]);
                if(curr_max_idx!=-1){
                    for(int element:dp[curr_max_idx])dp[i].add(element);
                }
                
            }
            //if(final_max_idx==n)return new ArrayList<Integer>();
            return dp[final_max_idx];
        }
    }
}
