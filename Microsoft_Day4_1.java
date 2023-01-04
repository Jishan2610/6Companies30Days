import java.util.Stack;

public class Microsoft_Day4_1 {
    public static void main(String[] args) {
        //input-output
    }
    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            //maintain a monotonic stack for both the sides with the indexes
            Stack<Integer> st=new Stack<>();
            int i=0;
            int n=nums.length;
            int left=n-1;
            while(i<n){
                while(st.size()>0 && nums[st.peek()]>nums[i]){
                    int ele=st.pop();
                    left=Math.min(ele,left);
                }
                st.push(i);
                i++;
            }
            st.clear();
            i=n-1;
            int right=0;
            while(i>=0){
                while(st.size()>0 && nums[st.peek()]<nums[i]){
                    int ele=st.pop();
                    right=Math.max(right,ele);
                }
                st.push(i);
                i--;
            }
            if(left<right)return right-left+1;
            return 0;
            
    
        }
    }
}
