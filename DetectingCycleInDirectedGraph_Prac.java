import java.util.*;

class Solution {
    
    public boolean checkCycle(int[] vis, int[] pathVis, ArrayList<ArrayList<Integer>> adjList, int src){
        
        vis[src] = 1;
        pathVis[src] = 1;
        
        for(int nbr : adjList.get(src)){
            if(vis[nbr] == 0){
                return checkCycle(vis, pathVis, adjList, nbr);  
                // this code will fail at '0' coz pathVis[0] is 1. Need to make the pathVis array 0 again for all
            } else if(pathVis[nbr] == 1){
                return true;
            }
            
        }
        
        pathVis[src] = 0;
        
        return false;
    }
    
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(V);
        
        boolean hasCycle = false;
        
        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int[] edg : edges){
            adjList.get(edg[0]).add(edg[1]);
        }
        
        int[] vis = new int[V];
        int[] pathVis = new int[V];
        
        for(int i=0;i<V;i++){
            if(vis[i] == 0 && !hasCycle){
                pathVis = new int[V];
                //Need to make the pathVis array 0 again for all
                hasCycle = checkCycle(vis, pathVis, adjList, i);
            }
        }
        
        return hasCycle;
    }
}