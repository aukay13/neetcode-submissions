class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<Integer>[] adj  = new List[numCourses];

        for(int i=0;i<numCourses;i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] a: prerequisites){
            adj[a[1]].add(a[0]);
        }

        int[] visited = new int[numCourses];
        int[] path = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(visited[i]==0){
                if(hasCycle(i, visited, path, adj)){
                    return false;
                }
            }
        }
        return true;


    }

    public boolean hasCycle(int src, int[]visited, int[]path, List<Integer>[] adj){
        visited[src]=1;
        path[src]=1;
        for(int ele: adj[src]){
            if(path[ele]==1){
                return true;
            }
            if(visited[ele]!=1){
                if(hasCycle(ele, visited, path, adj)){
                    return true;
                }
            }
        }
        path[src]=0;
        
        return false;
    }

}