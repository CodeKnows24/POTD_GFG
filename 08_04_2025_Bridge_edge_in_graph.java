import java.util.*;

class Solution {
    public void checkBridge(ArrayList<ArrayList<Integer>> adjList, boolean[] vis, int src){
        
        vis[src] = true;
        
        for(int nbr : adjList.get(src)){
            if(!vis[nbr]){
                checkBridge(adjList, vis, nbr);
            }
        }
        
        return;
    }
    public boolean isBridge(int V, int[][] edges, int c, int d) {
        // code here
        
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int[] edg : edges){
            if(edg[0] == c && edg[1] == d){
                continue;
            }
            adjList.get(edg[0]).add(edg[1]);
            adjList.get(edg[1]).add(edg[0]);
        }
        
        boolean vis[] = new boolean[V];
        checkBridge(adjList, vis, c);
        
        return !vis[d];
       
    }
}