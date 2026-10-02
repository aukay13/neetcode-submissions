class Solution {
    public int countComponents(int n, int[][] edges) {
       List<Integer>[] adj = new ArrayList[n];
       
       for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }

       for(int[] a: edges){
        adj[a[0]].add(a[1]);
        adj[a[1]].add(a[0]);
       }

       Queue<Integer> q = new LinkedList<>();
       int[] visited = new int[n];
       int ans = 0;

       for(int i=0;i<n;i++){
        if(visited[i]==0){
            visited[i]=1;
            q.add(i);
            ans++;
            bfs(adj, q, visited);
        }
       }

       return ans;

    }

    public void bfs(List<Integer>[] adj, Queue<Integer> q, int[]visited){
        while (!q.isEmpty()) {
            int curr = q.poll();
            for(int a:adj[curr]){
                if(visited[a]==0){
                    q.add(a);
                    visited[a]=1;
                }
            }
        }
    }
}
