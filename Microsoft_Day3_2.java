import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Microsoft_Day3_2 {
    public static void main(String[] args) {
        //input-output
    }
    class Solution {
        boolean[] visited;
        int[] distance;
        public boolean dfs(int i, List<ArrayList<Integer>> tree, int bob){
            if(i == bob){
                visited[i] = true;
                distance[i] = 0;
                return true;
            }
            visited[i] = true;
            for(int child: tree.get(i)){
                if(!visited[child]){
                    if(dfs(child, tree, bob)){
                        distance[i] = distance[child] +1;
                        return true;
                    }
                }
            }
            return false;
        }
        public int dfs2(int i, List<ArrayList<Integer>> tree, int bob, int[] amount, int k){
            visited[i] = true;
            int max = 0;
            if(distance[i] == k){
                max = (amount[i]/2);
            }
            else if((distance[i] == 0 && i == bob) || (distance[i] != 0 && distance[i] < k)){
                max = 0;
            }
            else{
                max = amount[i];
            }
            int ans = Integer.MIN_VALUE;
            boolean flag = false;
            for(int child: tree.get(i)){
                if(!visited[child]){
                    ans = Math.max(ans, dfs2(child, tree, bob, amount, k+1));
                    flag = true;
                }
            }
            
            visited[i] = false;
            if(!flag){
                return max;
            }
            else{
                return max+ans;
            }
            
        }
        public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
            int n = amount.length;
            List<ArrayList<Integer>> tree = new ArrayList<>();
            for(int i=0; i<n; i++){
                tree.add(new ArrayList<>());
                
            }
            for(int i=0; i<edges.length; i++){
                int a = edges[i][0];
                int b = edges[i][1];
                tree.get(a).add(b);
                tree.get(b).add(a);
            }
            visited = new boolean[n];
            distance = new int[n];
            dfs(0, tree, bob);
            System.out.println(Arrays.toString(distance));
            visited = new boolean[n];
            return dfs2(0, tree, bob, amount, 0);
        }
    }
}
