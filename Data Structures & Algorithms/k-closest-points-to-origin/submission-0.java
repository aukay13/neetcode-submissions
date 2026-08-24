class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->b[0]*b[0]+b[1]*b[1]-a[0]*a[0]-a[1]*a[1]);

        for(int[] x:points){
            maxHeap.add(x);
        }

        while (maxHeap.size()>k) {
            maxHeap.poll();
        }

        int ans[][] = new int[k][2];

        while (!maxHeap.isEmpty()) {
            ans[--k] = maxHeap.poll();
        }

        return ans;
        
    }
}