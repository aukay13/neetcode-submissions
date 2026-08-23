public class KthLargest {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int reqSize;

    public KthLargest(int k, int[] nums) {
        reqSize = k;
        for(Integer i:nums){
            minHeap.add(i);
        }

        if(minHeap.size()>k){
            while (minHeap.size()!=k) {
                minHeap.poll();
            }
        }

    }
    
    public int add(int val) {
        minHeap.add(val);
        if(minHeap.size()!=reqSize){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}