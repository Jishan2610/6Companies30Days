import java.util.ArrayList;

public class Microsoft_Day3_1 {
    public static void main(String[] args) {
        //input-output
    }
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            ArrayList<Integer>[] adj=new ArrayList[numCourses];
            for(int i=0;i<numCourses;i++)adj[i]=new ArrayList<>();
            for(int[] curr:prerequisites){
                adj[curr[0]].add(curr[1]);
            }
            boolean[] vis=new boolean[numCourses];
            boolean[] dfsVis=new boolean[numCourses];
            for(int i=0;i<numCourses;i++){
                if(!vis[i]){
                    if(isCyclic(i,adj,vis,dfsVis))return false;
                }
            }
            return true;
        }
        public boolean isCyclic(int node,ArrayList<Integer>[] adj,boolean[] vis,boolean[] dfsVis){
            vis[node]=true;
            dfsVis[node]=true;
            for(int nbr:adj[node]){
                if(!vis[nbr]){
                    if(isCyclic(nbr,adj,vis,dfsVis))return true;
                }
                else if(dfsVis[nbr])return true;
            }
            dfsVis[node]=false;
            return false;
        }
    }
}
