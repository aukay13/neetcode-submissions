class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<k;i++){
            while (!dq.isEmpty() && dq.getLast()<nums[i]) {
                dq.removeLast();
            }
            dq.addLast(nums[i]);
        }

        ans.add(dq.getFirst());

        int l=0,r=k;
        while (r<nums.length) {
            if(nums[l]==dq.getFirst()){
                dq.removeFirst();
            }
            l++;

            while (!dq.isEmpty() && dq.getLast()<nums[r]) {
                dq.removeLast();
            }
            dq.addLast(nums[r]);
            ans.add(dq.getFirst());
            r++;
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
