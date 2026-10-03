class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<Integer>[] adj  = new List[numCourses];

        for(int i=0;i<numCourses;i++){
            adj[i] = new ArrayList<>();
        }

        int []indegree = new int[numCourses];

        for(int[] a: prerequisites){
            adj[a[1]].add(a[0]);
            indegree[a[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        int count = 0;
        int []ans = new int[numCourses];


        while (!q.isEmpty()) {
            int course = q.poll();
            ans[count] = course;
            count++;
            for(int i=0;i<adj[course].size();i++){
                indegree[adj[course].get(i)]--;
                if(indegree[adj[course].get(i)]==0){
                    q.add(adj[course].get(i));
                }
            }
        }

        if(count==numCourses){
            return ans;
        }
        return new int[]{};
    }
}