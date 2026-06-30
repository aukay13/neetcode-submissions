class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        int ans = high;

        while (low<=high) {
            int mid = (low+high)/2;
            if(canEatBanana(mid,piles,h)){
                ans = mid;
                high= mid - 1;
            }
            else{
                low = mid + 1;
            }

        }
        return ans;
    }

        public boolean canEatBanana(int mid, int[]piles, int h){
        int hours = 0;
        for(int i: piles){
            if(mid >= i){
                hours++;
            }
            else{
                if(i%mid==0){
                    hours += i/mid;
                }
                else{
                    hours += (i/mid)+1;
                }
            }
        }
        if(hours>h){
            return false;
        }
        return true;
    }
}
