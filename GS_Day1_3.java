public class GS_Day1_3 {
    public static void main(String[] args) {
        
    }
    class Solution {
        public int trailingZeroes(int n) {
            int cnt = 0;
            int dv=5;
            while(dv<=n){
                cnt+=(n/dv);
                dv*=5;
            }
            return cnt;
        }
        
    }
    
}
