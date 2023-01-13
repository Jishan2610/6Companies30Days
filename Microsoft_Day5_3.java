public class Microsoft_Day5_3 {
    public static void main(String[] args) {
        
    }
    class Solution {
        public int numberOfSubstrings(String s) {
            int n=s.length();
            int[][] indexes=new int[n][3];
            for(int i=n-1;i>=0;i--){
                char ch=s.charAt(i);
                if(i==n-1){
                    for(int j=0;j<3;j++){
                        if(j==(ch-'a')){
                            indexes[i][j]=i;
                        }
                        else indexes[i][j]=n;
                    }
                }
                else{
                    for(int j=0;j<3;j++){
                        if(j==(ch-'a')){
                            indexes[i][j]=i;
                        }
                        else indexes[i][j]=indexes[i+1][j];
                    }
                }
            }
            int cnt=0;
            for(int i=0;i<n-2;i++){
                int maxIdx=Math.max(Math.max(indexes[i][0],indexes[i][1]),indexes[i][2]); 
                cnt+=(n-maxIdx);
            }
            return cnt;
        }
    }
}
