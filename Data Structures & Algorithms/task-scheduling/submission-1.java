class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for(char i:tasks){
            freq[i-'A']++;
        }

        int time = 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i:freq){
            if(i!=0){
                maxHeap.add(i);
            }
        }

        Queue<int[]> q = new LinkedList<>();

        while (true) {
            if(maxHeap.isEmpty() && q.isEmpty()){
                break;
            }
            time++;
            if(!q.isEmpty() && q.peek()[1]<=time){
                maxHeap.add(q.poll()[0]);
            }

            if(!maxHeap.isEmpty()){
                int elementFromHeap = maxHeap.poll();
                if(elementFromHeap!=1){
                    q.add(new int[]{elementFromHeap-1,time+n+1});
                }
            }
            else{
                if(!q.isEmpty()){
                    time = q.peek()[1]-1;
                    maxHeap.add(q.poll()[0]);
                }
            }
        }

        return time;
    }
}
