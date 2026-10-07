class Solution {
    public boolean validTree(int n, int[][] edges) {
    
        if (edges.length != n - 1) return false;

        List<Integer> [] adj = new List[n];

        for(int i=0;i<adj.length;i++){
            adj[i] = new ArrayList<>();
        }

        for(int[]a: edges){
            adj[a[0]].add(a[1]);
            adj[a[1]].add(a[0]);
        }

        HashSet<Integer> hs = new HashSet<>();
        dfs(adj, hs,0);

        if(hs.size()==n){
            return true;
        }

        return false;


    }

    public void dfs(List<Integer>[] adj, HashSet<Integer> hs, int src){
        hs.add(src);
        for(int a:adj[src]){
            if(!hs.contains(a)){
                dfs(adj, hs, a);
            }
        }
    }
}
