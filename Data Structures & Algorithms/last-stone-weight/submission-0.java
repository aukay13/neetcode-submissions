class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(Integer i:stones){
            maxHeap.add(i);
        }

        while (maxHeap.size()!=1) {
            maxHeap.add(maxHeap.poll()-maxHeap.poll());
        }

        return maxHeap.peek();
    }
}