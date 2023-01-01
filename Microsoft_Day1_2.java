import java.util.*;

public class Microsoft_Day1_2 {
    public static void main(String[] args) {
        //input-output handler
    }
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<Integer> al=new ArrayList<Integer>();
            List<List<Integer>> ans=new ArrayList<>();
            recSol(1,k,n,al,ans);
            return ans;
        }
        public void recSol(int i,int k,int n,List<Integer> al,List<List<Integer>> ans){
            if(k==0 && n==0){
                ans.add(new ArrayList<>(al));
                return;
            }
            if(i>=10 || k<0 || n<0)return;
            al.add(i);
            recSol(i+1,k-1,n-i,al,ans);
            al.remove(al.size()-1);
            recSol(i+1,k,n,al,ans);
            return;
        }
    }
}

