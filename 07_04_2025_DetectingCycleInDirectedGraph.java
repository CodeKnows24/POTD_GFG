import java.util.*;

class Solution {
    
    public boolean checkCycle(int src, int[] vis, ArrayList<ArrayList<Integer>> adjList, int[] visParent){
        vis[src] = 1;
        visParent[src] = 1;
        
        for(int nbr : adjList.get(src)){
            if(vis[nbr] ==  0){
                
                boolean hasCycle = checkCycle(nbr, vis, adjList,visParent);
                if(hasCycle){
                    return true;
                }
            }
            else if(visParent[nbr] == 1){
                return true;
            }
        }
        visParent[src] = 0;
        
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
        int[] visParent = new int[V];
        
        for(int i=0;i<V;i++){
            if(vis[i] == 0 && !hasCycle){
                hasCycle = checkCycle(i,vis, adjList,visParent);
                
            }
        }
        
        return hasCycle;
    }
}
