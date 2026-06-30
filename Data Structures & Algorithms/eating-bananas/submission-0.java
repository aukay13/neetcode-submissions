class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int max = 0;
        int ans = -1;

        for(int i: piles){
            if(i>max){
                max = i;
            }
        }

        int high = max;


        while(low <= high) {
            int mid = low + (high-low)/2;
            
            if(isBananEatable(piles, mid, h)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }

        public static boolean isBananEatable(int[] piles, int mid, int h){
        int totalHours = 0;

        for(int i=0;i<piles.length;i++){
            if(piles[i]<=mid){
                totalHours++;
            }
            else{
                if(piles[i]%mid==0){
                    totalHours += piles[i]/mid;
                }
                else{
                    totalHours += piles[i]/mid + 1;
                }
            }
        }

        if(totalHours<=h){
            return true;
        }
        return false;
    }

}
