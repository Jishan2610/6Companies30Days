import java.util.*;

public class Microsoft_Day1_3 {
    public static void main(String[] args) {
        //input-output handler
    }
    class Solution {
        public String getHint(String secret, String guess) {
            int bulls=0;
            HashMap<Character,Integer> hm=new HashMap<>();
            for(int i=0;i<secret.length();i++){
                if(secret.charAt(i)==guess.charAt(i)){
                    bulls++;
                }
            }
            int cows=0;
            for(int i=0;i<guess.length();i++){
                char ch=guess.charAt(i);
                if(ch!=secret.charAt(i)){
                    //Not Bull
                    hm.put(ch,hm.getOrDefault(ch,0)+1);
                }
            }
            for(int i=0;i<secret.length();i++){
                char ch=secret.charAt(i);
                if(ch!=guess.charAt(i)){
                    //Not Bull
                    if(hm.containsKey(ch) && hm.get(ch)>0){
                        cows++;
                        hm.put(ch,hm.get(ch)-1);
                    }
    
                }
            }
            String ans=bulls+"A"+cows+"B";
            return ans;
        }
    }
}
