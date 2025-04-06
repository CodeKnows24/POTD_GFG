import java.util.*;

class Solution {
    
    public static void topoSortUtil(ArrayList<ArrayList<Integer>> adjList, boolean[] vis, 
        ArrayList<Integer> ansList, int src){
        
        vis[src] = true;
        
        for(int nbr : adjList.get(src)){
            if(!vis[nbr]){
                topoSortUtil(adjList, vis, ansList, nbr);
            }
        }
        
        ansList.add(src);
        
        return;
        
    }

    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(V);
        
        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int[] edg : edges){
            adjList.get(edg[0]).add(edg[1]);
        }
        
        
        // for(int i=0;i<V;i++){
        //     for(int nbr : adjList.get(i)){
        //         System.out.println(i + " ---> " + nbr);
        //     }
        // }
        
        ArrayList<Integer> ansList = new ArrayList<>(7);
        
        boolean[] vis = new boolean[V];
        
        for(int i=0;i<V;i++){
            // similar to common components
            if(!vis[i]){
                topoSortUtil(adjList, vis, ansList, i);
            }
        }
        
        Collections.reverse(ansList);
        
        return ansList;
        
    }
}