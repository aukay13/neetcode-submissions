class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(Integer i:nums){
            minHeap.add(i);
        }

        while (minHeap.size()!=k) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
